package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.query.parameters.BatchOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/****
 * 
 * @author wb-cengxi 
 * 创建人：曾曦 
 * 创建时间：2015.9.28 
 * 修改时间：2015.9.28
 * 
 */
public interface BatchOrderClientAPI {

	// 增加
	public long insertBatchOrder(BatchOrderDO OrderBatchDO);

	// 修改
	public int updateBatchOrder(BatchOrderDO OrderBatchDO);

	//查找
	public List<BatchOrderDO> queryListBatchOrder(BatchOrderQuery batchQuery);
	
	
	// 查询分页
	public PageResult<BatchOrderDO> queryPageBatchOrder(BatchOrderQuery batchQuery);

	/**
	 * 通过外部批次code 查询
	 * 
	 * @param externalBatchCode
	 *            外部批次code
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public BatchOrderDO queryBatchOrderByBatchCodeAndWhId(Long externalBatchCode, long warehouseId);

	/**
	 * 通过波次id查询
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public BatchOrderDO queryByWaveId(Long waveId, Long warehouseId);
	
	

}
