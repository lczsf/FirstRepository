package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:装箱单
 * 
 * @author 滴石 Date 2015-09-14
 */
public class ContainerOrderDO {

	/**
	 * 通知单号
	 */
	private Long asnId;

	/**
	 * 货位编号
	 */
	private Long cabinetId;

	/**
	 * 收货仓库
	 */
	private Long warehouseId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 货主编号
	 */
	private Long ownerId;

	/**
	 * 供应商编号
	 */
	private Long supplierId;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 是否RF收货 0false 1true
	 */
	private Integer isRf;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 收货装箱号
	 */
	private String code;

	/**
	 * 容器编码
	 */
	private String containerCode;

	/**
	 * 操作人ID
	 */
	private Long operationId;

	/**
	 * 业务单号（外部单号）
	 */
	private String bizOrderCode;

	/**
	 * 收货人
	 */
	private Long responsibleId;

	/**
	 * setter for column 通知单号
	 */
	public void setAsnId(Long asnId) {
		this.asnId = asnId;
	}

	/**
	 * getter for column 通知单号
	 */
	public Long getAsnId() {
		return this.asnId;
	}

	/**
	 * setter for column 货位编号
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 货位编号
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	/**
	 * setter for column 收货仓库
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 收货仓库
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 货主编号
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主编号
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 供应商编号
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * getter for column 供应商编号
	 */
	public Long getSupplierId() {
		return this.supplierId;
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
	 * setter for column 是否RF收货 0false 1true
	 */
	public void setIsRf(Integer isRf) {
		this.isRf = isRf;
	}

	/**
	 * getter for column 是否RF收货 0false 1true
	 */
	public Integer getIsRf() {
		return this.isRf;
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
	 * setter for column 扩展字段
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展字段
	 */
	public String getFeature() {
		return this.feature;
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
	 * setter for column 收货装箱号
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 收货装箱号
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 容器编码
	 */
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	/**
	 * getter for column 容器编码
	 */
	public String getContainerCode() {
		return this.containerCode;
	}

	/**
	 * setter for column 操作人ID
	 */
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	/**
	 * getter for column 操作人ID
	 */
	public Long getOperationId() {
		return this.operationId;
	}

	/**
	 * setter for column 业务单号（外部单号）
	 */
	public void setBizOrderCode(String bizOrderCode) {
		this.bizOrderCode = bizOrderCode;
	}

	/**
	 * getter for column 业务单号（外部单号）
	 */
	public String getBizOrderCode() {
		return this.bizOrderCode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}
}
