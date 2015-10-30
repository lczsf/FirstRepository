package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:用户库区绑定关联表
 * 
 * @author 李超 Date 2015-09-11
 */
public class BasicUserWarehouseAreaDO {

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
	 * 库区id
	 */
	private Long warehouseAreaId;

	/**
	 * 状态：启用：未启用
	 */
	private Byte status;
	
	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 员工编号workNumber
	 */
	private String workNumber;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 库区编码
	 */
	private String code;
	
	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
	 * setter for column 库区id
	 */
	public void setWarehouseAreaId(Long warehouseAreaId) {
		this.warehouseAreaId = warehouseAreaId;
	}

	/**
	 * getter for column 库区id
	 */
	public Long getWarehouseAreaId() {
		return this.warehouseAreaId;
	}

	/**
	 * setter for column 状态：启用：未启用
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * getter for column 状态：启用：未启用
	 */
	public Byte getStatus() {
		return this.status;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
}
