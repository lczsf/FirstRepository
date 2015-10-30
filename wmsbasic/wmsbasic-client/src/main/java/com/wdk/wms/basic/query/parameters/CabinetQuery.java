package com.wdk.wms.basic.query.parameters;
/**
 * Description:
 *
 * @author 李超
 * @Date 15/9/7
 */
 

public class CabinetQuery extends BaseQuery {
	
	/**
	 * 货位编码
	 */
	private String code;

	
	/**
	 * 货位状态@cabinet.status
	 */
	private Integer status;
	
	/**
	 * 货位类型
	 */
	private Integer type;	
	
	/**
	 * 所属仓库id
	 */
	private Long warehouseId;
	
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * 所属区域id
	 */
	private Long warehouseAreaId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getWarehouseAreaId() {
		return warehouseAreaId;
	}

	public void setWarehouseAreaId(Long warehouseAreaId) {
		this.warehouseAreaId = warehouseAreaId;
	}
	
}
