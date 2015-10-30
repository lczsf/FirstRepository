package com.wdk.wms.basic.query.parameters;

/**
 * Description:
 *
 * @author 李超
 * @Date 15/9/7
 */
 
public class WarehouseAreaQuery extends BaseQuery {
	
	/**
	 * 区域编码
	 */
	private String code;
	
	/**
	 * 区域名称
	 */
	private String name;
	
	/**
	 * 区域状态, @ area.status
	 * 同状态字典
	 */
	private Integer status;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
