package com.wdk.wms.basic.out.order.parameters;

import java.util.List;

import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;



public class SaleOrderInfo {

	/**
	 * 主订单
	 */
	private SalesOrderDO salesOrderDO;
	
	/**
	 * 子订单
	 */
	private List<SalesOrderDetailDO> salesOrderDetailDOs;

	public SalesOrderDO getSalesOrderDO() {
		return salesOrderDO;
	}

	public void setSalesOrderDO(SalesOrderDO salesOrderDO) {
		this.salesOrderDO = salesOrderDO;
	}

	public List<SalesOrderDetailDO> getSalesOrderDetailDOs() {
		return salesOrderDetailDOs;
	}

	public void setSalesOrderDetailDOs(List<SalesOrderDetailDO> salesOrderDetailDOs) {
		this.salesOrderDetailDOs = salesOrderDetailDOs;
	}
	
	
}
