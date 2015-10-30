package com.wdk.wms.inventory.parameters;
/*
 * 库存调整参数 @滴石
 */
public class InventoryAdjustParameter {

	/**
	 * 商品Id
	 */
	private Long itemId;
	
	/**
	 * 商品数量,库存单位对应的数量，不是无敌库存单位g
	 */
	private Double itemQuainty;

	/**
	 * 货主
	 */
	private Long ownerId;

	/**
	 * 仓库
	 */
	private Long warehouseId;
	
	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;
	
	/**
	 * 库位
	 */
	private Long cabinetId;

	/**
	 * 批次
	 */
	private Long itemBatchId;
	
	/**
	 * 来源单据id
	 */
	private Long SourceOrderId;
	
	/**
	 * 来源单据类型
	 */
	private Integer SourceOrderType;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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

	public Long getCabinetId() {
		return cabinetId;
	}

	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	public Long getItemBatchId() {
		return itemBatchId;
	}

	public void setItemBatchId(Long itemBatchId) {
		this.itemBatchId = itemBatchId;
	}

	public Long getSourceOrderId() {
		return SourceOrderId;
	}

	public void setSourceOrderId(Long sourceOrderId) {
		SourceOrderId = sourceOrderId;
	}

	public Integer getSourceOrderType() {
		return SourceOrderType;
	}

	public void setSourceOrderType(Integer sourceOrderType) {
		SourceOrderType = sourceOrderType;
	}

	public Double getItemQuainty() {
		return itemQuainty;
	}

	public void setItemQuainty(Double itemQuainty) {
		this.itemQuainty = itemQuainty;
	}
	
	
}
