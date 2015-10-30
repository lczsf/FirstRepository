package com.wdk.wms.basic.query.parameters;


public class PickingOrderQuery extends BaseQuery {

	/**
	 * 拣货单code
	 */
	private String pickingOrderCode;

	/**
	 * 拣货分区id
	 */
	private Long sortingGoodsPartitionId;

	/**
	 * 拣货单状态
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
	 * 拣货操作人id
	 */
	private Long operatorId;

	/**
	 * 拣货分区id集合
	 */
	private String sortingGoodsPartitionIds;

	/**
	 * 拣货人
	 */
	private Long responsibleId;

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getPickingOrderCode() {
		return pickingOrderCode;
	}

	public void setPickingOrderCode(String pickingOrderCode) {
		this.pickingOrderCode = pickingOrderCode;
	}


	public Long getSortingGoodsPartitionId() {
		return sortingGoodsPartitionId;
	}

	public void setSortingGoodsPartitionId(Long sortingGoodsPartitionId) {
		this.sortingGoodsPartitionId = sortingGoodsPartitionId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}

}
