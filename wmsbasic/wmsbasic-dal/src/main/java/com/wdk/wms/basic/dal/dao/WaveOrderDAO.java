package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.query.parameters.WaveOrderQuery;

/****
 * 
 * @author wb-cengxi
 * 创建人：曾曦
 * 创建时间：2015.10.8
 * 修改时间：2015.10.8
 * 
 */
@Dao("wave_order")
public interface WaveOrderDAO {
	
	//增加
	@Insert
	public long  insertWaveOrder(WaveOrderDO waveOrderDO);

	/**
	 * 通过id 删除
	 * 
	 * @param id
	 *            id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Delete
	public int deleteWaveOrder(@Param("id") long id, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);
	
	//修改
	@Update
	public int updateWaveOrder(WaveOrderDO waveOrderDO);
	
	//查找
	@Select
	public List<WaveOrderDO> queryWaveOrder(WaveOrderQuery waveOrderQuery);
	
	//分页(查询总行数)
	@Select
	public int queryCountWaveOrder (WaveOrderQuery waveOrderQuery);

	/**
	 * 通过波次id 查询
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public WaveOrderDO queryWaveOrderById(@Param("waveId") long waveId, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	/**
	 * 通过id 更新状态
	 * 
	 * @param waveId
	 *            波次id
	 * @param waveStatus
	 *            状态
	 * @see com.wdk.wms.basic.enums.WaveOrderStatusEnum
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Update
	public int updateStatusById(@Param("waveId") long waveId, @Param("waveStatus") int waveStatus, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	/**
	 * 通过id 更新状态和波次说明类型
	 * 
	 * @param waveId
	 *            id
	 * @param waveStatus
	 *            状态
	 * @param waveDescriptionType
	 *            波次说明类型
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Update
	public int updateStatusAndStruction(@Param("waveId") long waveId, @Param("waveStatus") int waveStatus,
			@Param("waveDescriptionType") int waveDescriptionType, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	/**
	 * 更新消息状态 为1
	 * 
	 * @param waveId
	 *            仓库id
	 * @param notifyStatus
	 *            状态 1
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Update
	public int updateNotifyStatus(@Param("waveId") long waveId, @Param("notifyStatus") int notifyStatus, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);
}
