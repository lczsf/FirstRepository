package com.wdk.wms.basic.query.parameters;

public class PutawayOrderDetailQuery extends BaseQuery {

	/**
	 * putawayOrderId
	 */
	private Long putawayOrderId;

	/**
	 * warehouseId仓库id
	 */
	private Long warehouseId;

	/**
	 * 分表code
	 */
	private Long warehouseCode;

	public Long getPutawayOrderId() {
		return putawayOrderId;
	}

	public void setPutawayOrderId(Long putawayOrderId) {
		this.putawayOrderId = putawayOrderId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
}
