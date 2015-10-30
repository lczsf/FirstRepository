package com.wdk.wms.basic.query.parameters;

import java.util.Date;

/**
 * Description:波次表
 * @author 曾曦
 * Date 2015-10-08
 */
public class WaveOrderQuery extends BaseQuery{

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
	 * 波次code
	 */
	private String waveCode;

	/**
	 * 波次状态
	 */
	private Integer waveStatus;

	/**
	 * 出库操作方式
	 */
	private Integer outOperationMode;

	/**
	 * 子订单数量
	 */
	private Integer childOrderQuanity;

	/**
	 * 货主ID
	 */
	private Long ownerId;

	/**
	 * 仓库ID
	 */
	private Long warehouseId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

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
	 * setter for column 波次code
	 */
	public void setWaveCode(String waveCode) {
		this.waveCode = waveCode;
	}

	/**
	 * getter for column 波次code
	 */
	public String getWaveCode() {
		return this.waveCode;
	}

	/**
	 * setter for column 波次状态
	 */
	public void setWaveStatus(Integer waveStatus) {
		this.waveStatus = waveStatus;
	}

	/**
	 * getter for column 波次状态
	 */
	public Integer getWaveStatus() {
		return this.waveStatus;
	}

	/**
	 * setter for column 出库操作方式
	 */
	public void setOutOperationMode(Integer outOperationMode) {
		this.outOperationMode = outOperationMode;
	}

	/**
	 * getter for column 出库操作方式
	 */
	public Integer getOutOperationMode() {
		return this.outOperationMode;
	}

	/**
	 * setter for column 子订单数量
	 */
	public void setChildOrderQuanity(Integer childOrderQuanity) {
		this.childOrderQuanity = childOrderQuanity;
	}

	/**
	 * getter for column 子订单数量
	 */
	public Integer getChildOrderQuanity() {
		return this.childOrderQuanity;
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
