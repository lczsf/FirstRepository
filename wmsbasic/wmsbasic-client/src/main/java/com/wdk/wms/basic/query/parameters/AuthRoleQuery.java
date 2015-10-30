package com.wdk.wms.basic.query.parameters;


/**
 * Description: 角色查询条件
 *
 * @author 刘勇
 * @Date 15/9/7
 */
public class AuthRoleQuery extends BaseQuery {

	// 名称
	private String name;

	// 类型
	private Integer type;

	// 状态
	private Integer status;

	// 仓库id
	private Long warehouseId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
}
