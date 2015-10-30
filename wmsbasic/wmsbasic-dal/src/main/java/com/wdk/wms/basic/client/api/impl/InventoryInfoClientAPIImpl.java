package com.wdk.wms.basic.client.api.impl;

import com.wdk.wms.basic.client.api.InventoryInfoClientAPI;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description: 库存API 实现
 *
 * @author 刘勇
 * @Date 15/10/13
 */
public class InventoryInfoClientAPIImpl implements InventoryInfoClientAPI {

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private InventoryInfoDAO inventoryInfoDAO;

	@Override
	public List<InventoryInfoDO> queryByItemId(long itemId, long warehouseId) {
		InventoryInfoQuery inventoryInfoQuery = new InventoryInfoQuery();
		inventoryInfoQuery.setItemId(itemId); // 商品id
		inventoryInfoQuery.setWarehouseId(warehouseId); // 仓库id
		inventoryInfoQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(warehouseId)); // 分表code
		return inventoryInfoDAO.queryListInventory(inventoryInfoQuery);
	}
}
