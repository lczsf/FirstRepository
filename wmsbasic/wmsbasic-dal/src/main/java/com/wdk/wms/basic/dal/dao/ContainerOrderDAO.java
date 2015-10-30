package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.ContainerOrderDO;
import com.wdk.wms.basic.query.parameters.ContainerOrderQuery;

@Dao("container_order")
public interface ContainerOrderDAO {

	/**
	 * 插入装箱单主记录
	 */
	@Insert
	public long insertContainerOrder(ContainerOrderDO containerOrderDO);

	/**
	 * 查询装箱单记录
	 */
	@Select
	public List<ContainerOrderDO> queryContainerOrder(ContainerOrderQuery containerOrderQuery);

	/**
	 * 查询总记录
	 * 
	 * @param orderQuery
	 * @return
	 */
	@Select
	Integer queryContainerCount(ContainerOrderQuery orderQuery);

	/**
	 * 通过仓库id和容器编号查询
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param containerCode
	 *            容器code
	 * @param status
	 *            状态
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	ContainerOrderDO queryByWarehouseIdAndCode(@Param("containerCode") String containerCode, @Param("status") int status,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	ContainerOrderDO queryById(@Param("id") Long id, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 查询 状态为 创建 1
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param containerCode
	 *            容器编码
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	ContainerOrderDO queryByAsnIdAndCode(@Param("asnId") Long asnId, @Param("containerCode") String containerCode, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 查询 状态为 非完成 != 3
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param containerCode
	 *            容器编码
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	ContainerOrderDO queryByAsnIdAndCodeNotComplete(@Param("asnId") Long asnId, @Param("containerCode") String containerCode,
			@Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);
	/**
	 * 通过id更新状态
	 * 
	 * @param id
	 *            id
	 * @param status
	 *            状态 * @see com.wdk.wms.basic.enums.ContainerOrderStatusEnum
	 * @param operationId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Update
	int updateOrderStatus(@Param("id") Long id, @Param("status") int status, @Param("operationId") Long operationId, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 更新状态为暂存 并关联默认仓库
	 * 
	 * @param asnId
	 *            通知单id
	 * @param containerCode
	 *            容器编码
	 * @param cabinetId
	 *            库位id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Update
	int updateStatusAndAssociatCabinet(@Param("asnId") Long asnId, @Param("containerCode") String containerCode, @Param("cabinetId") Long cabinetId,
			@Param("operationId") Long operationId, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过通知单id查询
	 * 
	 * @param asnId
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	List<ContainerOrderDO> queryByAsnId(@Param("asnId") Long asnId, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过id更新操作人
	 * 
	 * @param id
	 *            主键id
	 * @param operationId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Update
	int updateOperatorId(@Param("id") Long id, @Param("operationId") Long operationId, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);
}
