package com.wdk.wms.basic.query.parameters;

public class PartnerWhQuery extends BaseQuery {

	/**
	 * 货主姓名name
	 */
	private String name;

	/**
	 * 类型0库区，1库位
	 */
	private Integer type;

	/**
	 * 关联关系0归属，1推荐
	 */
	private Integer relation;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 仓库id
	 */
	private Long warehouseId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRelation() {
		return relation;
	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	
}
