package com.wdk.wms.inventory.parameters;

public class ItemOccupyDetail {

	/**
	 * 商品Id
	 */
	private Long itemId;

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
	private String warehouseCode;

	/**
	 * 库位
	 */
	private Long cabinetId;

	/**
	 * 商品批次
	 */
	private Long itemBatchId;
	
	/**
	 * 库存id
	 */
	private Long inventory_info_id;

	/**
	 * 商品占用数量
	 */
	private Double occupyCount;

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

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
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

	public Long getInventory_info_id() {
		return inventory_info_id;
	}

	public void setInventory_info_id(Long inventory_info_id) {
		this.inventory_info_id = inventory_info_id;
	}

	public Double getOccupyCount() {
		return occupyCount;
	}

	public void setOccupyCount(Double occupyCount) {
		this.occupyCount = occupyCount;
	}
	
	

}
