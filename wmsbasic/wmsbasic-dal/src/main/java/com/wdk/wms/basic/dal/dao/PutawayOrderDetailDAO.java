package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.PutawayOrderDetailDO;
import com.wdk.wms.basic.query.parameters.PutawayOrderDetailQuery;

@Dao("putaway_order_detail")
public interface PutawayOrderDetailDAO {

	/**
	 * 插入上架单详情记录
	 */
	@Insert
	public long insertPutawayOrderDetail(PutawayOrderDetailDO putawayOrderDetailDO);

	/**
	 * 查询上架单详情记录
	 */
	@Select
	public List<PutawayOrderDetailDO> queryPutawayOrderDetail(PutawayOrderDetailQuery putawayOrderDetailQuery);

	/**
	 * 根据上架单id和商品code查询上架单明细
	 */
	@Select
	public List<PutawayOrderDetailDO> queryByPutawayOrderIdAndItemCode(@Param("putawayOrderId") Long putawayOrderId, @Param("itemCode") String itemCode,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 根据上架单id查询上架单明细
	 */
	@Select
	public List<PutawayOrderDetailDO> queryPutawayOrderDetailByPutawayOrderId(@Param("putawayOrderId") long putawayOrderId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 查询上架单明细总数
	 */
	@Select
	public int queryPutawayOrderDetailCount(PutawayOrderDetailQuery putawayOrderDetailQuery);

	/**
	 * 根据上架单id和商品code,最终上架库位id查询上架单明细
	 * 
	 * @param putawayOrderId
	 *            上架单id
	 * @param itemCode
	 *            商品code
	 * @param cabinetId
	 *            最终库位id
	 * @return
	 */
	@Select
	public PutawayOrderDetailDO queryByPutawayOrderIdAndItemCodeAndCabinetId(
			@Param("putawayOrderId") Long putawayOrderId, @Param("itemCode") String itemCode,
			@Param("cabinetId") Long cabinetId, @Param("warehouseCode") Long warehouseCode);

	/**
	 * 根据上架单明细id更改实际上架件数
	 * 
	 * @param ActualPackageQuantity
	 *            实际上架件数
	 * @param id
	 *            上架单明细id
	 * @param putawayOrderId
	 *            上架单id
	 * @return
	 */
	@Update
	public int updateActualPackageQuantityById(@Param("actualPackageQuantity") Double ActualPackageQuantity, @Param("id") Long id,
			@Param("putawayOrderId") Long putawayOrderId, @Param("warehouseCode") Long warehouseCode);

}
