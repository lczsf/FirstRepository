package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description: 拣货装箱单
 *
 * @author 刘勇
 * @Date 15/10/9
 */
public class PickingContainerDO {

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
	 * 拣货箱号（容器code）
	 */
	private String containerCode;

	/**
	 * 拣货单id
	 */
	private Long pickingOrderId;

	/**
	 * 拣货人
	 */
	private Long operatorId;

	/**
	 * 库位
	 */
	private Long cabinetId;

	/**
	 * 状态:0:创建、1:箱满、2:已复核
	 */
	private Integer status;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 拣货人
	 */
	private Long responsibleId;

	/**
	 * 波次id
	 */
	private Long waveId;

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
	 * setter for column 拣货箱号（容器code）
	 */
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	/**
	 * getter for column 拣货箱号（容器code）
	 */
	public String getContainerCode() {
		return this.containerCode;
	}

	/**
	 * setter for column 拣货单id
	 */
	public void setPickingOrderId(Long pickingOrderId) {
		this.pickingOrderId = pickingOrderId;
	}

	/**
	 * getter for column 拣货单id
	 */
	public Long getPickingOrderId() {
		return this.pickingOrderId;
	}

	/**
	 * setter for column 拣货人
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 拣货人
	 */
	public Long getOperatorId() {
		return this.operatorId;
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
	 * setter for column 状态:0:创建、1:箱满、2:已复核
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态:0:创建、1:箱满、2:已复核
	 */
	public Integer getStatus() {
		return this.status;
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

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

}