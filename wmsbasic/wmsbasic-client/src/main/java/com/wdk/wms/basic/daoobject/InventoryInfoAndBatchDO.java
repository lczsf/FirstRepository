package com.wdk.wms.basic.daoobject;

import java.util.Date;

public class InventoryInfoAndBatchDO extends InventoryInfoDO {

	/* 生产日期 */
	private Date produceDate;

	/* 到货日期 */
	private Date arriveDate;

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
