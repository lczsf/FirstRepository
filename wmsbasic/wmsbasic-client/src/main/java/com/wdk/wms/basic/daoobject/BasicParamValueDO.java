package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:系统参数数值表
 * 
 * @author 刘勇 Date 2015-09-14
 */
public class BasicParamValueDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 参数名称 必填
	 */
	private String paramName;

	/**
	 * 参数值 必填
	 */
	private String paramValue;

	/**
	 * 创建时间
	 */
	private Date gmtCreated;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 状态
	 */
	private Byte status;

	/**
	 * 参数类型外键
	 */
	private Long paramTypeId;

	/**
	 * operator
	 */
	private Long operatorId;

	/**
	 * operatorip
	 */
	private String operatorIp;

	/**
	 * 仓库ID,对于全局，与仓无关的参数warehouse_id为空
	 */
	private Long warehouseId;

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
	 * setter for column 参数名称
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * getter for column 参数名称
	 */
	public String getParamName() {
		return this.paramName;
	}

	/**
	 * setter for column 参数值
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * getter for column 参数值
	 */
	public String getParamValue() {
		return this.paramValue;
	}

	/**
	 * setter for column 创建时间
	 */
	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	/**
	 * getter for column 创建时间
	 */
	public Date getGmtCreated() {
		return this.gmtCreated;
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
	 * setter for column 状态
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * getter for column 状态
	 */
	public Byte getStatus() {
		return this.status;
	}

	/**
	 * setter for column 参数类型外键
	 */
	public void setParamTypeId(Long paramTypeId) {
		this.paramTypeId = paramTypeId;
	}

	/**
	 * getter for column 参数类型外键
	 */
	public Long getParamTypeId() {
		return this.paramTypeId;
	}

	/**
	 * setter for column operator
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column operator
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column operatorip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column operatorip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
	}

	/**
	 * setter for column 仓库ID,对于全局，与仓无关的参数warehouse_id为空
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库ID,对于全局，与仓无关的参数warehouse_id为空
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}
}