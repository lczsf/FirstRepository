package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:流水号
 * 
 * @author 刘勇 Date 2015-09-28
 */
public class BasicSerialNumberDO {

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
	 * 流水号
	 */
	private Integer serialNumber;

	/**
	 * 版本号
	 */
	private Integer version;

	/**
	 * 时间(用于区分每天序列号)
	 */
	private Date date;

	/**
	 * 流水号类型
	 */
	private String serialType;

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
	 * setter for column 流水号
	 */
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * getter for column 流水号
	 */
	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * setter for column 版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * getter for column 版本号
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * setter for column 时间(用于区分每天序列号)
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * getter for column 时间(用于区分每天序列号)
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * setter for column 流水号类型
	 */
	public void setSerialType(String serialType) {
		this.serialType = serialType;
	}

	/**
	 * getter for column 流水号类型
	 */
	public String getSerialType() {
		return this.serialType;
	}
}
