package com.wdk.wms.basic.query.parameters;

public class SortingGoodsPartitionUserQuery extends BaseQuery {
	private Long userId;

	private Long sortingGoodsPartitionId;

	private Integer status;

	private Long warehouseId;

	private Integer type;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSortingGoodsPartitionId() {
		return sortingGoodsPartitionId;
	}

	public void setSortingGoodsPartitionId(Long sortingGoodsPartitionId) {
		this.sortingGoodsPartitionId = sortingGoodsPartitionId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
