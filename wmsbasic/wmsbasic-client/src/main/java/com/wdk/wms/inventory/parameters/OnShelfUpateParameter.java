package com.wdk.wms.inventory.parameters;

import java.util.List;

import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;

public class OnShelfUpateParameter {

	
	/**
	 * 仓库id
	 */
	private Long warehouseId;
	
	/**
	 * 装箱单id
	 */
	private Long containerOrderId;

	/**
	 * 上架单id
	 */
	private Long putawayOrderId;

	/**
	 * 差异单
	 */
	private DiffOrderDO diffOrderDO;

	/**
	 * 差异单明细
	 */
	private List<DiffOrderDetailDO> diffOrderDetailDOs;

	public Long getContainerOrderId() {
		return containerOrderId;
	}

	public void setContainerOrderId(Long containerOrderId) {
		this.containerOrderId = containerOrderId;
	}

	public Long getPutawayOrderId() {
		return putawayOrderId;
	}

	public void setPutawayOrderId(Long putawayOrderId) {
		this.putawayOrderId = putawayOrderId;
	}

	public DiffOrderDO getDiffOrderDO() {
		return diffOrderDO;
	}

	public void setDiffOrderDO(DiffOrderDO diffOrderDO) {
		this.diffOrderDO = diffOrderDO;
	}

	public List<DiffOrderDetailDO> getDiffOrderDetailDOs() {
		return diffOrderDetailDOs;
	}

	public void setDiffOrderDetailDOs(List<DiffOrderDetailDO> diffOrderDetailDOs) {
		this.diffOrderDetailDOs = diffOrderDetailDOs;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	

}
