package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDetailDO;
import com.wdk.wms.basic.result.InventoryProcessResult;
import com.wdk.wms.inventory.parameters.OnShelfUpateParameter;

public interface OnshelfClientAPI {

	/**
	 * 上架，库存操作
	 */
	public InventoryProcessResult<Integer> OnShelf(PutawayOrderDetailDO putawayOrderDetailDO);

	/**
	 * 容器上架，库存操作
	 * 
	 * @param putawayOrderDetailDOs
	 * @param operationId
	 *            操作人id
	 * @return
	 */
	public InventoryProcessResult<Integer> ContainerOnShelf(List<PutawayOrderDetailDO> putawayOrderDetailDOs, Long operationId);

	/**
	 * 更新单据，释放容器
	 * 
	 * @param onShelfUpateParameter
	 * @return
	 */
	public Boolean updateStatus(OnShelfUpateParameter onShelfUpateParameter);
	
	/**
	 * 归位单,上架
	 *
	 */
	public InventoryProcessResult<Integer> backOrderOnShelf( long waveId, long warehouseId, long warehouseCode);
	
}
