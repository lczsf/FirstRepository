package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;
import com.wdk.wms.basic.query.parameters.DiffOrderDetailQuery;

@Dao("diff_order_detail")
public interface DiffOrderDetailDAO {

	/**
	 * 插入差异单明细数据
	 * 
	 * @param diffOrderDetailDO
	 *            差异单明细DO
	 * @return
	 */
	@Insert
	public long insertDiffOrderDetail(DiffOrderDetailDO diffOrderDetailDO);

	/**
	 * 查询差异单详情
	 * 
	 * @param diffOrderDetailQuery
	 * @return
	 */
	@Select
	public List<DiffOrderDetailDO> queryDiffOrderDetail(DiffOrderDetailQuery diffOrderDetailQuery);

	@Select
	public int queryDiffOrderDetailCount(DiffOrderDetailQuery diffOrderDetailQuery);

	@Select
	public List<DiffOrderDetailDO> queryByDiffOrderId(@Param("diffOrderId") long diffOrderId, @Param("warehouseCode") long warehouseCode);
}
