package com.wdk.wms.basic.query.parameters;

public class ItemQuery extends BaseQuery {

	/**
	 * 商品编码(所属业务组别)+sku唯一，一般存放sku
	 */
	private String code;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 库区id
	 */
	private Long warehouseAreaId;

	/**
	 * 状态
	 */
	private Integer status;

	public Long getWarehouseAreaId() {
		return warehouseAreaId;
	}

	public void setWarehouseAreaId(Long warehouseAreaId) {
		this.warehouseAreaId = warehouseAreaId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
