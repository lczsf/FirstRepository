package com.wdk.wms.basic.client.api.impl;

import com.wdk.wms.basic.dal.dao.InventoryOccupancyDAO;
import com.wdk.wms.basic.daoobject.InventoryOccupancyDO;
import com.wdk.wms.basic.enums.SourceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.InventoryOccupancyClientAPI;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;

import java.util.List;

/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/10/12
 */
public class InventoryOccupancyClientAPIImpl implements InventoryOccupancyClientAPI {

	@Autowired
	private InventoryOccupancyDAO inventoryOccupancyDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public Long insertInventoryOccupancyDO(InventoryOccupancyDO inventoryOccupancyDO) {
		return inventoryOccupancyDAO.insertInventoryOccupancyDO(inventoryOccupancyDO);
	}

	@Override
	public List<InventoryOccupancyDO> queryByWaveId(Long WaveId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return inventoryOccupancyDAO.queryByWaveId(warehouseId, warehouseCode, warehouseId);
	}

	@Override
	public int updateOccupancyOrderId(Long id, Long occupancyOrderId, int occupancyOrderType, Long warehouseId, Long waveId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return inventoryOccupancyDAO.updateOccupancyOrder(id, occupancyOrderId, occupancyOrderType, warehouseId, warehouseCode, waveId);
	}

	@Override
	public List<InventoryOccupancyDO> queryByOccupancyOrderId(Long warehouseId, Long waveId, int occupancyOderType, List<Long> occupancyOrderIds) {
		return inventoryOccupancyDAO.queryByOccupancyOrderId(warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId), waveId, occupancyOderType,
				occupancyOrderIds);
	}
}
