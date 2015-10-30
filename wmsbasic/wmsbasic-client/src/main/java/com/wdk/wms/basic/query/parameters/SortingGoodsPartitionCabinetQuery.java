package com.wdk.wms.basic.query.parameters;

public class SortingGoodsPartitionCabinetQuery extends BaseQuery {
	private String sortingGoodsPartitionCode;

	private Long warehouseId;

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getSortingGoodsPartitionCode() {
		return sortingGoodsPartitionCode;
	}

	public void setSortingGoodsPartitionCode(String sortingGoodsPartitionCode) {
		this.sortingGoodsPartitionCode = sortingGoodsPartitionCode;
	}

}
