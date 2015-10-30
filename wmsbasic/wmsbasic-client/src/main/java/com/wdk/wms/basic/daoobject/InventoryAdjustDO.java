package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库存调整单
 * 
 * @author 川丘 Date 2015-10-29
 */
public class InventoryAdjustDO {

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
	 * 分表字段
	 */
	private Long warehouseCode;

	/**
	 * 来源单号
	 */
	private String sourceCode;

	/**
	 * 来源类型
	 */
	private Integer sourceType;

	/**
	 * 调整原因
	 */
	private String adjustDescribe;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 操作人id
	 */
	private Long operationId;

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
	 * setter for column 分表字段
	 */
	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * getter for column 分表字段
	 */
	public Long getWarehouseCode() {
		return this.warehouseCode;
	}

	/**
	 * setter for column 来源单号
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	/**
	 * getter for column 来源单号
	 */
	public String getSourceCode() {
		return this.sourceCode;
	}

	/**
	 * setter for column 来源类型
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * getter for column 来源类型
	 */
	public Integer getSourceType() {
		return this.sourceType;
	}

	/**
	 * setter for column 调整原因
	 */
	public void setAdjustDescribe(String adjustDescribe) {
		this.adjustDescribe = adjustDescribe;
	}

	/**
	 * getter for column 调整原因
	 */
	public String getAdjustDescribe() {
		return this.adjustDescribe;
	}

	/**
	 * setter for column 货主id
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主id
	 */
	public Long getOwnerId() {
		return this.ownerId;
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
	 * setter for column 操作人id
	 */
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	/**
	 * getter for column 操作人id
	 */
	public Long getOperationId() {
		return this.operationId;
	}
}
