package com.wdk.wms.basic.query.parameters;

public class SalesOrderDetailQuery extends BaseQuery {
	private Long salesOrderId;

	private Long warehouseId;

	private Long warehouseCode;

	private Long waveId;

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
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

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

}
