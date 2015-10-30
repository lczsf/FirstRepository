package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.ArtificialTaskDO;
import com.wdk.wms.basic.query.parameters.ArtificialTaskQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * 人工任务表
 * 
 * @author wb-lichao.x
 *
 */
public interface ArtificialTaskClientAPI {

	/**
	 * 插入数据
	 * 
	 * @param artificialTaskDO
	 * @return
	 */
	long insertArtificialTask(ArtificialTaskDO artificialTaskDO);


	public PageResult<ArtificialTaskDO> queryArtificialTaskPage(ArtificialTaskQuery artificialTaskQuery);

	public ArtificialTaskDO queryArtificialTaskById(Long id, Long warehouseId);

	/**
	 * 更新状态
	 * 
	 * @param id
	 * @param warehouseId
	 * @param status
	 * @return
	 */
	public int updateStatus(Long id, Long warehouseId, int status);
}
