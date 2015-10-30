package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:归位装箱单
 * 
 * @author 李超 Date 2015-10-22
 */
public class BackContainerOrderDO {

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
	 * 取消人（打包人）
	 */
	private Long parcelId;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 商品数量
	 */
	private Double itemNumber;

	/**
	 * 商品批次id
	 */
	private Long itemBatchId;

	/**
	 * 商品id
	 */
	private Long itemId;
	
	/**
	 * 容器code
	 */
	private String containerCode;

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
	 * setter for column 取消人（打包人）
	 */
	public void setParcelId(Long parcelId) {
		this.parcelId = parcelId;
	}

	/**
	 * getter for column 取消人（打包人）
	 */
	public Long getParcelId() {
		return this.parcelId;
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
	 * setter for column 波次id
	 */
	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	/**
	 * getter for column 波次id
	 */
	public Long getWaveId() {
		return this.waveId;
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

	/**
	 * setter for column 商品数量
	 */


	/**
	 * setter for column 商品批次id
	 */
	public void setItemBatchId(Long itemBatchId) {
		this.itemBatchId = itemBatchId;
	}

	public Double getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Double itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * getter for column 商品批次id
	 */
	public Long getItemBatchId() {
		return this.itemBatchId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}
	
}