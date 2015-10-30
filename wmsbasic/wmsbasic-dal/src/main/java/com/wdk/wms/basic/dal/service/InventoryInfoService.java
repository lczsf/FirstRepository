package com.wdk.wms.basic.dal.service;

/**
 * Description: 库存服务
 *
 * @author 刘勇
 * @Date 15/10/29
 */
public interface InventoryInfoService {

	/**
	 * 扣减库存
	 * 
	 * @param id
	 *            id
	 * @param warehouseId
	 *            仓库id
	 * @param orderOccupy
	 *            占用数量
	 * @param deduction
	 *            扣减数量
	 * @param itemId
	 *            商品id
	 * @param docType
	 *            来源单据类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param docId
	 *            来源单据id
	 * @return
	 */
	int updateDeduction(long id, long warehouseId, double orderOccupy, double deduction, long itemId, int docType, long docId);
}
