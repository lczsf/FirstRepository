package com.wdk.wms.basic.query.parameters;

import java.util.Date;

public class ContainerOrderQuery extends BaseQuery {

	/**
	 * 通知单号
	 */
	private Long asnId;

	/**
	 * 外部通知单号
	 */
	private String bizOrderCode;

	/**
	 * 收货仓库
	 */
	private Long warehouseId;

	/**
	 * 仓库分表
	 */
	private Long warehouseCode;

	/**
	 * 货主编号
	 */
	private Long ownerId;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 起始时间
	 */
	private Date beginDate;

	/**
	 * 终止时间
	 */
	private Date endDate;

	/**
	 * 收货装箱号
	 */
	private String code;

	/**
	 * 容器编码
	 */
	private String containerCode;

	/**
	 * 供应商id
	 * 
	 * @return
	 */
	private Long supplierId;

	public Long getAsnId() {
		return asnId;
	}

	public void setAsnId(Long asnId) {
		this.asnId = asnId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getBizOrderCode() {
		return bizOrderCode;
	}

	public void setBizOrderCode(String bizOrderCode) {
		this.bizOrderCode = bizOrderCode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
}
