package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.ArrivalDetailDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDetailDO;

@Dao("arrival_notice_detail")
public interface ArrivalNoticeDetailDAO {

	/**
	 * 插入到货通知单详情记录
	 */
	@Insert
	public long insertArrivalNoticeDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO);

	/**
	 * 根据主到货通知单id查询到货通知单详情记录
	 */
	@Select
	public List<ArrivalNoticeDetailDO> queryArrivalNoticeDetail(@Param("asnId") long asnId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过到货通知单id和商品code查询
	 * 
	 * @param asnId
	 *            到货通知单
	 * @param itemCode
	 *            商品code
	 * @param warehouseCode
	 *            仓库code
	 * @return
	 */
	@Select
	public ArrivalNoticeDetailDO queryByIdAndItemCode(@Param("asnId") Long asnId, @Param("itemCode") String itemCode,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 获取数据 版本号
	 * 
	 * @param asnId
	 *            到货通知单id
	 * @param itemCode
	 *            商品编码
	 * @param warehouseCode
	 *            仓库code
	 * @return
	 */
	@Select
	public int queryVersion(@Param("asnId") Long asnId, @Param("itemCode") String itemCode, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 更新到货通知单实收数量
	 * 
	 * @param asnId
	 *            收货单id
	 * @param itemCode
	 *            商品编码
	 * @param version
	 *            版本
	 * @param actualPackageQuantity
	 *            实收件数
	 * @param warehouseCode
	 *            仓库code
	 * @return
	 */
	@Update
	public int updateActualQuantity(@Param("asnId") Long asnId, @Param("itemCode") String itemCode,
 @Param("version") int version,
			@Param("actualPackageQuantity") Double actualPackageQuantity, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过通知单id 查询待收明细
	 * 
	 * @param asnId
	 *            通知单id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public List<ArrivalNoticeDetailDO> queryArrivalIncomeDetail(@Param("asnId") Long asnId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过通知单id 查询已收明细
	 * 
	 * @param asnId
	 *            通知单id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public List<ArrivalDetailDO> queryArrivalReceivedDetail(@Param("asnId") Long asnId, @Param("warehouseCode") Long warehouseCode);

	@Update
	public int updateArrivalNoticeDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO);

	/**
	 * 批量插入 通知单明细
	 * 
	 * @param list
	 */
	@Insert
	public void insertListData(@Param("list") List<ArrivalNoticeDetailDO> list);
}
