package com.wdk.wms.basic.query.parameters;

public class SalesOrderQuery extends BaseQuery {
	private String externalSalesNumber;

	private Integer type;

	private Long warehouseId;

	private Long outBatchCode;

	private Integer performanceType;

	private Long warehouseCode;

	private Long waveId;

	public String getExternalSalesNumber() {
		return externalSalesNumber;
	}

	public void setExternalSalesNumber(String externalSalesNumber) {
		this.externalSalesNumber = externalSalesNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getOutBatchCode() {
		return outBatchCode;
	}

	public void setOutBatchCode(Long outBatchCode) {
		this.outBatchCode = outBatchCode;
	}

	public Integer getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(Integer performanceType) {
		this.performanceType = performanceType;
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
