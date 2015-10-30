package com.wdk.wms.basic.query.parameters;

public class PickingOrderDetailQuery extends BaseQuery {

	/**
	 * 拣货分区id
	 */
	private Long pickingOrderId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 波次Id
	 */
	private Long waveId;

	/**
	 * 状态
	 */
	private Integer status;

	public Long getPickingOrderId() {
		return pickingOrderId;
	}

	public void setPickingOrderId(Long pickingOrderId) {
		this.pickingOrderId = pickingOrderId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
