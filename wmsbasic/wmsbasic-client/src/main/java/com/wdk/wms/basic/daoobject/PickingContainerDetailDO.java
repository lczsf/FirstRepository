package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:拣货装箱表明细
 * 
 * @author 刘勇 Date 2015-10-09
 */
public class PickingContainerDetailDO {

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
	 * 拣货箱号单id
	 */
	private Long pickingContainerId;

	/**
	 * 商品id
	 */
	private Long itemId;


	/**
	 * 库位id
	 */
	private Long cabinetId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 拣货单明细id
	 */
	private Long pickingOrderDetailId;


	/**
	 * 主计价单位拣货数量
	 */
	private Double mainSortNumber;


	/**
	 * 拣货单位拣货数量
	 */
	private Double pickingSortNumber;

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
	 * setter for column 拣货装箱单主表id
	 */
	public void setPickingContainerId(Long pickingContainerId) {
		this.pickingContainerId = pickingContainerId;
	}

	/**
	 * getter for column 拣货装箱单主表id
	 */
	public Long getPickingContainerId() {
		return this.pickingContainerId;
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

	public Long getCabinetId() {
		return cabinetId;
	}

	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	public Long getPickingOrderDetailId() {
		return pickingOrderDetailId;
	}

	public void setPickingOrderDetailId(Long pickingOrderDetailId) {
		this.pickingOrderDetailId = pickingOrderDetailId;
	}


	public Double getMainSortNumber() {
		return mainSortNumber;
	}

	public void setMainSortNumber(Double mainSortNumber) {
		this.mainSortNumber = mainSortNumber;
	}

	public Double getPickingSortNumber() {
		return pickingSortNumber;
	}

	public void setPickingSortNumber(Double pickingSortNumber) {
		this.pickingSortNumber = pickingSortNumber;
	}
}