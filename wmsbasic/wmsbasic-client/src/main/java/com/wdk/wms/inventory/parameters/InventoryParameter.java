package com.wdk.wms.inventory.parameters;

public class InventoryParameter {

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
	 * 库位
	 */
	private Long cabinetId;

	/**
	 * 批次
	 */
	private Long itemBatchId;

	/**
	 * 商品数量
	 */
	private Long itemCount;

	/**
	 * 单据类型
	 */
	private Integer docType;

	/**
	 * 单据Id
	 */
	private Long docId;

	/**
	 * 来源单据Code
	 */
	private String sourceDocCode;

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

	public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getSourceDocCode() {
		return sourceDocCode;
	}

	public void setSourceDocCode(String sourceDocCode) {
		this.sourceDocCode = sourceDocCode;
	}

}
