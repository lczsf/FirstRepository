package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.query.parameters.BackContainerOrderQuery;

@Dao("back_container_order")
public interface BackContainerOrderDAO {

	@Select
	List<BackContainerOrderDO> queryBackContainerOrder(BackContainerOrderQuery backContainerOrderQuery);

	@Select
	int queryBackContainerOrderCount(BackContainerOrderQuery backContainerOrderQuery);

	@Insert
	long insertBackContainerOrder(BackContainerOrderDO backContainerOrderDO);

	/**
	 * 根据波次id查询
	 * 
	 * @param waveId
	 * @param warehouseId
	 * @param warehouseCode
	 * @return
	 */
	@Select
	List<BackContainerOrderDO> queryByWaveId(@Param("waveId") long waveId,@Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);
	
	/**
	 * 更改状态
	 * 
	 * @param id
	 *            主键id
	 * @param waveId
	 *            波次id
	 * @param status
	 *            状态
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库code
	 * @return
	 */
	@Update
	int updateStatus(@Param("id") long id, @Param("waveId") long waveId, @Param("status") int status, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	@Insert
	long insertBackContainerOrderList(@Param("backContainerOrderDOs") List<BackContainerOrderDO> backContainerOrderDOs);

	@Select
	List<BackContainerOrderDO> queryBackContainerOrderByWaveId(@Param("waveId") long waveId, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);
}
