package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.query.parameters.SalesOrderQuery;

@Dao("sales_order")
public interface SalesOrderDAO {

	@Select
	List<SalesOrderDO> querySalesOrder(SalesOrderQuery salesOrderQuery);

	@Insert
	long insertSalesOrder(SalesOrderDO salesOrderDO);

	@Update
	int updateSalesOrder(SalesOrderDO salesOrderDO);

	@Select
	int querySalesOrderCount(SalesOrderQuery salesOrderQuery);

	@Select
	SalesOrderDO querySalesOrderById(@Param("id") Long id, @Param("warehouseId") long warehouseId, @Param("warehouseCode") Long warehouseCode);

	@Select
	SalesOrderDO querySalesOrderByOutCode(@Param("externalSalesNumber") String externalSalesNumber, @Param("outBatchCode") Long outBatchCode,
			@Param("ownerId") long ownerId, @Param("warehouseId") long warehouseId, @Param("warehouseCode") long warehouseCode);

	/**
	 * 通过波次id查询
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Select
	List<SalesOrderDO> queryByWaveId(@Param("waveId") Long waveId, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	@Select
	public SalesOrderDO querySalesOrderByOutBatchCode(@Param("outBatchCode") Long outBatchCode, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);

	@Update
	int updateCompensationAmount(@Param("id") Long id, @Param("compensationAmount") Double compensationAmount, @Param("warehouseId") Long warehouseId,
			@Param("warehouseCode") Long warehouseCode);
}
