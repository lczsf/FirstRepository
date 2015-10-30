package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.BackContainerOrderClientAPI;
import com.wdk.wms.basic.dal.dao.BackContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.query.parameters.BackContainerOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class BackContainerOrderClientAPIImpl implements BackContainerOrderClientAPI {

	@Autowired
	private BackContainerOrderDAO backContainerOrderDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public PageResult<BackContainerOrderDO> queryBackContainerOrderPage(BackContainerOrderQuery backContainerOrderQuery) {
		PageResult<BackContainerOrderDO> response = new PageResult<BackContainerOrderDO>();
		List<BackContainerOrderDO> results;

		// 当前页数据
		results = backContainerOrderDAO.queryBackContainerOrder(backContainerOrderQuery);
		// 总条数
		int count = backContainerOrderDAO.queryBackContainerOrderCount(backContainerOrderQuery);
		response.setNum(backContainerOrderQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(backContainerOrderQuery.getIndex());
		return response;
	}

	@Override
	public long insertBackContainerOrder(BackContainerOrderDO backContainerOrderDO) {

		return backContainerOrderDAO.insertBackContainerOrder(backContainerOrderDO);
	}

	@Override
	public long insertBackContainerOrderList(List<BackContainerOrderDO> backContainerOrderDOs) {

		return backContainerOrderDAO.insertBackContainerOrderList(backContainerOrderDOs);
	}

	@Override
	public List<BackContainerOrderDO> queryBackContainerOrderByWaveId(Long waveId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return backContainerOrderDAO.queryBackContainerOrderByWaveId(waveId, warehouseId, warehouseCode);
	}

}
