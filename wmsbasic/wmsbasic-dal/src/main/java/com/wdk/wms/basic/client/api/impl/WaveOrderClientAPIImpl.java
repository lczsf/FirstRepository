package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.dal.dao.*;
import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;
import com.wdk.wms.basic.out.order.parameters.SaleOrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.WaveOrderClientAPI;
import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.query.parameters.WaveOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/****
 * 
 * @author wb-cengxi 
 * 创建人：曾曦 
 * 创建时间：2015.9.28 
 * 修改时间：2015.9.28
 * 
 */
public class WaveOrderClientAPIImpl implements WaveOrderClientAPI{


	@Autowired
	private WaveOrderDAO waveOrderDAO;

	@Autowired
	private BatchOrderDAO batchOrderDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private SalesOrderDAO salesOrderDAO;

	@Autowired
	private SalesOrderDetailDAO salesOrderDetailDAO;

	@Autowired
	private CommonService commonService;

	final private Logger log = LoggerFactory.getLogger(WaveOrderClientAPIImpl.class);
	
	// 增加
	public long insertWaveOrder(WaveOrderDO waveOrderDO){
		return waveOrderDAO.insertWaveOrder(waveOrderDO);
	}

	// 删除
	public int deleteWaveOrder(long id, long warehouseId) {
		return waveOrderDAO.deleteWaveOrder(id, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	// 修改
	public int updateWaveOrder(WaveOrderDO waveOrderDO){
		return waveOrderDAO.updateWaveOrder(waveOrderDO);
	}

	// 查找
	@Override
	public List<WaveOrderDO> queryWaveOrder(WaveOrderQuery waveOrderQuery){
		return waveOrderDAO.queryWaveOrder(waveOrderQuery);
	}

	// 分页(查询总行数)
	@Override
	public PageResult<WaveOrderDO> deleteWaveOrder(WaveOrderQuery waveOrderQuery){
		PageResult<WaveOrderDO> response = new PageResult<WaveOrderDO>();
		List<WaveOrderDO> results = new ArrayList<WaveOrderDO>();
		results = waveOrderDAO.queryWaveOrder(waveOrderQuery);
		response.setList(results);

		// 总条数
		int count = waveOrderDAO.queryCountWaveOrder(waveOrderQuery);

		response.setNum(waveOrderQuery.getNum());
		response.setTotalNum(count);
		response.setIndex(waveOrderQuery.getIndex());
		return response;
	}

	


	@Override
	public int insertWaveBatchAndOrder(final WaveOrderDO waveOrderDO, final BatchOrderDO batchOrderDO, final List<SaleOrderInfo> saleOrderInfos) {
		return (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {
					long waveOrderId = waveOrderDAO.insertWaveOrder(waveOrderDO); // 插入波次
					batchOrderDO.setWaveId(waveOrderId); // 关联波次
					batchOrderDAO.insertBasicOrder(batchOrderDO); // 插入批次
					return insertSalesOrder(saleOrderInfos, waveOrderId); // 插入销售主子表
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
					return commonService.checkException(e, "Duplicate entry", "违法波次唯一键约束!", 0, -1);
				}
			}
		});
	}

	@Override
	public WaveOrderDO queryWaveOrderById(long waveId, long warehouseId) {
		return waveOrderDAO.queryWaveOrderById(waveId, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public int updateStatus(long waveId, int waveStatus, long warehouseId) {
		return waveOrderDAO.updateStatusById(waveId, waveStatus, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public int updateStatusAndStruction(long waveId, int waveStatus, int descriptionType, long warehouseId) {
		return waveOrderDAO.updateStatusAndStruction(waveId, waveStatus, descriptionType, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public int updateNotifyStatus(long waveId, long warehouseId) {
		return waveOrderDAO.updateNotifyStatus(waveId, 1, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	/**
	 * 插入 销售订单主子表数据
	 * 
	 * @param saleOrderInfos
	 * @param waveId
	 *            波次id
	 * @return -1 系统异常 1 成功 -2 销售主订单违法唯一约束 -3 销售子订单违法唯一约束
	 */
	private int insertSalesOrder(final List<SaleOrderInfo> saleOrderInfos, final long waveId) {

		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				long salesId = 0;
				for (SaleOrderInfo saleOrderInfo : saleOrderInfos) {
					try {
						SalesOrderDO salesOrderDO = saleOrderInfo.getSalesOrderDO();
						salesOrderDO.setWaveId(waveId);// 设置波次Id
						salesId = salesOrderDAO.insertSalesOrder(salesOrderDO);// 插入销售主订单
					} catch (Exception e) {
						status.setRollbackOnly(); // 回滚
						return commonService.checkException(e, "Duplicate entry", "销售主订单违法唯一键约束！", -2, -1);
					}
					// 插入销售子订单
					for (SalesOrderDetailDO salesOrderDetailDO : saleOrderInfo.getSalesOrderDetailDOs()) {
						try {
							salesOrderDetailDO.setWaveId(waveId);
							salesOrderDetailDO.setSalesOrderId(salesId);
							salesOrderDetailDAO.insertSalesOrderDetail(salesOrderDetailDO);
						} catch (Exception e) {
							status.setRollbackOnly(); // 回滚
							return commonService.checkException(e, "Duplicate entry", "销售子订单违法唯一键约束！", -3, -1);
						}
					}
				}
				// 插入销售子订单
				return 1;// 插入成功
			}
		});
	}
}
