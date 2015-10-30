package com.wdk.wms.basic.result;

import java.util.List;

public class CabinetInventoryEnable {

	/*
	 * 库位中库存大于等于订单需要占用库存 的库位集合
	 * */
	private List<CabinetInventoryInfo> enableCabinetInventorys;
	
	/*
	 * 库位中库存小于订单需要占用库存 的库位集合
	 * */
	private List<CabinetInventoryInfo> unableCabinetInventorys;

	public List<CabinetInventoryInfo> getEnableCabinetInventorys() {
		return enableCabinetInventorys;
	}

	public void setEnableCabinetInventorys(List<CabinetInventoryInfo> enableCabinetInventorys) {
		this.enableCabinetInventorys = enableCabinetInventorys;
	}

	public List<CabinetInventoryInfo> getUnableCabinetInventorys() {
		return unableCabinetInventorys;
	}

	public void setUnableCabinetInventorys(List<CabinetInventoryInfo> unableCabinetInventorys) {
		this.unableCabinetInventorys = unableCabinetInventorys;
	}
	
	
}
