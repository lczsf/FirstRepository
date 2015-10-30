package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.InventoryOccupancyDO;

import java.util.List;

/**
 * Description: 库存占用表
 *
 * @author 刘勇
 * @Date 15/10/8
 */
@Dao("inventory_occupancy")
public interface InventoryOccupancyDAO {

	@Insert
	Long insertInventoryOccupancyDO(InventoryOccupancyDO inventoryOccupancyDO);

	@Update
	int updateInventoryOccupancy(InventoryOccupancyDO inventoryOccupancyDO);

	@Delete
	int deleteByIds(String ids);

	/**
	 * 通过波次id获取库存占用
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param waveId
	 *            波次id
	 * @return
	 */
	@Select
	List<InventoryOccupancyDO> queryByWaveId(@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 更新占用的id
	 * 
	 * @param id
	 *            id
	 * @param occupancyOrderId
	 *            占用的id
	 * @param occupancyOrderType
	 *            占用的类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id 分表
	 * @return
	 */
	@Update
	int updateOccupancyOrder(@Param("id") Long id, @Param("occupancyOrderId") Long occupancyOrderId, @Param("occupancyOrderType") int occupancyOrderType,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 更新操作单id 和 操作单类型
	 * 
	 * @param id
	 *            id
	 * @param operateOrderId
	 *            操作单id
	 * @param operateOrderType
	 *            操作单类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id 分表
	 * @return
	 */
	@Update
	int updateOccupancyOrderOperater(@Param("id") Long id, @Param("operateOrderId") Long operateOrderId, @Param("operateOrderType") int operateOrderType,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 通过操作单查询
	 * 
	 * @param operateOrderId
	 *            操作单id
	 * @param operateOrderType
	 *            操作单类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id 分表
	 * @return
	 */
	@Select
	List<InventoryOccupancyDO> queryByOperateOrder(@Param("operateOrderId") Long operateOrderId, @Param("operateOrderType") int operateOrderType,
			@Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 更新实操数量
	 * 
	 * @param id
	 *            id
	 * @param actualQuantity
	 *            实操数量
	 * @param warehouseCode
	 *            分表coed
	 * @param waveId
	 *            波次id分表
	 * @return
	 */
	@Update
	int updateActualQuantity(@Param("id") Long id, @Param("actualQuantity") Double actualQuantity, @Param("warehouseCode") Long warehouseCode,
			@Param("waveId") Long waveId);

	/**
	 * 通过占用单id 查询
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param waveId
	 *            波次id
	 * @param occupancyOderType
	 *            占用单类型
	 * @see com.wdk.wms.basic.enums.SourceTypeEnum
	 * @param occupancyOrderIds
	 *            占用单ids
	 * @return
	 */
	@Select
	List<InventoryOccupancyDO> queryByOccupancyOrderId(@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode,
			@Param("waveId") Long waveId, @Param("occupancyOderType") int occupancyOderType, @Param("occupancyOrderIds") List<Long> occupancyOrderIds);
}
