package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:容器信息表
 * 
 * @author 李超 Date 2015-09-07
 */
public class BasicContainerDO {

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
	 * 容器编码
	 */
	private String code;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 容器名称
	 */
	private String name;

	/**
	 * 容器类型id
	 */
	private Long containerTypeId;

	/**
	 * 容器状态@container.status
	 */
	private Integer status;

	/**
	 * RFID编号
	 */
	private String rfid;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 扩展信息
	 */
	private String feature;

	/**
	 * 操作人编号
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
	 * setter for column 容器编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 容器编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库id
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 容器名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 容器名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 容器类型id
	 */
	public void setContainerTypeId(Long containerTypeId) {
		this.containerTypeId = containerTypeId;
	}

	/**
	 * getter for column 容器类型id
	 */
	public Long getContainerTypeId() {
		return this.containerTypeId;
	}

	/**
	 * setter for column 容器状态@container.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 容器状态@container.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column RFID编号
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	/**
	 * getter for column RFID编号
	 */
	public String getRfid() {
		return this.rfid;
	}

	/**
	 * setter for column 备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter for column 备注信息
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * setter for column 扩展信息
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展信息
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 操作人编号
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作人编号
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