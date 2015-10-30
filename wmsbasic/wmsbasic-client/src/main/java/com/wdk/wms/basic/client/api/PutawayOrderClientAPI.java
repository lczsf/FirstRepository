package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.PutawayOrderDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDetailDO;
import com.wdk.wms.basic.query.parameters.PutawayOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.PutawayOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:上架单，上架单详情
 * 
 * @author 李超 Date 2015-09-07
 */
public interface PutawayOrderClientAPI {

	/**
	 * 分页查询上架单
	 * 
	 * @param putawayOrderQuery
	 *            上架单Query
	 * @return
	 */
	public PageResult<PutawayOrderDO> queryPutawayOrderPage(PutawayOrderQuery putawayOrderQuery);

	/**
	 * * 根据仓库id和装箱单id和状态status查找上架单
	 * 
	 * 
	 * @param ContainerOrderId
	 *            装箱单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PutawayOrderDO queryByContainerOrderId(Long ContainerOrderId, Long warehouseId);

	/**
	 * 根据仓库id和容器编码修改上架人id
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param putawayerId
	 *            上架人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateByContainerCodeAndPutawayerId(Long putawayOrderId, Long putawayerId, Long warehouseId);

	/**
	 * 查询status为1的上架单
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<PutawayOrderDO> queryPutawayOrderByStatusIsOne(Long warehouseId);

	/**
	 * 根据仓库id和容器编号和状态查找上架单
	 * 
	 * @param containerCode
	 *            容器code
	 * @param status
	 *            状态
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PutawayOrderDO queryByContainerCode(String containerCode, int status, Long warehouseId);

	/**
	 * 根据上架单id和商品code统计明细中已上架商品数量总和
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param itemCode
	 *            商品code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public double queryCountByPutawayOrderIdAndItemCode(Long putawayOrderId, String itemCode, Long warehouseId);

	/**
	 * 根据上架单id查询上架单
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PutawayOrderDO queryPutawayOrderById(long putawayOrderId, Long warehouseId);

	/**
	 * 根据上架单id查询上架单明细列表
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<PutawayOrderDetailDO> queryPutawayOrderDetailByPutawayOrderId(long putawayOrderId, Long warehouseId);

	/**
	 * 根据上架单id更改上架单状态
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param status
	 *            状态
	 * @param warehouseId
	 *            仓库Id
	 * @return
	 */
	public boolean updatePutawayOrderStatusById(long putawayOrderId, int status, Long warehouseId);

	/**
	 * 创建上架单
	 */
	public long insertPutawayOrder(PutawayOrderDO putawayOrderDO);

	/**
	 * 创建上架单（通知单id和容器code 是否rf上架,上架人id）
	 * 
	 * @param sourceType
	 *            来源类型
	 * @param orderId
	 *            通知单id
	 * @param containerCode
	 *            容器code
	 * @param isRf
	 *            是否rf上架
	 * @param putawayerId
	 *            上架人id
	 * @param type
	 *            上架类型
	 * @param warehouseId
	 *            仓库Id
	 * @return
	 * @deprecated
	 */
	public long insertPutawayOrderByArguments(int sourceType, long orderId, String containerCode, int isRf, Long putawayerId, int type, Long warehouseId);

	/**
	 * 分页查询上架单详情
	 * 
	 * @param putawayOrderDetailQuery
	 *            上架单Query
	 * @return
	 */
	public PageResult<PutawayOrderDetailDO> queryPutawayOrderDetailPage(PutawayOrderDetailQuery putawayOrderDetailQuery);

	/**
	 * 根据通知单id，容器code查询上架单
	 * 
	 * @param orderId
	 *            上架单id
	 * @param containerCode
	 *            容器code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public PutawayOrderDO queryByOrderIdAndContainerCode(long orderId, String containerCode, long warehouseId);

	/**
	 * 根据商品Id,上架单状态,仓库分表code查询上架单list
	 * 
	 * @param itemId
	 *            商品id
	 * @param status
	 *            上架单状态
	 * @param warehouseId
	 *            仓库Id
	 * @return
	 */
	public List<PutawayOrderDO> queryByItemIdAndStatus(long itemId, int status, long warehouseId);
}
