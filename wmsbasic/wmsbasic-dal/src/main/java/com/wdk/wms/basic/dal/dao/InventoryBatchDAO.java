package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.wdk.wms.basic.daoobject.InventoryBatchDO;

import java.util.Date;

@Dao("inventory_batch")
public interface InventoryBatchDAO {

	@Insert
	public long insertInventoryBatch(InventoryBatchDO inventoryBatchDO);

	@Select
	public InventoryBatchDO queryInventoryBatchDO(@Param("produceDate") Date produceDate, @Param("arriveDate") Date arriveDate);

	@Select
	public InventoryBatchDO queryById(Long id);
}
