package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:系统信息表
 * @author 李远
 * Date 2015-10-10
 */
public class AuthSysDO {

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
	 * 系统名称
	 */
	private String name;

	/**
	 * 系统编码
	 */
	private String code;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 操作人
	 */
	private Long operatorId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

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
	 * setter for column 系统名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 系统名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 系统编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 系统编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 操作人
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作人
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column 操作人ip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column 操作人ip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
	}
}
