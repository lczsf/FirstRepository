package com.wdk.wms.basic.query.parameters;


import java.util.Date;

/**
 * Description:打包单表
 * @author 曾曦
 * Date 2015-09-29
 */
public class ParcelQuery extends BaseQuery {

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
	 * 批次打包人员ID
	 */
	private Long operatorId;

	/**
	 * 包裹号
	 */
	private String parcelNumber;

	/**
	 * 批次ID
	 */
	private Long batchId;

	/**
	 * 仓库ID
	 */
	private Long warehouseId;

	/**
	 * 货主ID
	 */
	private Long ownerId;

	/**
	 * 仓库分表code
	 */
	private long warehouseCode;

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
	 * setter for column 批次打包人员ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 批次打包人员ID
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column 包裹号
	 */
	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	/**
	 * getter for column 包裹号
	 */
	public String getParcelNumber() {
		return this.parcelNumber;
	}

	/**
	 * setter for column 批次ID
	 */
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	/**
	 * getter for column 批次ID
	 */
	public Long getBatchId() {
		return this.batchId;
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
	 * setter for column 仓库分表code
	 */
	public void setWarehouseCode(long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * getter for column 仓库分表code
	 */
	public long getWarehouseCode() {
		return this.warehouseCode;
	}
}