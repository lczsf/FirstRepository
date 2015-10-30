package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.SalesOrderClientAPI;
import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.dal.dao.BatchOrderDAO;
import com.wdk.wms.basic.dal.dao.SalesOrderDAO;
import com.wdk.wms.basic.dal.dao.SalesOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WaveOrderDAO;
import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.query.parameters.SalesOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.SalesOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class SalesOrderClientAPIImpl implements SalesOrderClientAPI {

	@Autowired
	private SalesOrderDAO salesOrderDAO;

	@Autowired
	private SalesOrderDetailDAO salesOrderDetailDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private WaveOrderDAO waveOrderDAO;

	@Autowired
	private BatchOrderDAO batchOrderDAO;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private CommonService commonService;

	final private Logger log = LoggerFactory.getLogger(SalesOrderClientAPIImpl.class);

	/**
	 * 订单接口
	 */
	@Override
	public PageResult<SalesOrderDO> querySalesOrderPage(SalesOrderQuery salesOrderDOQuery) {
		salesOrderDOQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(salesOrderDOQuery.getWarehouseId()));// 设置仓库分表code
		// 返回数据
		PageResult<SalesOrderDO> response = new PageResult<SalesOrderDO>();

		List<SalesOrderDO> results;

		// 当前页数据
		results = salesOrderDAO.querySalesOrder(salesOrderDOQuery);
		// 总条数
		int count = salesOrderDAO.querySalesOrderCount(salesOrderDOQuery);

		response.setNum(salesOrderDOQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(salesOrderDOQuery.getIndex());
		return response;
	}

	@Override
	public long insertSalesOrder(SalesOrderDO salesOrderDO) {

		return salesOrderDAO.insertSalesOrder(salesOrderDO);
	}

	@Override
	public int updateSalesOrder(SalesOrderDO salesOrderDO) {
		salesOrderDO.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(salesOrderDO.getWarehouseId()));
		return salesOrderDAO.updateSalesOrder(salesOrderDO);
	}

	@Override
	public SalesOrderDO querySalesOrderById(Long id, Long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDAO.querySalesOrderById(id, warehouseId, warehouseCode);
	}

	/**
	 * 订单详情接口
	 */

	@Override
	public PageResult<SalesOrderDetailDO> querySalesOrderDetailPage(SalesOrderDetailQuery salesOrderDODetailQuery) {
		salesOrderDODetailQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(salesOrderDODetailQuery.getWarehouseId()));// 设置仓库分表code
		// 返回数据
		PageResult<SalesOrderDetailDO> response = new PageResult<SalesOrderDetailDO>();

		List<SalesOrderDetailDO> results;

		// 当前页数据
		results = salesOrderDetailDAO.querySalesOrderDetail(salesOrderDODetailQuery);
		// 总条数
		int count = salesOrderDetailDAO.querySalesOrderDetailCount(salesOrderDODetailQuery);

		response.setNum(salesOrderDODetailQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(salesOrderDODetailQuery.getIndex());
		return response;
	}

	@Override
	public long insertSalesOrderDetail(SalesOrderDetailDO salesOrderDetailDO) {

		return salesOrderDetailDAO.insertSalesOrderDetail(salesOrderDetailDO);

	}

	@Override
	public int updateStatusById(int status, long id, long waveId, long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDetailDAO.updateStatusById(status, id, waveId, warehouseCode);
	}



	@Override
	public int insertWholeSalesOrder(final WaveOrderDO waveOrderDO, final SalesOrderDO salesOrderDO, final List<SalesOrderDetailDO> salesOrderDetailDOs) {
		int status = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {

				long salesId = 0;
				long waveId = 0;
				try {
					waveId = waveOrderDAO.insertWaveOrder(waveOrderDO);// 插入波次
					salesOrderDO.setWaveId(waveId);// 设置波次Id
					salesId = salesOrderDAO.insertSalesOrder(salesOrderDO);// 插入销售主订单
				} catch (Exception e) {
					status.setRollbackOnly();// 回滚
					return commonService.checkException(e, "Duplicate entry", "销售主订单违法唯一键约束！", 0, -1);
				}
				// 插入销售子订单
				for (SalesOrderDetailDO salesOrderDetailDO : salesOrderDetailDOs) {
					salesOrderDetailDO.setWaveId(waveId);
					try {
						salesOrderDetailDO.setSalesOrderId(salesId);
						salesOrderDetailDAO.insertSalesOrderDetail(salesOrderDetailDO);
					} catch (Exception e) {
						status.setRollbackOnly(); // 回滚
						return commonService.checkException(e, "Duplicate entry", "销售子订单违法唯一键约束！", -2, -1);
					}
				}
				// 插入销售子订单
				return 1;// 插入成功
			}
		});
		return status;
	}

	@Override
	public int queryChildOrderQuanityByWaveId(Long waveId, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDetailDAO.queryByWaveIdNoStatus(waveId, warehouseCode);
	}

	@Override
	public SalesOrderDO querySalesOrderByOutCode(String externalSalesNumber, Long outBatchCode, long ownerId, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDAO.querySalesOrderByOutCode(externalSalesNumber, outBatchCode, ownerId, warehouseId, warehouseCode);
	}

	@Override
	public List<SalesOrderDO> querySalesOrdersByWaveOrderId(Long waveId, Long warehouseId, Long warehouseCode) {
		return salesOrderDAO.queryByWaveId(waveId, warehouseId, warehouseCode);
	}

	@Override
	public List<SalesOrderDetailDO> querySalesOrderDetailsByWaveOrderId(int status, Long salesOrderId, Long waveId, Long warehouseCode) {
		return salesOrderDetailDAO.queryByWaveId(status, salesOrderId, waveId, warehouseCode);
	}

	@Override
	public SalesOrderDetailDO queryDetailBySubOrderId(long subOrderId, long waveId, long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDetailDAO.queryDetailBySubOrderId(subOrderId, waveId, warehouseCode);
	}

	@Override
	public SalesOrderDO querySalesOrderByOutBatchCode(Long outBatchCode, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDAO.querySalesOrderByOutBatchCode(outBatchCode, warehouseId, warehouseCode);
	}

	@Override
	public int updateAllCompensationAmount(final SalesOrderDO salesOrderDO, final List<SalesOrderDetailDO> salesOrderDetailDOs) {
		int status = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					int updateMain=salesOrderDAO.updateCompensationAmount(salesOrderDO.getId(), salesOrderDO.getCompensationAmount(), salesOrderDO.getWarehouseId(),
 salesOrderDO.getWarehouseCode());// 更新主订单
					if(updateMain==0){
						return 0;// 更新主订单失败返回0
					}
					int updateChild;
					for (SalesOrderDetailDO detail : salesOrderDetailDOs) {
						updateChild = salesOrderDetailDAO.updateRefundAmount(detail.getId(), detail.getRefundAmount(), detail.getWaveId(),
								detail.getWarehouseCode());// 更新子订单
						if (updateChild == 0) {
							status.setRollbackOnly(); // 回滚
							return 0;// 更新子订单失败返回0
						}
					}
				} catch (Exception e) {
					status.setRollbackOnly(); // 回滚
					// 异常回滚
					log.info("数据库更新异常" + e);
				}
				return 1;// 更新成功
			}
		});
		return status;
	}

	@Override
	public int updateMainSortNumberByWaveId(long waveId, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return salesOrderDetailDAO.updateMainSortNumberByWaveId(waveId, warehouseCode);
	}
}
