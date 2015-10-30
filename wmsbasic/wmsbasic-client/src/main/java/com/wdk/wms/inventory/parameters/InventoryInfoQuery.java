package com.wdk.wms.inventory.parameters;

import java.util.List;

/*商品库存信息查询条件
 * author@dishi
 */
public class InventoryInfoQuery {

	/**
	 * 主键id
	 */
	private Long id;

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
	 * 是否被锁
	 */
	private Integer status;

	/**
	 * 库位id数组
	 */
	private List<Long> cabinetTypeIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public List<Long> getCabinetTypeIds() {
		return cabinetTypeIds;
	}

	public void setCabinetTypeIds(List<Long> cabinetTypeIds) {
		this.cabinetTypeIds = cabinetTypeIds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
