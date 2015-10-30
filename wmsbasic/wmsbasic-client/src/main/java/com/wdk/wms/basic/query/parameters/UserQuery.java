package com.wdk.wms.basic.query.parameters;


/**
 * Description: 用户查询参数
 *
 * @author 刘勇
 * @Date 15/9/7
 */
public class UserQuery extends BaseQuery {

	// 账号工号姓名
	private String userName;

	// 状态
	private Integer status;

	// 仓库id
	private Long warehouseId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
