package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:调整库位明细
 * 
 * @author 川丘 Date 2015-10-29
 */
public class InventoryAdjustDetailDO {
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
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 库存批次id
	 */
	private Long inventoryBatchId;

	/**
	 * 调整单主表id
	 */
	private Long inventoryAdjustId;

	/**
	 * 库存Id
	 */
	private Long inventoryId;

	/**
	 * 调整数量
	 */
	private Integer adjustNum;

	/**
	 * 数据状态 0 不可用 1可用
	 */
	private Integer status;

	/**
	 * 版本
	 */
	private Long version;

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
	 * setter for column 商品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品id
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 库存批次id
	 */
	public void setInventoryBatchId(Long inventoryBatchId) {
		this.inventoryBatchId = inventoryBatchId;
	}

	/**
	 * getter for column 库存批次id
	 */
	public Long getInventoryBatchId() {
		return this.inventoryBatchId;
	}

	/**
	 * setter for column 调整单主表id
	 */
	public void setInventoryAdjustId(Long inventoryAdjustId) {
		this.inventoryAdjustId = inventoryAdjustId;
	}

	/**
	 * getter for column 调整单主表id
	 */
	public Long getInventoryAdjustId() {
		return this.inventoryAdjustId;
	}

	/**
	 * setter for column 库存Id
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * getter for column 库存Id
	 */
	public Long getInventoryId() {
		return this.inventoryId;
	}

	/**
	 * setter for column 调整数量
	 */
	public void setAdjustNum(Integer adjustNum) {
		this.adjustNum = adjustNum;
	}

	/**
	 * getter for column 调整数量
	 */
	public Integer getAdjustNum() {
		return this.adjustNum;
	}

	/**
	 * setter for column 数据状态 0 不可用 1可用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 数据状态 0 不可用 1可用
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 版本
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * getter for column 版本
	 */
	public Long getVersion() {
		return this.version;
	}
}
