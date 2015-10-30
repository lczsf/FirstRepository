package com.wdk.wms.basic.query.parameters;

/**
 * 权限用户查询
 * @author wb-liyuan.j
 *
 */
public class PrivilegedUserQuery extends BaseQuery {
	private Long userId;
	private String account;
	private String userName;
	private Integer status;
	private String userIds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

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

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

}
