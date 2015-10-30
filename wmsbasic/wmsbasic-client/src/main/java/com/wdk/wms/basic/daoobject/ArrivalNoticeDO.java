package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:到货通知单主表
 * 
 * @author 刘勇 Date 2015-09-23
 */
public class ArrivalNoticeDO {

	/**
	 * 到货通知单编码
	 */
	private String asnCode;

	/**
	 * 业务单号 PO号
	 */
	private String bizOrderCode;

	/**
	 * 业务类型
	 */
	private Integer bizOrderType;

	/**
	 * 供应商送货单号
	 */
	private String courierCode;

	/**
	 * 收货仓库 关联仓库表
	 */
	private Long warehouseId;

	/**
	 * 货主id 关联商业伙伴表
	 */
	private Long ownerId;

	/**
	 * 供应商编号 关联商业伙伴表
	 */
	private Long supplierId;

	/**
	 * 供应商编码 外部系统下发
	 */
	private String supplierCode;

	/**
	 * 通知日期
	 */
	private Date arrivalNoticeDate;

	/**
	 * 通知单状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

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
	 * 扩展属性
	 */
	private String feature;

	/**
	 * 入库单回传总页数
	 */
	private Integer uploadPageSize;

	/**
	 * 操作人
	 */
	private Long operatorId;

	/**
	 * 失效日期
	 */
	private Date invalidDate;

	/**
	 * 到货日期
	 */
	private Date arrivalDate;

	/**
	 * setter for column 到货通知单编码
	 */
	public void setAsnCode(String asnCode) {
		this.asnCode = asnCode;
	}

	/**
	 * getter for column 到货通知单编码
	 */
	public String getAsnCode() {
		return this.asnCode;
	}

	/**
	 * setter for column 业务单号 PO号
	 */
	public void setBizOrderCode(String bizOrderCode) {
		this.bizOrderCode = bizOrderCode;
	}

	/**
	 * getter for column 业务单号 PO号
	 */
	public String getBizOrderCode() {
		return this.bizOrderCode;
	}

	/**
	 * setter for column 业务类型
	 */
	public void setBizOrderType(Integer bizOrderType) {
		this.bizOrderType = bizOrderType;
	}

	/**
	 * getter for column 业务类型
	 */
	public Integer getBizOrderType() {
		return this.bizOrderType;
	}

	/**
	 * setter for column 供应商送货单号
	 */
	public void setCourierCode(String courierCode) {
		this.courierCode = courierCode;
	}

	/**
	 * getter for column 供应商送货单号
	 */
	public String getCourierCode() {
		return this.courierCode;
	}

	/**
	 * setter for column 收货仓库 关联仓库表
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 收货仓库 关联仓库表
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 货主编号 关联商业伙伴表
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主编号 关联商业伙伴表
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 供应商编号 关联商业伙伴表
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * getter for column 供应商编号 关联商业伙伴表
	 */
	public Long getSupplierId() {
		return this.supplierId;
	}

	/**
	 * setter for column 供应商编码 外部系统下发
	 */
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	/**
	 * getter for column 供应商编码 外部系统下发
	 */
	public String getSupplierCode() {
		return this.supplierCode;
	}

	/**
	 * setter for column 通知日期
	 */
	public void setArrivalNoticeDate(Date arrivalNoticeDate) {
		this.arrivalNoticeDate = arrivalNoticeDate;
	}

	/**
	 * getter for column 通知日期
	 */
	public Date getArrivalNoticeDate() {
		return this.arrivalNoticeDate;
	}

	/**
	 * setter for column 通知单状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 通知单状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter for column 备注
	 */
	public String getRemark() {
		return this.remark;
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
	 * setter for column 扩展属性
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展属性
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 入库单回传总页数
	 */
	public void setUploadPageSize(Integer uploadPageSize) {
		this.uploadPageSize = uploadPageSize;
	}

	/**
	 * getter for column 入库单回传总页数
	 */
	public Integer getUploadPageSize() {
		return this.uploadPageSize;
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
	 * setter for column 失效日期
	 */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	/**
	 * getter for column 失效日期
	 */
	public Date getInvalidDate() {
		return this.invalidDate;
	}

	/**
	 * setter for column 到货日期
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * getter for column 到货日期
	 */
	public Date getArrivalDate() {
		return this.arrivalDate;
	}
}
