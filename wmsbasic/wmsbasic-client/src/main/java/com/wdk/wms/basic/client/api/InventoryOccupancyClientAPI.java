package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.InventoryOccupancyDO;

import java.util.List;

/**
 * Description: 库存占用
 *
 * @author 刘勇
 * @Date 15/10/12
 */
public interface InventoryOccupancyClientAPI {

	/**
	 * 插入
	 * 
	 * @param inventoryOccupancyDO
	 * @return
	 */
	Long insertInventoryOccupancyDO(InventoryOccupancyDO inventoryOccupancyDO);

	/**
	 * 通过波次id查询
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param WaveId
	 *            波次id
	 * @return
	 */
	List<InventoryOccupancyDO> queryByWaveId(Long WaveId, Long warehouseId);

	/**
	 * 更新占用单id 和 占用单类型
	 * 
	 * @param id
	 *            id
	 * @param occupancyOrderId
	 *            占用单id
	 * @param occupancyOrderType
	 *            占用单类型
	 * @param warehouseId
	 *            仓库id
	 * @param waveId
	 *            波次id
	 * @return
	 */
	int updateOccupancyOrderId(Long id, Long occupancyOrderId, int occupancyOrderType, Long warehouseId, Long waveId);

	/**
	 * 通过占用单id查询
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param waveId
	 *            波次id
	 * @param occupancyOderType
	 *            占用单类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param occupancyOrderIds
	 *            占用单ids
	 * @return
	 */
	List<InventoryOccupancyDO> queryByOccupancyOrderId(Long warehouseId, Long waveId, int occupancyOderType, List<Long> occupancyOrderIds);

}
