package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.daoobject.PickingContainerDetailDO;

import java.util.List;

/**
 * Description: 拣货装箱单明细表
 *
 * @author 刘勇
 * @Date 15/10/9
 */
@Dao("picking_container_detail")
public interface PickingContainerDetailDAO {

	@Insert
	Long insertPickingContainerDetail(PickingContainerDetailDO pickingContainerDetailDO);

	/**
	 * 通过id 累加商品数量
	 *
	 * @param id
	 *            id
	 * @param pickingContainerId
	 *            贱货装箱单id
	 * @param mainSortNumber
	 *            需累加的主计价商品数量
	 * @param pickingSortNumber
	 *            需要累加的拣货数量
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id分表
	 * @return
	 */
	@Update
	int updateItemQuantity(@Param("id") Long id, @Param("pickingContainerId") Long pickingContainerId, @Param("mainSortNumber") Double mainSortNumber,
			@Param("pickingSortNumber") Double pickingSortNumber, @Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 通过装箱拣货单id 查询
	 * 
	 * @param id
	 *            id
	 * @param pickingContainerId
	 *            拣货装箱单主表id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Select
	PickingContainerDetailDO queryByPickingContainerId(@Param("id") Long id, @Param("pickingContainerId") Long pickingContainerId,
			@Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 通过商品id 拣货装箱单id 商品id 查询
	 * 
	 * @param pickingContainerId
	 *            拣货装箱单id
	 * @param pickingOrderDetailId
	 *            拣货单明细id
	 * @param itemId
	 *            商品id
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id
	 * @return
	 */
	@Select
	PickingContainerDetailDO queryByPickingContainerIdAndItemId(@Param("pickingContainerId") Long pickingContainerId,
			@Param("pickingOrderDetailId") Long pickingOrderDetailId, @Param("itemId") Long itemId, @Param("warehouseCode") Long warehouseCode,
			@Param("waveId") Long waveId);

	/**
	 * 查询 拣货装箱单下所有拣货装箱单明细
	 * 
	 * @param pickingContainerId
	 *            拣货装箱单
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id
	 * @return
	 */
	@Select
	List<PickingContainerDetailDO> queryListByPickingContainerId(@Param("pickingContainerId") Long pickingContainerId,
			@Param("warehouseCode") Long warehouseCode, @Param("waveId") Long waveId);

	/**
	 * 通过 拣货装箱单ids 查询
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseCode
	 *            仓库code
	 * @param pickingContainerIds
	 *            拣货装箱单ids
	 * @return
	 */
	@Select
	List<PickingContainerDetailDO> queryByPickingContainerIds(@Param("waveId") Long waveId, @Param("warehouseCode") Long warehouseCode,
			@Param("pickingContainerIds") List<Long> pickingContainerIds);
}