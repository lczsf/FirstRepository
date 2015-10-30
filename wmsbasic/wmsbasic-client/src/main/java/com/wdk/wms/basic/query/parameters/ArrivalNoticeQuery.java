package com.wdk.wms.basic.query.parameters;

import sun.rmi.runtime.Log;

import java.util.Date;

public class ArrivalNoticeQuery extends BaseQuery {

	/**
	 * 到货通知单编码
	 */
	private String asnCode;

	/**
	 * 业务单号 PO号
	 */
	private String bizOrderCode;

	/**
	 * 收货仓库 关联仓库表
	 */
	private Long warehouseId;

	/**
	 * 分表code
	 */
	private Long warehouseCode;

	/**
	 * 起始时间
	 */
	private Date beginDate;

	/**
	 * 终止实际
	 */
	private Date endDate;

	/**
	 * 通知单状态
	 */
	private Integer status;

	/**
	 * 供应商Id
	 * 
	 * @return
	 */
	private Long supplierId;

	/**
	 * 商品编码
	 * 
	 * @return
	 */
	private String itemCode;

	public String getAsnCode() {
		return asnCode;
	}

	public void setAsnCode(String asnCode) {
		this.asnCode = asnCode;
	}

	public String getBizOrderCode() {
		return bizOrderCode;
	}

	public void setBizOrderCode(String bizOrderCode) {
		this.bizOrderCode = bizOrderCode;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
}
