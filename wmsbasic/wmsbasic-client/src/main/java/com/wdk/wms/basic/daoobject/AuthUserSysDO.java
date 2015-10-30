package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:用户系统关系（资源权限控制）
 * @author 李远
 * Date 2015-10-10
 */
public class AuthUserSysDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 系统id
	 */
	private Long sysId;

	/**
	 * 登录状态
	 */
	private Integer status;

	/**
	 * 上一次登录时间
	 */
	private Date lastLoginTime;

	/**
	 * setter for column 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * getter for column 创建时间
	 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/**
	 * setter for column 修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * getter for column 修改时间
	 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	/**
	 * setter for column 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * getter for column 用户id
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * setter for column 系统id
	 */
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	/**
	 * getter for column 系统id
	 */
	public Long getSysId() {
		return this.sysId;
	}

	/**
	 * setter for column 登录状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 登录状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 上一次登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * getter for column 上一次登录时间
	 */
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}
}