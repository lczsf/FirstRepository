package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.out.order.parameters.SaleOrderInfo;
import com.wdk.wms.basic.query.parameters.WaveOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/****
 * 
 * @author wb-cengxi 
 * 创建人：曾曦 
 * 创建时间：2015.10.8
 * 修改时间：2015.10.8
 * 
 * 
 */
public interface WaveOrderClientAPI {
	// 增加
	public long insertWaveOrder(WaveOrderDO waveOrderDO);

	/**
	 * 通过id删除
	 * 
	 * @param id
	 *            id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int deleteWaveOrder(long id, long warehouseId);

	// 修改
	public int updateWaveOrder(WaveOrderDO waveOrderDO);
	
	// 查找
	public List<WaveOrderDO> queryWaveOrder(WaveOrderQuery waveOrderQuery);

	// 分页(查询总行数)
	public PageResult<WaveOrderDO> deleteWaveOrder(WaveOrderQuery waveOrderQuery);



	/**
	 * 插入波次、批次 批次并绑定波次
	 * 
	 * @param waveOrderDO
	 * @param batchOrderDO
	 * @return -1 其他异常 0 违法波次唯一键约束！ -2 销售主订单违法唯一约束 -3 销售子订单插入异常 1 成功
	 */
	public int insertWaveBatchAndOrder(WaveOrderDO waveOrderDO, BatchOrderDO batchOrderDO, List<SaleOrderInfo> saleOrderInfos);
	
	/**
	 * 根据 波次ID 仓库ID 仓库分表code查询波次
	 * 
	 * @paam waveId 波次ID
	 * @param warehouseId
	 *            仓库ID
	 * @return
	 * 
	 */
	public WaveOrderDO queryWaveOrderById(long waveId, long warehouseId);

	/**
	 * 通过id更新状态
	 * 
	 * @param waveId
	 *            波次id
	 * @param waveStatus
	 *            状态
	 * @see com.wdk.wms.basic.enums.WaveOrderStatusEnum
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateStatus(long waveId, int waveStatus, long warehouseId);

	/**
	 * 通过id 更新状态 和 说明类型
	 * 
	 * @param waveId
	 *            id
	 * @param waveStatus
	 *            状态
	 * @param descriptionType
	 *            说明类型
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateStatusAndStruction(long waveId, int waveStatus, int descriptionType, long warehouseId);

	/**
	 * 更新消息状态 为1 已接收消息
	 * 
	 * @param waveId
	 *            id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateNotifyStatus(long waveId, long warehouseId);

}
