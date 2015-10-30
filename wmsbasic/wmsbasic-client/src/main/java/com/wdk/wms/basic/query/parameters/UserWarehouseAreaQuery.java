package com.wdk.wms.basic.query.parameters;

public class UserWarehouseAreaQuery extends BaseQuery {
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 库区ids
	 */
	private String warehouseAreaIds;
	
	/**
	 * 仓库id
	 * 
	 * @return
	 */
    private Long warehouseId;
    
	/**
	 * 用户work_number
	 * 
	 * @return
	 */
	private String workNumber;

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWarehouseAreaIds() {
		return warehouseAreaIds;
	}

	public void setWarehouseAreaIds(String warehouseAreaIds) {
		this.warehouseAreaIds = warehouseAreaIds;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
}
