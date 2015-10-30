package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库存占用表
 * 
 * @author 刘勇 Date 2015-10-08
 */
public class InventoryOccupancyDO {

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
	 * 占用单id
	 */
	private Long occupancyOrderId;

	/**
	 * 占用单类型
	 */
	private Integer occupancyOrderType;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 货位id
	 */
	private Long cabinetId;

	/**
	 * 占用数量
	 */
	private Double occupancyQuantity;

	/**
	 * 库存批次id
	 */
	private Long inventoryBatchId;

	/**
	 * 实操数量
	 */
	private Double actualQuantity;

	/**
	 * 操作单id
	 */
	private Long operateOrderId;

	/**
	 * 操作单类型
	 */
	private Integer operateOrderType;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 库存分表code
	 */
	private Long inventoryInfoId;

	/**
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 服务特征
	 */
	private Long serviceFeatures;

	/**
	 * 出库方式 1 占用 2 扣减
	 */
	private Integer inventoryOperateMode;

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
	 * setter for column 占用单id
	 */
	public void setOccupancyOrderId(Long occupancyOrderId) {
		this.occupancyOrderId = occupancyOrderId;
	}

	/**
	 * getter for column 占用单id
	 */
	public Long getOccupancyOrderId() {
		return this.occupancyOrderId;
	}

	/**
	 * setter for column 占用单类型
	 */
	public void setOccupancyOrderType(Integer occupancyOrderType) {
		this.occupancyOrderType = occupancyOrderType;
	}

	/**
	 * getter for column 占用单类型
	 */
	public Integer getOccupancyOrderType() {
		return this.occupancyOrderType;
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
	 * setter for column 商品名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * getter for column 商品名称
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * setter for column 货位id
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 货位id
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	/**
	 * setter for column 占用数量
	 */
	public void setOccupancyQuantity(Double occupancyQuantity) {
		this.occupancyQuantity = occupancyQuantity;
	}

	/**
	 * getter for column 占用数量
	 */
	public Double getOccupancyQuantity() {
		return this.occupancyQuantity;
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
	 * setter for column 实操数量
	 */
	public void setActualQuantity(Double actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	/**
	 * getter for column 实操数量
	 */
	public Double getActualQuantity() {
		return this.actualQuantity;
	}

	/**
	 * setter for column 操作单id
	 */
	public void setOperateOrderId(Long operateOrderId) {
		this.operateOrderId = operateOrderId;
	}

	/**
	 * getter for column 操作单id
	 */
	public Long getOperateOrderId() {
		return this.operateOrderId;
	}

	/**
	 * setter for column 操作单类型
	 */
	public void setOperateOrderType(Integer operateOrderType) {
		this.operateOrderType = operateOrderType;
	}

	/**
	 * getter for column 操作单类型
	 */
	public Integer getOperateOrderType() {
		return this.operateOrderType;
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
	 * setter for column 库存分表code
	 */
	public void setInventoryInfoId(Long inventoryInfoId) {
		this.inventoryInfoId = inventoryInfoId;
	}

	/**
	 * getter for column 库存分表code
	 */
	public Long getInventoryInfoId() {
		return this.inventoryInfoId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	public Long getServiceFeatures() {
		return serviceFeatures;
	}

	public void setServiceFeatures(Long serviceFeatures) {
		this.serviceFeatures = serviceFeatures;
	}

	public Integer getInventoryOperateMode() {
		return inventoryOperateMode;
	}

	public void setInventoryOperateMode(Integer inventoryOperateMode) {
		this.inventoryOperateMode = inventoryOperateMode;
	}
}
