package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.daoobject.PickingContainerDetailDO;

/**
 * Description: 拣货装箱单接口
 *
 * @author 刘勇
 * @Date 15/10/16
 */
public interface PickingContainerClientAPI {

	/**
	 * 更新状态 并绑定库位
	 * 
	 * @param id
	 *            id
	 * @param cabinetId
	 *            库位id 可null 不绑定库位
	 * @param status
	 *            状态
	 * @see com.wdk.wms.basic.enums.PickingContainerStatusEnum
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	int updateStatusAndCabinet(Long id, int status, Long cabinetId, Long warehouseId);

	/**
	 *
	 * 通过容器code 和 拣货单id 查询
	 *
	 * @param containerCode
	 *            容器code 可null 不通过容器code查询
	 * @param pickingOrderId
	 *            拣货单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	PickingContainerDO queryByContainerCodeAndPicOrderId(String containerCode, Long pickingOrderId, Long warehouseId);

	/**
	 * 通过波次id 和 容器code 查询 并以最后修改时间 降序排序
	 * 
	 * @param waveId
	 *            波次id 可为空 不通过状态查询
	 * @param containerCode
	 *            容器code 可null 不通过容器code查询
	 * @param warehouseId
	 *            仓库id
	 * @param status
	 *            状态 可null 不通过状态查询
	 * @see com.wdk.wms.basic.enums.PickingContainerStatusEnum
	 * @return
	 */
	List<PickingContainerDO> queryByWaveIdAndContainerCode(Long waveId, String containerCode, Long warehouseId, Integer status);


	/**
	 * 通过商品id 和 拣货单明细id 查询
	 * 
	 * @param pickingOrderDetailId
	 *            拣货单明细id
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	PickingContainerDetailDO queryByPickingOrderDetailId(Long pickingOrderDetailId, Long waveId, Long warehouseId);
	/**
	 * 根据波次id更新拣货装箱单状态
	 * @param status
	 * 		  装箱单状态
	 * @param waveId
	 * 		  波次id
	 * @param warehouseId
	 * 		  仓库id
	 * @param operatorId
	 *  	操作人id
	 * @return
	 */
	boolean updatePickingContainerStatus(int status, long waveId, long warehouseId,long operatorId);

	/**
	 * 查询拣货装箱单明细
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param pickingContainerIds
	 *            拣货装箱单ids
	 * @return
	 */
	List<PickingContainerDetailDO> queryByPickingContainerIds(Long waveId, Long warehouseId, List<Long> pickingContainerIds);

}
