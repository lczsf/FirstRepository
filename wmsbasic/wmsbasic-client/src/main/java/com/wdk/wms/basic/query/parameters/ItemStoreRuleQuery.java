package com.wdk.wms.basic.query.parameters;

public class ItemStoreRuleQuery extends BaseQuery {

	/**
	 * 商品编码
	 */
	private String itemCode;

	/**
	 * 存储规则类型
	 */
	private Integer storeType;

	/**
	 * 仓库id
	 */
	private Long warehouseId;


	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getStoreType() {
		return storeType;
	}

	public void setStoreType(Integer storeType) {
		this.storeType = storeType;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}


}
