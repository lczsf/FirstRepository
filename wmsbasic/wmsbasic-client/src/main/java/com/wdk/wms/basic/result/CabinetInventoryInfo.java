package com.wdk.wms.basic.result;

import java.util.Date;
import java.util.List;
import com.wdk.wms.basic.daoobject.InventoryInfoAndBatchDO;

/*
 * 记录某个库位下的库存记录
 */
public class CabinetInventoryInfo {

	/* 库位 */
	private Long cabinetId;
	
	/* 生产日期 */
	private Date produceDate;

	/* 到货日期 */
	private Date arriveDate;
	
	/* 该库位下的库存记录 */
	private List<InventoryInfoAndBatchDO>inventoryInfoDOs;
	
	/* 库位上所有的可用库存的总量 */
	private double  totalAvailableQuanity;

	public List<InventoryInfoAndBatchDO> getInventoryInfoDOs() {
		return inventoryInfoDOs;
	}

	public void setInventoryInfoDOs(List<InventoryInfoAndBatchDO> inventoryInfoDOs) {
		this.inventoryInfoDOs = inventoryInfoDOs;
	}

	public double getTotalAvailableQuanity() {
		return totalAvailableQuanity;
	}

	public void setTotalAvailableQuanity(double totalAvailableQuanity) {
		this.totalAvailableQuanity = totalAvailableQuanity;
	}

	public Long getCabinetId() {
		return cabinetId;
	}

	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	
	
}
