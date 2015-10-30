package com.wdk.wms.basic.query.parameters;

import java.util.Date;

/****
 * 
 * @author wb-cengxi
 * 创建人：曾曦
 * 创建时间：2015.9.28
 * 修改时间：2015.9.28
 * 
 */

public class BatchOrderQuery extends BaseQuery {

	/**
	 * 主键(批次单ID)
	 */
	private Long id;

	/**
	 * 外部批次单号
	 */
	private String externalBatchCode;

	/**
	 * 批次名称
	 */
	private String batchName;

	/**
	 * 批次属性（1、即时达 2、定时达）
	 */
	private Integer batchProperty;

	/**
	 * 批次状态
	 */
	private Integer batchStatus;

	/**
	 * 仓库ID
	 */
	private Long warehouseId;

	/**
	 * 货主ID
	 */
	private Long ownerId;

	/**
	 * 履约类型(1、配送 2、现场购买 3、预约自提)
	 */
	private Integer performanceType;

	/**
	 * 批次单类型（1、周期购 2、预售 3、普通）
	 */
	private Integer batchType;

	/**
	 * 批次单要求送达时间
	 */
	private Date arrivetime;

	/**
	 * 包含子订单数
	 */
	private Integer childOrderQuanity;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 波次ID
	 */
	private Long waveId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * setter for column 主键(批次单ID)
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 主键(批次单ID)
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 外部批次单号
	 */
	public void setExternalBatchCode(String externalBatchCode) {
		this.externalBatchCode = externalBatchCode;
	}

	/**
	 * getter for column 外部批次单号
	 */
	public String getExternalBatchCode() {
		return this.externalBatchCode;
	}

	/**
	 * setter for column 批次名称
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	/**
	 * getter for column 批次名称
	 */
	public String getBatchName() {
		return this.batchName;
	}

	/**
	 * setter for column 批次属性（1、即时达 2、定时达）
	 */
	public void setBatchProperty(Integer batchProperty) {
		this.batchProperty = batchProperty;
	}

	/**
	 * getter for column 批次属性（1、即时达 2、定时达）
	 */
	public Integer getBatchProperty() {
		return this.batchProperty;
	}

	/**
	 * setter for column 批次状态
	 */
	public void setBatchStatus(Integer batchStatus) {
		this.batchStatus = batchStatus;
	}

	/**
	 * getter for column 批次状态
	 */
	public Integer getBatchStatus() {
		return this.batchStatus;
	}

	/**
	 * setter for column 仓库ID
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库ID
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 货主ID
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主ID
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 履约类型(1、配送 2、现场购买 3、预约自提)
	 */
	public void setPerformanceType(Integer performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * getter for column 履约类型(1、配送 2、现场购买 3、预约自提)
	 */
	public Integer getPerformanceType() {
		return this.performanceType;
	}

	/**
	 * setter for column 批次单类型（1、周期购 2、预售 3、普通）
	 */
	public void setBatchType(Integer batchType) {
		this.batchType = batchType;
	}

	/**
	 * getter for column 批次单类型（1、周期购 2、预售 3、普通）
	 */
	public Integer getBatchType() {
		return this.batchType;
	}

	/**
	 * setter for column 批次单要求送达时间
	 */
	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	/**
	 * getter for column 批次单要求送达时间
	 */
	public Date getArrivetime() {
		return this.arrivetime;
	}

	/**
	 * setter for column 包含子订单数
	 */
	public void setChildOrderQuanity(Integer childOrderQuanity) {
		this.childOrderQuanity = childOrderQuanity;
	}

	/**
	 * getter for column 包含子订单数
	 */
	public Integer getChildOrderQuanity() {
		return this.childOrderQuanity;
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
	 * setter for column 波次ID
	 */
	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	/**
	 * getter for column 波次ID
	 */
	public Long getWaveId() {
		return this.waveId;
	}

	/**
	 * setter for column 仓库分表code
	 */
	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * getter for column 仓库分表code
	 */
	public Long getWarehouseCode() {
		return this.warehouseCode;
	}
}
