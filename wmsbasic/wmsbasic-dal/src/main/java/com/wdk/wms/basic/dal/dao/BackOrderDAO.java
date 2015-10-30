package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.wdk.wms.basic.daoobject.BackOrderDO;
import com.wdk.wms.basic.query.parameters.BackOrderQuery;

@Dao("back_order")
public interface BackOrderDAO {

	@Select
	List<BackOrderDO> queryBackOrder(BackOrderQuery backOrderQuery);

	@Select
	int queryBackOrderCount(BackOrderQuery backOrderQuery);

	@Insert
	long insertBackOrder(BackOrderDO backOrderDO);

	@Select
	List<BackOrderDO> queryBackOrderByWaveId(@Param("waveId") long waveId, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	@Select
	List<BackOrderDO> queryByItemIdAndStatus(@Param("itemId") long itemId, @Param("status") int status, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);
}
