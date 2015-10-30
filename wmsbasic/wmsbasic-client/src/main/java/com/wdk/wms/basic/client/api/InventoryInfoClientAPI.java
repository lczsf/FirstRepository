package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.InventoryInfoDO;

import java.util.List;

/**
 * Description: 库存信息接口
 *
 * @author 刘勇
 * @Date 15/10/13
 */
public interface InventoryInfoClientAPI {

	/**
	 * 通过商品id 查询库存
	 * 
	 * @param itemId
	 *            商品id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	List<InventoryInfoDO> queryByItemId(long itemId, long warehouseId);
}
