package com.wdk.wms.basic.query.parameters;

public class InventoryAdjustQuery extends BaseQuery {

	/**
	 * 收货仓库 关联仓库表
	 */
	private Long warehouseId;

	/**
	 * 分表code
	 */
	private Long warehouseCode;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 操作人Id
	 * 
	 * @return
	 */
	private Long operationId;

	/**
	 * 商品编码
	 * 
	 * @return
	 */
	private String itemCode;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOperationId() {
		return operationId;
	}

	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

}
