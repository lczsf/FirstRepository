package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.PickingOrderDO;
import com.wdk.wms.basic.query.parameters.PickingOrderQuery;

@Dao("picking_order")
public interface PickingOrderDAO {

	@Select
	public List<PickingOrderDO> queryPickingOrder(PickingOrderQuery pickingOrderQuery);

	@Insert
	public long insertPickingOrder(PickingOrderDO pickingOrderDO);

	@Update
	public int updatePickingOrder(PickingOrderDO pickingOrderDO);

	@Select
	public int queryPickingOrderCount(PickingOrderQuery pickingOrderQuery);

	@Select
	public PickingOrderDO queryByWarehouseCodeAndId(@Param("id") long id, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	@Select
	public PickingOrderDO queryPickingOrderByCode(@Param("code") String code, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	@Update
	public int updatePriorityPickingOrder(PickingOrderDO pickingOrderDO);

	@Select
	public PickingOrderDO queryPriorityPickingOrder(PickingOrderQuery pickingOrderQuery);

	@Select
	public List<Long> sortPickingOrderDOs(@Param("pickingOrderList") List<Long> pickingOrderList, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	// 通过波次id和拣货分区code查找拣货单
	@Select
	public PickingOrderDO queryByWaveIdAndAreaCode(@Param("waveId") long waveId, @Param("pickingAreaCode") String pickingAreaCode,
			@Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	@Select
	public List<PickingOrderDO> queryByWaveId(@Param("waveId") long waveId, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	@Update
	public int updatePickingOrderStatus(@Param("status") int status, @Param("pickingOrderId") long pickingOrderId, @Param("uid") long uid,
			@Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	@Update
	public int updateNotifyStatus(@Param("id") long id, @Param("notifyStatus") int notifyStatus, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);
}
