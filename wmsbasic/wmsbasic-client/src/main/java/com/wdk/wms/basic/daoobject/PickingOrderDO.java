package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:拣货单表
 * 
 * @author 李超 Date 2015-10-08
 */
public class PickingOrderDO {

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
	 * 拣货单code
	 */
	private String code;

	/**
	 * 拣货分区id
	 */
	private Long sortingGoodsPartitionId;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 波次号
	 */
	private Long waveId;


	/**
	 * 拣货单状态(创建、拣货中、拣货完成)
	 */
	private Integer status;

	/**
	 * 拣货单类型(销售拣货)
	 */
	private Integer type;

	/**
	 * 拣货工具(RFor标签=取值拣货分区对应拣货工具 )
	 */
	private Integer pickingTool;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 拣货优先级
	 */
	private Long pickingPriority;

	/**
	 * 拣货操作人id
	 */
	private Long operatorId;

	/**
	 * 拣货分区id字符串
	 */
	private String sortingGoodsPartitionIds;

	/**
	 * 版本号
	 */
	private Integer version;

	/**
	 * 责任人
	 */
	private Long responsibleId;

	/**
	 * 接收状态
	 */
	private Integer notifyStatus;

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
	 * setter for column 拣货单code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 拣货单code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 拣货分区id
	 */
	public void setSortingGoodsPartitionId(Long sortingGoodsPartitionId) {
		this.sortingGoodsPartitionId = sortingGoodsPartitionId;
	}

	/**
	 * getter for column 拣货分区id
	 */
	public Long getSortingGoodsPartitionId() {
		return this.sortingGoodsPartitionId;
	}

	/**
	 * setter for column 货主id
	 */


	/**
	 * setter for column 仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 仓库id
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 波次号
	 */
	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	/**
	 * getter for column 波次号
	 */
	public Long getWaveId() {
		return this.waveId;
	}


	/**
	 * setter for column 拣货单状态(创建、拣货中、拣货完成)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 拣货单状态(创建、拣货中、拣货完成)
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 拣货单类型(销售拣货)
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 拣货单类型(销售拣货)
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 拣货工具(RFor标签=取值拣货分区对应拣货工具 )
	 */
	public void setPickingTool(Integer pickingTool) {
		this.pickingTool = pickingTool;
	}

	/**
	 * getter for column 拣货工具(RFor标签=取值拣货分区对应拣货工具 )
	 */
	public Integer getPickingTool() {
		return this.pickingTool;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getPickingPriority() {
		return pickingPriority;
	}

	public void setPickingPriority(Long pickingPriority) {
		this.pickingPriority = pickingPriority;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getSortingGoodsPartitionIds() {
		return sortingGoodsPartitionIds;
	}

	public void setSortingGoodsPartitionIds(String sortingGoodsPartitionIds) {
		this.sortingGoodsPartitionIds = sortingGoodsPartitionIds;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}

	public Integer getNotifyStatus() {
		return notifyStatus;
	}

	public void setNotifyStatus(Integer notifyStatus) {
		this.notifyStatus = notifyStatus;
	}

}