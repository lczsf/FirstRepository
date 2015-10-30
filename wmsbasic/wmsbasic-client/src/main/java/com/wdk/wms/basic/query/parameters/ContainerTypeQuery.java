package com.wdk.wms.basic.query.parameters;

/**
 * Description:
 *
 * @author 李超
 * @Date 15/9/7
 */
 

public class ContainerTypeQuery extends BaseQuery {
	
	/**
	 * 仓库id
	 */
	private Long warehouseId;
	
	/**
	 * 容器类型名称
	 */
	private String name;
	
	/**
	 * 容器类型状态
	 * 
	 * @containerType.status
	 */
	private Integer status;

	/**
	 * 容器类型编码
	 * 
	 */
	private String code;

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
