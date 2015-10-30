package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.ArrivalDetailDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDetailDO;
import com.wdk.wms.basic.query.parameters.ArrivalNoticeQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description: 到货通知单
 *
 * @author 刘勇
 * @Date 15/9/8
 */
public interface ArrivalNoticeClientAPI {

	/**
	 * 插入到货通知单主记录
	 */
	public long insertArrivalNotice(ArrivalNoticeDO arrivalNoticeDO);

	/**
	 * 查询到货通知单记录
	 */
	public PageResult<ArrivalNoticeDO> queryArrivalNotice(ArrivalNoticeQuery arrivalNoticeQuery);

	/**
	 * 插入到货通知单详情记录
	 */
	public long insertArrivalNoticeDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO);

	/**
	 * 根据主到货通知单id查询到货通知单详情记录
	 */
	public List<ArrivalNoticeDetailDO> queryArrivalNoticeDetail(long arrivalNoticeId, Long warehouseId);

	/**
	 * 查询到货通知单
	 * 
	 * @param bizCode
	 *            采购单号 或者 通知单单号
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ArrivalNoticeDO queryByCode(String bizCode, Long warehouseId);

	/**
	 * 通过到货通知单id和商品code获取
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param itemCode
	 *            商品code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ArrivalNoticeDetailDO queryByIdAndItemCode(Long asnId, String itemCode, Long warehouseId);

	/**
	 * 通过id获取通知单
	 * 
	 * @param id
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public ArrivalNoticeDO queryById(Long id, Long warehouseId);

	/**
	 * 通过id修改通知单状态
	 * 
	 * @param id
	 *            通知单id
	 * @param status
	 *            状态
	 * @see com.wdk.wms.basic.enums.ArrivalNoticeStatusEnum
	 * @param operatorId
	 *            操作人id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateArrivaNoticeStatus(Long id, int status, Long operatorId, Long warehouseId);

	/**
	 * 更新到货通知单明细 实收件数和实收数量
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param itemCode
	 *            商品编码
	 * @param packageQuantity
	 *            实收件数
	 * @param operatorId
	 *            操作人id
	 * @return true 更新成功 false 更新失败
	 */
	/* public Boolean updateActualQuantity(Long asnId, String itemCode, Double packageQuantity, Long operatorId); */

	/**
	 * 通过通知单id 获取待收明细
	 * 
	 * @param asnId
	 *            通知单id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<ArrivalNoticeDetailDO> queryArrivalIncomeDetail(Long asnId, Long warehouseId);

	/**
	 * 通过id和仓库id查询
	 * 
	 * @param id
	 *            id
	 * @param whId
	 *            仓库id
	 * @return
	 */
	public ArrivalNoticeDO queryByIdAndWarehouseId(Long id, Long whId);

	/**
	 * 批量插入 到货通知单明细
	 * 
	 * @param list
	 */
	public void insertListArrivalNoticeDetailDO(List<ArrivalNoticeDetailDO> list);

	/**
	 * 插入主子表数据
	 * 
	 * @param arrivalNoticeDO
	 *            到货通知单
	 * @param arrivalNoticeDetailDOList
	 *            到货通知单明细主表
	 * @return true 成功 false 失败
	 */
	public boolean insertArrivalNoticeAndArrivalNoticeDetail(ArrivalNoticeDO arrivalNoticeDO, List<ArrivalNoticeDetailDO> arrivalNoticeDetailDOList);

}
