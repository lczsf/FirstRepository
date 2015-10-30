package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:归位单表
 * 
 * @author 李超 Date 2015-10-22
 */
public class BackOrderDO {

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
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 归位装箱单id
	 */
	private Long backContainerOrderId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 归位库位id
	 */
	private Long backCabinetId;

	/**
	 * 应该归位数量
	 */
	private Double shouldBackNumber;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 实际归位数量
	 */
	private Double actualBackNumber;

	/**
	 * 商品id
	 */
	private Long itemId;

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
	 * setter for column 归位装箱单id
	 */
	public void setBackContainerOrderId(Long backContainerOrderId) {
		this.backContainerOrderId = backContainerOrderId;
	}

	/**
	 * getter for column 归位装箱单id
	 */
	public Long getBackContainerOrderId() {
		return this.backContainerOrderId;
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
	 * setter for column 归位库位id
	 */
	public void setBackCabinetId(Long backCabinetId) {
		this.backCabinetId = backCabinetId;
	}

	/**
	 * getter for column 归位库位id
	 */
	public Long getBackCabinetId() {
		return this.backCabinetId;
	}

	/**
	 * setter for column 应该归位数量
	 */

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
	 * setter for column 实际归位数量
	 */

	/**
	 * setter for column 商品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getShouldBackNumber() {
		return shouldBackNumber;
	}

	public void setShouldBackNumber(Double shouldBackNumber) {
		this.shouldBackNumber = shouldBackNumber;
	}

	public Double getActualBackNumber() {
		return actualBackNumber;
	}

	public void setActualBackNumber(Double actualBackNumber) {
		this.actualBackNumber = actualBackNumber;
	}

	/**
	 * getter for column 商品id
	 */
	public Long getItemId() {
		return this.itemId;
	}
}