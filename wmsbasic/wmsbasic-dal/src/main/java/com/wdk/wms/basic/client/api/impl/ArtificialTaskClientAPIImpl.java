package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.client.api.ArtificialTaskClientAPI;
import com.wdk.wms.basic.dal.dao.ArtificialTaskDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.ArtificialTaskDO;
import com.wdk.wms.basic.enums.ArtificialTaskStatusEnum;
import com.wdk.wms.basic.query.parameters.ArtificialTaskQuery;
import com.wdk.wms.basic.result.PageResult;

public class ArtificialTaskClientAPIImpl implements ArtificialTaskClientAPI {

	@Autowired
	private ArtificialTaskDAO artificialTaskDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public long insertArtificialTask(ArtificialTaskDO artificialTaskDO) {

		return artificialTaskDAO.insertArtificialTask(artificialTaskDO);
	}

	@Override
	public PageResult<ArtificialTaskDO> queryArtificialTaskPage(ArtificialTaskQuery artificialTaskQuery) {
		PageResult<ArtificialTaskDO> response = new PageResult<ArtificialTaskDO>();
		List<ArtificialTaskDO> results = Lists.newArrayList();
		artificialTaskQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(artificialTaskQuery.getWarehouseId())); // 设置分表code
		results = artificialTaskDAO.queryArtificialTask(artificialTaskQuery);
		response.setList(results);

		// 总条数
		int count = artificialTaskDAO.queryArtificialTaskCount(artificialTaskQuery);

		response.setNum(artificialTaskQuery.getNum());
		response.setTotalNum(count);
		response.setIndex(artificialTaskQuery.getIndex());
		return response;
	}

	@Override
	public ArtificialTaskDO queryArtificialTaskById(Long id, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return artificialTaskDAO.queryArtificialTaskById(id, warehouseCode);
	}

	@Override
	public int updateStatus(Long id, Long warehouseId, int status) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		if (status == ArtificialTaskStatusEnum.FINISH.getIndex())// 状态为创建则更新为完成
			return artificialTaskDAO.updateStatus(id, warehouseCode, ArtificialTaskStatusEnum.CREATE.getIndex(), ArtificialTaskStatusEnum.FINISH.getIndex());
		else
			return artificialTaskDAO.updateStatus(id, warehouseCode, ArtificialTaskStatusEnum.FINISH.getIndex(), ArtificialTaskStatusEnum.CREATE.getIndex());
	}

}
