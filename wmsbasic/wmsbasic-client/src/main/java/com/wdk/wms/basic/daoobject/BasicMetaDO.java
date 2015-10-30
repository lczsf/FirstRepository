package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:数据字典
 * 
 * @author 刘勇 Date 2015-09-07
 */
public class BasicMetaDO {

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
	 * 最后作者
	 */
	private String modifier;

	/**
	 * code
	 */
	private String code;

	/**
	 * 字典项的含义
	 */
	private String name;

	/**
	 * caozuoren
	 */
	private Long operatorId;

	/**
	 * caozuo ip
	 */
	private String operatorIp;

	/**
	 * 字典值
	 */
	private String value;

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
	 * setter for column 最后作者
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * getter for column 最后作者
	 */
	public String getModifier() {
		return this.modifier;
	}

	/**
	 * setter for column code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 字典项的含义
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 字典项的含义
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column caozuoren
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column caozuoren
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column caozuo ip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column caozuo ip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
	}

	/**
	 * setter for column 字典值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * getter for column 字典值
	 */
	public String getValue() {
		return this.value;
	}
}