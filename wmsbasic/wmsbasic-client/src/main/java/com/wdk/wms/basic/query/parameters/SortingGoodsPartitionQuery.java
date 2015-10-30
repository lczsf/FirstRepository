package com.wdk.wms.basic.query.parameters;

public class SortingGoodsPartitionQuery extends BaseQuery {

	/**
	 * 区域编码
	 */
	private String code;

	/**
	 * 区域名称
	 */
	private String name;

	/**
	 * 仓库id
	 * 
	 */
	private Long warehouseId;

	/**
	 * 类型
	 */
	private Integer type;

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

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
