package com.wdk.wms.basic.query.parameters;

public class DiffOrderDetailQuery extends BaseQuery {
	/**
	 * 差异单id，FK
	 */
	private Long diffOrderId;

	/**
	 * 仓库分表code
	 * 
	 */
	private Long warehouseCode;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	public Long getDiffOrderId() {
		return diffOrderId;
	}

	public void setDiffOrderId(Long diffOrderId) {
		this.diffOrderId = diffOrderId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
}
