package com.wdk.wms.basic.client.api;

import java.util.Date;
import java.util.List;

import com.wdk.wms.basic.daoobject.ContainerOrderDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDetailDO;
import com.wdk.wms.basic.query.parameters.ContainerOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description: 装箱单
 *
 * @author 刘勇
 * @Date 15/9/8
 */
public interface ContainerOrderClientAPI {
	/**
	 * 插入装箱单主记录
	 */
	public long insertContainerOrder(ContainerOrderDO containerOrderDO);

	/**
	 * 查询装箱单记录
	 */
	public PageResult<ContainerOrderDO> queryContainerOrder(ContainerOrderQuery containerOrderQuery);

	/**
	 * 插入装箱单详情记录
	 */
	public long insertContainerOrderDetail(ContainerOrderDetailDO containerOrderDetailDO);

	/**
	 * 根据主装箱单id查询装箱单详情记录
	 */
	public List<ContainerOrderDetailDO> queryContainerOrderDetail(long containerOrderId, Long warehouseId);

	/**
	 * 查询装箱单
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param containerCode
	 *            容器编码
	 * @param status
	 *            状态
	 * @see com.wdk.wms.basic.enums.ContainerOrderStatusEnum
	 * @return
	 */
	public ContainerOrderDO queryByWarehouseIdAndCode(String containerCode, int status, Long warehouseId);

	/**
	 * 查询装箱单明细
	 * 
	 * @param containerOrderId
	 *            装箱单id
	 * @param itemCode
	 *            商品code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ContainerOrderDetailDO queryByOrderIdAndItemCode(Long containerOrderId, String itemCode, Long warehouseId);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ContainerOrderDO queryById(Long id, Long warehouseId);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @param warehouseId
	 *            仓库id
	 * @param containerOrderId
	 *            主表code
	 * @return
	 */
	public ContainerOrderDetailDO queryDetailById(Long id, long containerOrderId, Long warehouseId);

	/**
	 * 校验 装箱单明细 商品是否有多个批次
	 * 
	 * @param asnId
	 *            装箱单id
	 * @param containerCode
	 *            容器编码
	 * @param itemCode
	 *            商品编码
	 * @param batchId
	 *            批次id
	 * @param warehouseId
	 *            仓库id
	 * @return false 没有多个批次 true 有多个批次或无装箱单
	 */
	public Boolean checkItemBatch(Long asnId, String containerCode, String itemCode, Long batchId, Long warehouseId);

	/**
	 * 生成批次
	 * 
	 * @param produceDate
	 *            生成日期
	 * @param arriveDate
	 *            到货日期
	 * @return 批次id
	 */
	public Long generateBatchId(Date produceDate, Date arriveDate);

	/**
	 * 查询装箱单 状态为创建：1
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param containerCode
	 *            容器编号
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ContainerOrderDO queryByAsnIdAndCode(Long asnId, String containerCode, Long warehouseId);

	/**
	 * 创建装箱单
	 * 
	 * @param asnId
	 *            通知单id
	 * @param isRF
	 *            是否RF收货
	 * @param containerCode
	 *            容器编号
	 * @param operatorId
	 *            操作人
	 * @param warehouseId
	 *            仓库id
	 * @return 装箱单id
	 * @deprecated
	 */
	public Long generateContainerOrder(Long asnId, Boolean isRF, String containerCode, Long operatorId, Long warehouseId);

	/**
	 * 通过id更新状态
	 * 
	 * @param id
	 *            id
	 * @param status
	 *            状态
	 * @param operatorId
	 *            操作人id
	 * @see com.wdk.wms.basic.enums.ContainerOrderStatusEnum
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateOrderStatus(Long id, int status, Long operatorId, Long warehouseId);

	/**
	 * 通过 通知单id和容器编码 将装箱单状态改为 ”暂存“ 并关联默认库位
	 * 
	 * @param asnId
	 *            通知单id
	 * @param containerCode
	 *            容器编码
	 * @param operatorId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 * @deprecated
	 */
	public int updateStatusAndAssociatCabinet(Long asnId, String containerCode, Long operatorId, Long warehouseId);

	/**
	 * 创建装箱单明细 并更新 到货通知单 实收数量和实收件数
	 * 
	 * @param orderId
	 *            装箱单id
	 * @param itemCode
	 *            商品编码
	 * @param itemBatchId
	 *            商品批次
	 * @param packageQuantity
	 *            实收件数
	 * @param operatorId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public Long generateContainerOrderData(Long orderId, String itemCode, Long itemBatchId, double packageQuantity, Long operatorId, Long warehouseId);

	/**
	 * 校验通知单下所有装箱单是否都是暂存状态 2
	 * 
	 * @param asnId
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @return true 是 false 否
	 */
	public Boolean checkStatusByAsnId(Long asnId, Long warehouseId);

	/**
	 * 通过 装箱单id 和 商品id 获取装箱单明细
	 * 
	 * @param orderId
	 *            装箱单id
	 * @param itemId
	 *            商品id
	 * @param warehouseId
	 *            仓库分表id
	 * @return
	 */
	public ContainerOrderDetailDO queryByOrderIdAndItemId(Long orderId, Long itemId, Long warehouseId);

	/**
	 * 通过id删除 装箱单明细 并减去到货通知单实收收货
	 * 
	 * @param orderDetailId
	 *            装箱明细变id
	 * @param warehouseId
	 *            仓库id
	 * @param containerOrderId
	 *            主表id
	 * @return
	 */
	public int deleteById(Long orderDetailId, Long warehouseId, Long containerOrderId);

	/**
	 * 通过通知单id 获取已收明细
	 *
	 * @param asnId
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<ContainerOrderDetailDO> queryArrivalReceivedDetail(Long asnId, Long warehouseId);

	/**
	 * 更新操作人
	 * 
	 * @param id
	 *            id
	 * @param operationId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateOperatorId(Long id, Long operationId, Long warehouseId);

	/**
	 * 查询装箱单 状态为非完成：!= 3
	 *
	 * @param asnId
	 *            到货通知单id
	 * @param containerCode
	 *            容器编号
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ContainerOrderDO queryByAsnIdAndCodeNotComplete(Long asnId, String containerCode, Long warehouseId);
}
