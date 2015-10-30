package com.wdk.wms.basic.query.parameters;

/**
 * Description:
 *
 * @author 李超
 * @Date 15/9/7
 */
 

public class ContainerQuery extends BaseQuery {
	
	/**
	 * 仓库id
	 */
	private Long warehouseId;
	
	/**
	 * 容器名称
	 */
	private String name;
	
	/**
	 * 容器编码
	 */
	private String code;

	/**
	 * 容器类型id
	 */
	private Long containerTypeId;
	
	/**
	 * 容器状态@container.status
	 */
	private Integer status;

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


	public Long getContainerTypeId() {
		return containerTypeId;
	}

	public void setContainerTypeId(Long containerTypeId) {
		this.containerTypeId = containerTypeId;
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
