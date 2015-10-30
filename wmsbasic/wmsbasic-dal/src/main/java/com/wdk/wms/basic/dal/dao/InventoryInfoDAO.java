package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.InventoryInfoAndBatchDO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;

@Dao("inventory_info")
public interface InventoryInfoDAO {

	/**
	 * 插入一条新库存
	 */
	@Insert
	public long insertInventoryInfo(InventoryInfoDO inventoryInfoDO);

	@Select
	public List<InventoryInfoAndBatchDO> queryAllInventory();

	/**
	 * 查询可利用库存，用于出库,会连表查询出批属性信息
	 */
	@Select
	public List<InventoryInfoAndBatchDO> queryInventory(InventoryInfoQuery inventoryInfoQueryParamter);

	/**
	 * 更新库存
	 */
	@Update
	public int updateInventoryInfo(InventoryInfoDO inventoryInfoDO);

	/**
	 * 查询具体的某一条库存记录
	 */
	@Select
	public InventoryInfoDO querySingleInventory(InventoryInfoQuery inventoryInfoQueryParamter);

	/**
	 * 更新库存占用状态所
	 */
	@Update
	public int updateInventoryInfoStatus(InventoryInfoQuery inventoryInfoQuery);

	/**
	 * 条件查询多条
	 * 
	 * @param inventoryInfoQuery
	 * @return
	 */
	@Select
	public List<InventoryInfoDO> queryListInventory(InventoryInfoQuery inventoryInfoQuery);

	/**
	 * 查询指定库位类型上商品库存
	 * 
	 * @param inventoryInfoQuery
	 * @return
	 */
	@Select
	public List<InventoryInfoAndBatchDO> queryInventoryByCabinetType(InventoryInfoQuery inventoryInfoQuery);

	/**
	 * 通过库位类型 锁住库存信息
	 * 
	 * @param inventoryInfoQuery
	 * @return
	 */
	@Update
	public int updateInventoryInfoStatusByCabinetType(InventoryInfoQuery inventoryInfoQuery);

}
