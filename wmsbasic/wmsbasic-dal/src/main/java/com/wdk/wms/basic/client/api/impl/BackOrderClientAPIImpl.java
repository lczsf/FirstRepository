package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.BackOrderClientAPI;
import com.wdk.wms.basic.dal.dao.BackOrderDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BackOrderDO;
import com.wdk.wms.basic.query.parameters.BackOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class BackOrderClientAPIImpl implements BackOrderClientAPI {

	@Autowired
	private BackOrderDAO backOrderDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public PageResult<BackOrderDO> queryBackOrderPage(BackOrderQuery backOrderQuery) {
		PageResult<BackOrderDO> response = new PageResult<BackOrderDO>();
		List<BackOrderDO> results;

		// 当前页数据
		results = backOrderDAO.queryBackOrder(backOrderQuery);
		// 总条数
		int count = backOrderDAO.queryBackOrderCount(backOrderQuery);
		response.setNum(backOrderQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(backOrderQuery.getIndex());
		return response;
	}

	@Override
	public long insertBackOrder(BackOrderDO backOrderDO) {

		return backOrderDAO.insertBackOrder(backOrderDO);
	}

	@Override
	public List<BackOrderDO> queryBackOrderByWaveId(Long waveId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return backOrderDAO.queryBackOrderByWaveId(waveId, warehouseId, warehouseCode);
	}

	@Override
	public List<BackOrderDO> queryByItemIdAndStatus(long itemId, int status, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return backOrderDAO.queryByItemIdAndStatus(itemId, status, warehouseId, warehouseCode);
	}

}
