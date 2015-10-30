package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.PutawayOrderDO;
import com.wdk.wms.basic.query.parameters.PutawayOrderQuery;

@Dao("putaway_order")
public interface PutawayOrderDAO {

	/**
	 * 插入上架单主记录
	 */
	@Insert
	public long insertPutawayOrder(PutawayOrderDO putawayOrderDO);

	/**
	 * 查询上架单记录
	 */
	@Select
	public List<PutawayOrderDO> queryPutawayOrder(PutawayOrderQuery putawayOrderQuery);

	/**
	 * 根据仓库id,容器编码,状态查询上架单
	 */
	@Select
	public PutawayOrderDO queryByContainerCode(@Param("containerCode") String containerCode, @Param("status") int status,
			@Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 根据上架单id，操作人id修改上架单
	 */
	@Update
	public int updateByContainerCodeAndPutawayerId(@Param("putawayOrderId") long putawayOrderId, @Param("putawayerId") long putawayerId,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 查询status为1的上架单
	 * 
	 * @return
	 */
	@Select
	public List<PutawayOrderDO> queryPutawayOrderByStatusIsOne(@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 根据仓库id,装箱单id查询上架单
	 */
	@Select
	public PutawayOrderDO queryByContainerOrderId(@Param("containerOrderId") Long containerOrderId, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 根据上架单id查询上架单
	 */
	@Select
	public PutawayOrderDO queryPutawayOrderById(@Param("putawayOrderId") long putawayOrderId, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 查询上架单总数
	 */
	@Select
	public int queryPutawayOrderCount(PutawayOrderQuery putawayOrderQuery);

	/**
	 * 根据上架单id更改状态
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param status
	 *            状态
	 * @return
	 */
	@Update
	public int updatePutawayOrderStatusById(@Param("putawayOrderId") long putawayOrderId, @Param("status") int status, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	@Select
	public PutawayOrderDO queryByOrderIdAndContainerCode(@Param("orderId") long orderId, @Param("containerCode") String containerCode,
			@Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode, @Param("status") int status);

	@Select
	List<PutawayOrderDO> queryByItemIdAndStatus(@Param("itemId") long itemId, @Param("status") int status, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

}
