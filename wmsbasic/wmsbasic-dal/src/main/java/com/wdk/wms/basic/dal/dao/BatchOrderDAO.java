package com.wdk.wms.basic.dal.dao;


import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.query.parameters.BatchOrderQuery;

/****
 * 
 * @author wb-cengxi
 * 创建人：曾曦
 * 创建时间：2015.9.28
 * 修改时间：2015.9.28
 * 
 */
@Dao("batch_order")
public interface BatchOrderDAO {
	
	//增加
	@Insert
	public long  insertBasicOrder(BatchOrderDO orderBatchDO);
	
	//修改
	@Update
	public int updateBasicOrder(BatchOrderDO orderBatchDO);
	
	//查找
	@Select
	public List<BatchOrderDO> queryBasicOrder(BatchOrderQuery orderBatchQuery);
	
	//分页(查询总行数)
	@Select
	public int queryArrivalNoticeCount(BatchOrderQuery orderBatchQuery);

	/**
	 * 通过外部批次code 查询
	 * 
	 * @param externalBatchCode
	 *            外部批次code
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Select
	public BatchOrderDO queryBatchOrderByBatchCodeAndWhId(@Param("externalBatchCode") Long externalBatchCode, @Param("warehouseId") long warehouseId,
			@Param("warehouseCode") long warehouseCode);

	/**
	 * 通过波次id 查询批次
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public BatchOrderDO queryByWaveId(@Param("waveId") Long waveId, @Param("warehouseId") Long warehouseId, @Param("warehouseCode") Long warehouseCode);

	
}
