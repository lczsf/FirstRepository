package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.ParceClientAPI;
import com.wdk.wms.basic.client.api.ParceTransactionClientAPI;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.ParceDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WaveOrderDAO;
import com.wdk.wms.basic.daoobject.ParcelDO;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.enums.PickingContainerStatusEnum;
import com.wdk.wms.basic.enums.WaveOrderStatusEnum;

public class ParceTransactionClientAPIImpl implements ParceTransactionClientAPI {

	private static final Logger log = LoggerFactory.getLogger(ParceTransactionClientAPIImpl.class);

	@Autowired
	private ContainerDAO containerDAO;

	@Autowired
	private PickingContainerDAO pickingContainerDAO;

	@Autowired
	private WaveOrderDAO waveOrderDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private ParceDAO basicParceDAO;

	@Autowired
	private ParceClientAPI parceClientAPI; // 包裹

	@Override
	public boolean afterScanContainerUpdate(final Long warehouseId, final Long waveId, final List<String> containerCodes, final long operatorId,
			final boolean isUpdateWave) {

		return (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					int reslut;
					reslut = containerDAO.updateContainerByCodes(ContainerStatusEnum.Free.getIndex(), containerCodes, warehouseId, operatorId);
					if (reslut <= 0) {
						throw new Exception("容器更新失败");
					}
					reslut = pickingContainerDAO.updatePickingContainerStatus(PickingContainerStatusEnum.FINISHED.getIndex(), waveId, warehouseId,
							warehouseDAO.queryWarehouseCodeById(warehouseId), operatorId);
					if (reslut <= 0) {
						throw new Exception("拣货装箱单更新失败");
					}
					if (isUpdateWave) {
						reslut = waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.FINISH.getIndex(), warehouseId,
								warehouseDAO.queryWarehouseCodeById(warehouseId));
						if (reslut <= 0) {
							throw new Exception("波次状态更新失败");
						}
					}

					return true;
				} catch (Exception e) {
					e.printStackTrace();
					status.setRollbackOnly(); // 回滚
					return false;
				}
			}
		});
	}

	@Override
	public boolean afterParcelUpdate(final Long waveId, final String parcelNumber, final long warehouseId) {

		return (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					int result = 0;
					// 分表code
					Long warehouseSplitCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
					result = waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.PACKAGED.getIndex(), warehouseId, warehouseSplitCode);
					result = waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.FINISH.getIndex(), warehouseId, warehouseSplitCode);
					if (result <= 0) {
						throw new Exception("波次状态更新失败");
					}
					ParcelDO parcelDO = basicParceDAO.queryByWaveId(waveId, warehouseSplitCode);
					if (parcelDO == null) {
						throw new NullPointerException("查询不到打包数据");
					}
					parcelDO.setParcelNumber(parcelNumber);
					result = basicParceDAO.updateBasicParcel(parcelDO);
					if (result <= 0) {
						throw new Exception("包裹号更新失败");
					}
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					log.error("打包完成更新状态出错", e);
					status.setRollbackOnly(); // 回滚
					return false;
				}
			}
		});
	}
}
