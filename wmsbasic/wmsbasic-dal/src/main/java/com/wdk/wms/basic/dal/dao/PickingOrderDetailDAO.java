package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;
import com.wdk.wms.basic.query.parameters.PickingOrderDetailQuery;

@Dao("picking_order_detail")
public interface PickingOrderDetailDAO {

	@Select
	public List<PickingOrderDetailDO> queryPickingOrderDetail(PickingOrderDetailQuery pickingOrderDetailQuery);

	@Insert
	public long insertPickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO);

	@Update
	public int updatePickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO);

	@Select
	public int queryPickingOrderDetailCount(PickingOrderDetailQuery pickingOrderDetailQuery);

	@Select
	public List<PickingOrderDetailDO> queryByPickingOrderIdAndWarehouseCode(@Param("pickingOrderId") long pickingOrderId, @Param("waveId") long waveId,
			@Param("warehouseCode") long warehouseCode);

	@Select
	public PickingOrderDetailDO queryByPickingOrderDetailId(@Param("pickingOrderId") Long pickingOrderId, @Param("waveId") long waveId,
			@Param("pickingOrderDetailId") Long pickingOrderDetailId,
			@Param("warehouseCode") Long warehouseCode);

	@Select
	public List<PickingOrderDetailDO> sortPickingOrderDetailDOs(@Param("detailList") List<Long> detailList, @Param("pickingOrderId") long pickingOrderId,
			@Param("waveId") long waveId,
			@Param("warehouseCode") long warehouseCode);

	/**
	 * 更新拣货单详情表的数量接口，当数量传入值null时，不更新此字段。
	 * 
	 * @param pickingOrderId
	 * @param pickOrderDetailId
	 * @param waveId
	 * @param mainShouldNumeric
	 *            主计价应拣数量
	 * @param pickingShouldNumeric
	 *            拣货单位应拣数量
	 * @param mainAddNumeric
	 *            主计价已拣增加数量
	 * @param pickingAddNumeric
	 *            拣货单位已拣增加数量
	 * @param wid
	 * @param warehouseCode
	 * @return
	 */
	@Update
	public int updateQuanityByArguments(@Param("pickingOrderId") long pickingOrderId, @Param("pickOrderDetailId") long pickOrderDetailId,
			@Param("waveId") long waveId,
			@Param("mainShouldNumeric") Double mainShouldNumeric, @Param("pickingShouldNumeric") Double pickingShouldNumeric,
			@Param("mainAddNumeric") Double mainAddNumeric, @Param("pickingAddNumeric") Double pickingAddNumeric,
			@Param("warehouseCode") long warehouseCode);

	/**
	 * 查询拣货单详情
	 * 
	 * @param pickingOrderId
	 *            拣货单id
	 * @param waveId
	 *            波次ID
	 * @param itemId
	 *            商品id
	 * @param cabinetId
	 *            库位id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public PickingOrderDetailDO queryByPickingOrderIdAndItemAndCabinet(@Param("pickingOrderId") long pickingOrderId, @Param("waveId") long waveId,
			@Param("itemId") long itemId, @Param("cabinetId") long cabinetId, @Param("warehouseCode") long warehouseCode);

	/**
	 * 
	 * @param pickingOrderId
	 *            拣货单id
	 * @param waveId
	 *            波次ID
	 * @param salesOrderDetailId
	 *            销售订单详情id
	 * @param cabinetId
	 *            库位id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public PickingOrderDetailDO queryBySalesOrderDetailIdAndCabinet(@Param("pickingOrderId") long pickingOrderId, @Param("waveId") long waveId,
			@Param("salesOrderDetailId") long salesOrderDetailId, @Param("cabinetId") long cabinetId, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	@Select
	public List<PickingOrderDetailDO> queryByPickingOrderId(@Param("pickingOrderId") long pickingOrderId, @Param("waveId") long waveId,
			@Param("warehouseCode") long warehouseCode);

	@Update
	public int updateSalesOrderDeailId(@Param("salesOrderDetailId") long salesOrderDetailId, @Param("waveId") long waveId,
			@Param("pickingOrderDetailId") long pickingOrderDetailId,
			@Param("pickingOrderId") long pickingOrderId, @Param("warehouseCode") long warehouseCode);
	
	@Update
	public int updateStatus(@Param("pickingOrderDetailId") long pickingOrderDetailId, @Param("pickingOrderId") long pickingOrderId,
			@Param("waveId") long waveId,
			@Param("status") int status,
			@Param("warehouseCode") long warehouseCode);

}
