package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.ContainerOrderDetailDO;

@Dao("container_order_detail")
public interface ContainerOrderDetailDAO {

	/**
	 * 插入装箱单详情记录
	 */
	@Insert
	public long insertContainerOrderDetail(ContainerOrderDetailDO containerOrderDetailDO);

	/**
	 * 根据主装箱单id查询装箱单详情记录
	 */
	@Select
	public List<ContainerOrderDetailDO> queryContainerOrderDetail(@Param("containerOrderId") long containerOrderId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 装箱单id和商品code查询
	 * 
	 * @param containerOrderId
	 *            装箱单id
	 * @param itemCode
	 *            商品code
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public ContainerOrderDetailDO queryByOrderIdAndItemCode(@Param("containerOrderId") Long containerOrderId, @Param("itemCode") String itemCode,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param containerOrderId
	 *            主表id
	 * @return
	 */
	@Select
	public ContainerOrderDetailDO queryById(@Param("id") Long id, @Param("containerOrderId") long containerOrderId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 统计批次
	 * 
	 * @param containerOrderId
	 *            装箱单id
	 * @param itemCode
	 *            商品code
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public ContainerOrderDetailDO queryCountBatch(@Param("containerOrderId") Long containerOrderId, @Param("itemCode") String itemCode,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过装箱单id 和 商品id 获取装箱单明细
	 * 
	 * @param containerOrderId
	 *            装箱单id
	 * @param itemId
	 *            商品id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public ContainerOrderDetailDO queryByOrderIdAndItemId(@Param("containerOrderId") Long containerOrderId, @Param("itemId") Long itemId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过id删除
	 * 
	 * @param id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param containerOrderId
	 *            主表code
	 * @return
	 */
	@Delete
	public int deleteById(@Param("id") Long id, @Param("containerOrderId") long containerOrderId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 更新
	 * 
	 * @param containerOrderDetailDO
	 * @return
	 */
	@Update
	public int updateOrderDetail(ContainerOrderDetailDO containerOrderDetailDO);
}
