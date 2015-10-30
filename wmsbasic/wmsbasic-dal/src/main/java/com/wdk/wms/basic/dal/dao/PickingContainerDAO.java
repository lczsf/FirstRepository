package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.enums.PickingContainerStatusEnum;

/**
 * Description: 拣货装箱单
 *
 * @author 刘勇
 * @Date 15/10/8
 */
@Dao("picking_container")
public interface PickingContainerDAO {

	@Insert
	Long insertPickingContainerDO(PickingContainerDO pickingContainerDO);

	@Update
	int updatePickingContainerDO(PickingContainerDO pickingContainerDO);

	@Delete
	int deleteByIds(String ids);

	/**
	 * 通过容器code 和 拣货单id 查询
	 * 
	 * @param containerCode
	 *            容器code 可null 不通过容器code查询
	 * @param pickingOrderId
	 *            拣货单id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库code
	 * @return
	 */
	@Select
	PickingContainerDO queryByContainerCodeAndPicOrderId(@Param("containerCode") String containerCode, @Param("pickingOrderId") Long pickingOrderId,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 更新状态 并绑定库位
	 * 
	 * @param id
	 *            id
	 * @param status
	 *            状态
	 * @see PickingContainerStatusEnum
	 * @param cabinetId
	 *            库位id 可空 不绑定库位 只更新状态
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Update
	int updateStatusAndCabinet(@Param("id") Long id, @Param("status") int status, @Param("cabinetId") Long cabinetId, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过波次id 容器code 查询 并以修改时间 降序排序
	 * 
	 * @param waveId
	 *            波次id 可null 不通过状态查询
	 * @param containerCode
	 *            容器code 可null 不通过容器查询
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @param status
	 *            状态 可null 不通过状态查询
	 * @see com.wdk.wms.basic.enums.PickingContainerStatusEnum
	 * @return
	 */
	@Select
	List<PickingContainerDO> queryByWaveIdAndContainerCode(@Param("waveId") Long waveId, @Param("containerCode") String containerCode,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode, @Param("status") Integer status);
	/**
	 * 通过id查询
	 * 
	 * @param id
	 *            id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Select
	PickingContainerDO queryById(@Param("id") Long id, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);
	
	/**
	 * 用给定的波次id更新拣货装箱单状态
	 * @param status
	 * @param waveIdList
	 * @param operatorId
	 * @return
	 */
	@Update
	int updatePickingContainerStatus(@Param("status")  int status, @Param("waveId") long waveId,@Param("warehouseId") long warehouseId,@Param("warehouseCode") long warehouseCode, @Param("operatorId") long operatorId);

	/**
	 * 通过拣货单id查询
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @param pickingOrderId
	 *            拣货单id
	 * @return
	 */
	@Select
	List<PickingContainerDO> queyrByPickingOrderId(@Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode,
			@Param("pickingOrderId") long pickingOrderId);
}
