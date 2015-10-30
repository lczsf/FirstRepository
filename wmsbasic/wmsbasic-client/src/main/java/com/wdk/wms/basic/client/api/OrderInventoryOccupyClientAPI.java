package com.wdk.wms.basic.client.api;

import java.util.List;


import com.wdk.wms.basic.out.order.parameters.SaleOrderInfo;
import com.wdk.wms.inventory.parameters.OrderInventoryResult;


public interface OrderInventoryOccupyClientAPI {
	/*
	 * @author dishi
	 * @saleOrderInfosm 订单信息集合
	 * @cabinetTypeRange 库位类型范围
	 * @isStockoutOccupy 是否缺货占用
	 */
      public List<OrderInventoryResult> orderInventoryOccupy(List<SaleOrderInfo> saleOrderInfos,int[]cabinetTypeRange,int isSale,int outOperationMode,boolean isStockoutOccupy);
      
      public boolean generatePickingOrder(long waveId,long warehouseId);//通过波次id，生成拣货单
}
