package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.PickingOrderDO;
import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;
import com.wdk.wms.basic.query.parameters.PickingOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.PickingOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:拣货单接口，拣货单明细接口
 * 
 * @author 李超 Date 2015-09-07
 */
public interface PickingOrderClientAPI {
	/**
	 * 拣货单接口
	 */
	/**
	 * 分页查询拣货单
	 * 
	 * @param pickingOrderQuery
	 * @return
	 */
	public PageResult<PickingOrderDO> queryPickingOrderPage(PickingOrderQuery pickingOrderQuery);

	/**
	 * 插入拣货单信息
	 * 
	 * @param pickingOrderDO
	 * @return
	 */
	public long insertPickingOrder(PickingOrderDO pickingOrderDO);

	/**
	 * 修改拣货单
	 * 
	 * @param pickingOrderDO
	 * @return
	 */
	public int updatePickingOrder(PickingOrderDO pickingOrderDO);

	/**
	 * 根据仓库id，拣货分区code查询创建状态的拣货单数量
	 * 
	 * @param sortingGoodsPartitioncode
	 *            拣货分区code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int queryCountByCodeAndWarehouseId(List<String> sortingGoodsPartitioncode, long warehouseId);

	/**
	 * 根据code查询拣货单
	 * 
	 * @param code
	 *            拣货单code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PickingOrderDO queryPickingOrderByCode(String code, long warehouseId);

	/**
	 * 根据拣货分区code，用户id，仓库id，得到此操作人已拥有的拣货单code。
	 * 
	 * @param sortingGoodsPartitioncode
	 *            拣货分区code
	 * @param userId
	 *            用户id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public String queryHaveCodeByArguments(List<String> sortingGoodsPartitioncode, long userId, long warehouseId);

	/**
	 * 据拣货分区code， 仓库id，查询"拣货优先级"最高的拣货单code,并且绑定操作人
	 * 
	 * @param sortingGoodsPartitioncode
	 * @param warehouseId
	 * @return
	 */
	public String queryPriorityCodeByArguments(List<String> sortingGoodsPartitioncode, long userId, long warehouseId);

	/**
	 * 拣货单明细接口
	 */
	/**
	 * 查询拣货单明细
	 * 
	 * @param pickingOrderDetailQuery
	 * @return
	 */
	public PageResult<PickingOrderDetailDO> queryPickingOrderDetailPage(PickingOrderDetailQuery pickingOrderDetailQuery);

	/**
	 * 插入拣货单明细
	 * 
	 * @param pickingOrderDetailDO
	 * @return
	 */
	public long insertPickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO);

	/**
	 * 修改拣货单明细
	 * 
	 * @param pickingOrderDetailDO
	 * @return
	 */
	public int updatePickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO);

	/**
	 * 根据拣货单code,仓库id查询拣货单详情列表
	 * 
	 * @param pickingOrderCode
	 * @param waveId
	 * @param warehouseId
	 * @return
	 */
	public List<PickingOrderDetailDO> queryByPickingOrderCodeAndWarehouseId(String pickingOrderCode, Long waveId, Long warehouseId);

	/**
	 * 根据拣货单详情id，仓库id查询拣货单详情
	 * 
	 * @param pickingOrderDetailid
	 *            拣货单详情id
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PickingOrderDetailDO queryByPickingOrderDetailId(Long pickingOrderId, Long waveId, Long pickingOrderDetailId, Long warehouseId);

	/**
	 * 根据拣货单code,仓库id查询创建状态的拣货单详情列表
	 * 
	 * @param pickingOrderCode
	 * @param warehouseId
	 * @return
	 */
	public List<PickingOrderDetailDO> queryCreateBypickingOrderCode(String pickingOrderCode, Long warehouseId);

	/**
	 * 根据拣货优先级排序拣货单详情列表
	 * 
	 * @param pickingOrderDetailDOs
	 * @return
	 */
	public List<PickingOrderDetailDO> sortPickingOrderDetailDOs(List<PickingOrderDetailDO> pickingOrderDetailDOs);

	/**
	 * 根据波次id查询拣货单列表
	 * 
	 * @param waveId
	 * @param warehouseId
	 * @return
	 */
	public List<PickingOrderDO> queryByWaveId(Long waveId, Long warehouseId);

	/**
	 * 更新拣货单接收状态
	 * 
	 * @param id
	 *            拣货单id
	 * @param notifyStatus
	 *            状态
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateNotifyStatus(long id, int notifyStatus, long warehouseId);
}
