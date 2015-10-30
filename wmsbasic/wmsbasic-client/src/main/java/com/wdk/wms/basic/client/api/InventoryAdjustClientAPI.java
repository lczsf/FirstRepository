package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.InventoryAdjustDO;
import com.wdk.wms.basic.daoobject.InventoryAdjustDetailDO;
import com.wdk.wms.basic.query.parameters.InventoryAdjustQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * 库存调整单
 * 
 * @author 川丘
 * @date 2015年10月29日
 */
public interface InventoryAdjustClientAPI {

	/**
	 * 插入到库存调整单主表
	 */
	public long insertOrUpdateInventoryAdjust(InventoryAdjustDO inventoryAdjustDO);

	/**
	 * 插入到库存调整单详情记录
	 */
	public long insertOrUpdateInventoryAdjustDetail(InventoryAdjustDetailDO inventoryAdjustDetailDO);

	/**
	 * 查询到库存调整单主表
	 */
	public PageResult<InventoryAdjustDO> queryInventoryAdjust(InventoryAdjustQuery inventoryAdjustQuery);

	/**
	 * 根据库存调整单id,获取明细记录
	 */
	public List<InventoryAdjustDetailDO> queryInventoryAdjustDetail(long inventoryAdjustId, Long warehouseId);

	/**
	 * 通过id获取库存调整单
	 * 
	 * @param id
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public InventoryAdjustDO queryById(Long id, Long warehouseId);

	/**
	 * 通过id获取库存调整单明细
	 * 
	 * @param id
	 * @param warehouseId
	 * @return
	 */
	public InventoryAdjustDetailDO queryDetailById(Long id, Long warehouseId);

}
