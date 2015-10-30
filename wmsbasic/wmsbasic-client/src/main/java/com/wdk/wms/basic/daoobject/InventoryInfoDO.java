package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库存信息
 * 
 * @author 滴石 Date 2015-09-06
 */
public class InventoryInfoDO {

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
	 * 商品Id
	 */
	private Long itemId;

	/**
	 * 货主
	 */
	private Long ownerId;

	/**
	 * 仓库
	 */
	private Long warehouseId;
	
	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 库位
	 */
	private Long cabinetId;

	/**
	 * 商品批次
	 */
	private Long itemBatchId;

	/**
	 * 实物库存
	 */
	private Long realInvent;

	/**
	 * 可用库存
	 */
	private Long availableInvent;

	/**
	 * 移库占用
	 */
	private Long transOccupy;

	/**
	 * 订单占用
	 */
	private Long orderOccupy;

	/**
	 * 退供占用
	 */
	private Long returnOccupy;

	/**
	 * 调拨占用
	 */
	private Long shiftOccupy;

	/**
	 * 报损占用
	 */
	private Long loseOccupy;

	/**
	 * 冻结占用
	 */
	private Long frozenOccupy;

	/**
	 * 加工占用
	 */
	private Long processOccupy;

	/**
	 * 库区
	 */
	private Long warehouseAreaId;

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
	 * setter for column 商品Id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品Id
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 货主
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 仓库
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 库位
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 库位
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	/**
	 * setter for column 商品批次
	 */
	public void setItemBatchId(Long itemBatchId) {
		this.itemBatchId = itemBatchId;
	}

	/**
	 * getter for column 商品批次
	 */
	public Long getItemBatchId() {
		return this.itemBatchId;
	}

	/**
	 * setter for column 实物库存
	 */
	public void setRealInvent(Long realInvent) {
		this.realInvent = realInvent;
	}

	/**
	 * getter for column 实物库存
	 */
	public Long getRealInvent() {
		return this.realInvent;
	}

	/**
	 * setter for column 可用库存
	 */
	public void setAvailableInvent(Long availableInvent) {
		this.availableInvent = availableInvent;
	}

	/**
	 * getter for column 可用库存
	 */
	public Long getAvailableInvent() {
		return this.availableInvent;
	}

	/**
	 * setter for column 移库占用
	 */
	public void setTransOccupy(Long transOccupy) {
		this.transOccupy = transOccupy;
	}

	/**
	 * getter for column 移库占用
	 */
	public Long getTransOccupy() {
		return this.transOccupy;
	}

	/**
	 * setter for column 订单占用
	 */
	public void setOrderOccupy(Long orderOccupy) {
		this.orderOccupy = orderOccupy;
	}

	/**
	 * getter for column 订单占用
	 */
	public Long getOrderOccupy() {
		return this.orderOccupy;
	}

	/**
	 * setter for column 退供占用
	 */
	public void setReturnOccupy(Long returnOccupy) {
		this.returnOccupy = returnOccupy;
	}

	/**
	 * getter for column 退供占用
	 */
	public Long getReturnOccupy() {
		return this.returnOccupy;
	}

	/**
	 * setter for column 调拨占用
	 */
	public void setShiftOccupy(Long shiftOccupy) {
		this.shiftOccupy = shiftOccupy;
	}

	/**
	 * getter for column 调拨占用
	 */
	public Long getShiftOccupy() {
		return this.shiftOccupy;
	}

	/**
	 * setter for column 报损占用
	 */
	public void setLoseOccupy(Long loseOccupy) {
		this.loseOccupy = loseOccupy;
	}

	/**
	 * getter for column 报损占用
	 */
	public Long getLoseOccupy() {
		return this.loseOccupy;
	}

	/**
	 * setter for column 冻结占用
	 */
	public void setFrozenOccupy(Long frozenOccupy) {
		this.frozenOccupy = frozenOccupy;
	}

	/**
	 * getter for column 冻结占用
	 */
	public Long getFrozenOccupy() {
		return this.frozenOccupy;
	}

	/**
	 * setter for column 加工占用
	 */
	public void setProcessOccupy(Long processOccupy) {
		this.processOccupy = processOccupy;
	}

	/**
	 * getter for column 加工占用
	 */
	public Long getProcessOccupy() {
		return this.processOccupy;
	}

	/**
	 * setter for column 库区
	 */
	public void setWarehouseAreaId(Long warehouseAreaId) {
		this.warehouseAreaId = warehouseAreaId;
	}

	/**
	 * getter for column 库区
	 */
	public Long getWarehouseAreaId() {
		return this.warehouseAreaId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
	
}
