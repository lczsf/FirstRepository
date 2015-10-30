package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.wdk.wms.basic.daoobject.InventoryLogDO;

@Dao("inventory_log")
public interface InventoryLogDAO {

	@Insert
	public long insertInventoryLog(InventoryLogDO inventoryLogDO);
}
