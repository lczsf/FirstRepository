package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.query.parameters.ArrivalNoticeQuery;

@Dao("arrival_notice")
public interface ArrivalNoticeDAO {

	/**
	 * 插入到货通知单主记录
	 */
	@Insert
	public long insertArrivalNotice(ArrivalNoticeDO arrivalNoticeDO);

	/**
	 * 查询到货通知单记录
	 */
	@Select
	public List<ArrivalNoticeDO> queryArrivalNotice(ArrivalNoticeQuery arrivalNoticeQuery);

	/**
	 * 查询到货通知单记录数量，用于分页
	 */
	@Select
	public int queryArrivalNoticeCount(ArrivalNoticeQuery arrivalNoticeQuery);

	/**
	 * 通过code 查询
	 * 
	 * @param bizCode
	 *            业务编码
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Select
	public ArrivalNoticeDO queryArrivalNoticeByCode(@Param("bizCode") String bizCode, @Param("warehouseId") Long warehouseId);

	/**
	 * 通过通知单id获取
	 * 
	 * @param id
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 *
	 * @return
	 */
	@Select
	public ArrivalNoticeDO queryById(@Param("id") Long id, @Param("warehouseId") Long warehouseId);

	/**
	 * 通过id 更新状态
	 * 
	 * @param id
	 *            id
	 * @param status
	 *            状态
	 * @see com.wdk.wms.basic.enums.ArrivalNoticeStatusEnum
	 *
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Update
	public int updateStatusById(@Param("id") Long id, @Param("status") int status, @Param("operatorId") Long operatorId,
			@Param("warehouseId") Long warehouseId);

	/**
	 * 更新操作人
	 * 
	 * @param id
	 *            id
	 * @param operatorId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Update
	public int updateOperatorId(@Param("id") Long id, @Param("operatorId") Long operatorId, @Param("warehouseId") Long warehouseId);

	/**
	 * 通过id 和 仓库id 查询
	 * 
	 * @param id
	 *            id
	 * @param whId
	 *            仓库id
	 * @return
	 */
	@Select
	public ArrivalNoticeDO queryByIdAndWarehouseId(@Param("id") Long id, @Param("whId") Long whId);
}
