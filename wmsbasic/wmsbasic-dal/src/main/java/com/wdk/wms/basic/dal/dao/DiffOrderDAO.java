package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.query.parameters.DiffOrderQuery;

@Dao("diff_order")
public interface DiffOrderDAO {

	/**
	 * 查询差异单
	 * 
	 * @param
	 * @return
	 */

	@Select
	public List<DiffOrderDO> queryDiffOrder(DiffOrderQuery diffOrderQuery);

	/**
	 * 插入差异单数据
	 * 
	 * @param diffOrderDO
	 *            差异单DO
	 * @return
	 */
	@Insert
	public long insertDiffOrder(DiffOrderDO diffOrderDO);

	/**
	 * 查询差异单总数
	 * 
	 * @param diffOrderQuery
	 * @return
	 */
	@Select
	public Integer queryDiffOrderCount(DiffOrderQuery diffOrderQuery);

	/**
	 * 查询差异单
	 * 
	 * @param diffOrderId
	 * @param warehouseId
	 * @param warehouseCode
	 * @return
	 */
	@Select
	public DiffOrderDO queryDiffOrderById(@Param("diffOrderId")long diffOrderId,@Param("warehouseId") long warehouseId,@Param("warehouseCode") long warehouseCode);

	@Update
	public int updateStatus(@Param("diffOrderId") long diffOrderId, @Param("status") long status, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);
}
