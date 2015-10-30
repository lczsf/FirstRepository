package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.BatchOrderClientAPI;
import com.wdk.wms.basic.dal.dao.BatchOrderDAO;
import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.query.parameters.BatchOrderQuery;
import com.wdk.wms.basic.result.PageResult;


/****
 * 
 * @author wb-cengxi 
 * 创建人：曾曦 
 * 创建时间：2015.9.28 
 * 修改时间：2015.9.28
 * 
 */
public class BatchOrderClientAPIImpl  implements BatchOrderClientAPI{
	@Autowired
	private BatchOrderDAO batchDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public long insertBatchOrder(BatchOrderDO OrderBatchDO) {
	
		return batchDAO.insertBasicOrder(OrderBatchDO);
	}

	@Override
	public int updateBatchOrder(BatchOrderDO OrderBatchDO) {

		return batchDAO.updateBasicOrder(OrderBatchDO);
	}

	@Override
	public List<BatchOrderDO> queryListBatchOrder(BatchOrderQuery OrderBatchQuery) {
		return batchDAO.queryBasicOrder(OrderBatchQuery);
	}

	@Override
	public PageResult<BatchOrderDO> queryPageBatchOrder(BatchOrderQuery OrderBatchQuery) {
		PageResult<BatchOrderDO> response = new PageResult<BatchOrderDO>();
		List<BatchOrderDO> results = new ArrayList<BatchOrderDO>();
		results = batchDAO.queryBasicOrder(OrderBatchQuery);
		response.setList(results);

		// 总条数
		int count = batchDAO.queryArrivalNoticeCount(OrderBatchQuery);

		response.setNum(OrderBatchQuery.getNum());
		response.setTotalNum(count);
		response.setIndex(OrderBatchQuery.getIndex());
		return response;
	}
	
	@Override
	public BatchOrderDO queryBatchOrderByBatchCodeAndWhId(Long externalBatchCode, long warehouseId) {
		return batchDAO.queryBatchOrderByBatchCodeAndWhId(externalBatchCode, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public BatchOrderDO queryByWaveId(Long waveId, Long warehouseId) {
		return batchDAO.queryByWaveId(waveId, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}
}
