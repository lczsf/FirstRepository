package com.wdk.wms.basic.daoobject;

import java.util.Date;
import java.util.List;

/**
 * Description:参数类别表
 * 
 * @author 刘勇 Date 2015-09-14
 */
public class BasicParamTypeDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 类别编号
	 */
	private String typeCode;

	/**
	 * 类别名称
	 */
	private String typeName;

	/**
	 * 启用、停用
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date gmtCreated;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 说明
	 */
	private String comment;

	/**
	 * 操作人
	 */
	private Long operatorId;

	/**
	 * 操作ip
	 */
	private String operatorIp;

	/**
	 * 参数值
	 */
	private List<BasicParamValueDO> paramValueDOs;

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
	 * setter for column 类别编号
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * getter for column 类别编号
	 */
	public String getTypeCode() {
		return this.typeCode;
	}

	/**
	 * setter for column 类别名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * getter for column 类别名称
	 */
	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * setter for column 启用、停用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 启用、停用
	 */
	public Integer getStatus() {
		return this.status;
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
	 * setter for column 说明
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * getter for column 说明
	 */
	public String getComment() {
		return this.comment;
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
	 * setter for column 操作ip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column 操作ip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
	}

	public List<BasicParamValueDO> getParamValueDOs() {
		return paramValueDOs;
	}

	public void setParamValueDOs(List<BasicParamValueDO> paramValueDOs) {
		this.paramValueDOs = paramValueDOs;
	}
}
