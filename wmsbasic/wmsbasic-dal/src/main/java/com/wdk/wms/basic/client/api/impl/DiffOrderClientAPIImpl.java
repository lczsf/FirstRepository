package com.wdk.wms.basic.client.api.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.DiffOrderClientAPI;
import com.wdk.wms.basic.common.WdkWmsSerialNumberUtil;
import com.wdk.wms.basic.dal.dao.DiffOrderDAO;
import com.wdk.wms.basic.dal.dao.DiffOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;
import com.wdk.wms.basic.query.parameters.DiffOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.DiffOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class DiffOrderClientAPIImpl implements DiffOrderClientAPI {

	@Autowired
	DiffOrderDAO diffOrderDAO;

	@Autowired
	DiffOrderDetailDAO diffOrderDetailDAO;

	@Autowired
	WarehouseDAO warehouseDAO;

	@Autowired
	WdkWmsSerialNumberUtil wdkWmsSerialNumberUtil;

	@Override
	public PageResult<DiffOrderDO> queryDiffOrder(DiffOrderQuery diffOrderQuery) {

		diffOrderQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(diffOrderQuery.getWarehouseId())); // 设置分表code
		// 返回数据
		PageResult<DiffOrderDO> response = new PageResult<DiffOrderDO>();

		List<DiffOrderDO> results;

		// 当前页数据
		results = diffOrderDAO.queryDiffOrder(diffOrderQuery);
		// 总条数
		int count = diffOrderDAO.queryDiffOrderCount(diffOrderQuery);

		response.setNum(diffOrderQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(diffOrderQuery.getIndex());
		return response;
	}

	@Override
	public long insertDiffOrder(DiffOrderDO diffOrderDO) {
		diffOrderDO.setCode(wdkWmsSerialNumberUtil.createCode(diffOrderDO.getWarehouseId(), "CY", "CYD"));// 差异单code
		return diffOrderDAO.insertDiffOrder(diffOrderDO);
	}

	@Override
	public long insertDiffOrderDetail(DiffOrderDetailDO diffOrderDetailDO) {

		return diffOrderDetailDAO.insertDiffOrderDetail(diffOrderDetailDO);
	}


	@Override
	public PageResult<DiffOrderDetailDO> queryDiffOrderDetailPage(DiffOrderDetailQuery diffOrderDetailQuery) {

		diffOrderDetailQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(diffOrderDetailQuery.getWarehouseId()));
		// 返回数据
		PageResult<DiffOrderDetailDO> response = new PageResult<DiffOrderDetailDO>();

		List<DiffOrderDetailDO> results;

		// 当前页数据
		results = diffOrderDetailDAO.queryDiffOrderDetail(diffOrderDetailQuery);
		// 总条数
		int count = diffOrderDetailDAO.queryDiffOrderDetailCount(diffOrderDetailQuery);

		response.setNum(diffOrderDetailQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(diffOrderDetailQuery.getIndex());
		return response;
	}

}
