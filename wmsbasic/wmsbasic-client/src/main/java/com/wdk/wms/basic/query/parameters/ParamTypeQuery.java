package com.wdk.wms.basic.query.parameters;

/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/9/14
 */
public class ParamTypeQuery extends BaseQuery {

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
}
