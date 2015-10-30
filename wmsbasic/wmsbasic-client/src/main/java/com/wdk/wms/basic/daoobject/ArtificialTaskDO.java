package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:人工任务表
 * 
 * @author 李超 Date 2015-10-27
 */
public class ArtificialTaskDO {

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
	 * 单据号
	 */
	private Long orderId;

	/**
	 * 单据类型
	 */
	private Integer orderType;

	/**
	 * 任务类型：1，子订单扣减失败，2，拣货单分配失败
	 */
	private Integer taskType;

	/**
	 * 任务说明
	 */
	private String taskDescription;

	/**
	 * 任务状态：1，创建，2，完成
	 */
	private Integer status;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

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
	 * setter for column 单据号
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * getter for column 单据号
	 */
	public Long getOrderId() {
		return this.orderId;
	}

	/**
	 * setter for column 单据类型
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 * getter for column 单据类型
	 */
	public Integer getOrderType() {
		return this.orderType;
	}

	/**
	 * setter for column 任务类型：1，子订单扣减失败，2，拣货单分配失败
	 */
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	/**
	 * getter for column 任务类型：1，子订单扣减失败，2，拣货单分配失败
	 */
	public Integer getTaskType() {
		return this.taskType;
	}

	/**
	 * setter for column 任务说明
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * getter for column 任务说明
	 */
	public String getTaskDescription() {
		return this.taskDescription;
	}

	/**
	 * setter for column 任务状态：1，创建，2，完成
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 任务状态：1，创建，2，完成
	 */
	public Integer getStatus() {
		return this.status;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}
}