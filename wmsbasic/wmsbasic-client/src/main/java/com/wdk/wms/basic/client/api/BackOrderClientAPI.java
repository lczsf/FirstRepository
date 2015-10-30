package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BackOrderDO;
import com.wdk.wms.basic.query.parameters.BackOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * 归位单
 * 
 * @author 李超@
 */
public interface BackOrderClientAPI {

	PageResult<BackOrderDO> queryBackOrderPage(BackOrderQuery backOrderQuery);

	long insertBackOrder(BackOrderDO backOrderDO);

	List<BackOrderDO> queryBackOrderByWaveId(Long waveId, Long warehouseId);
	
	List<BackOrderDO> queryByItemIdAndStatus(long itemId, int status, long warehouseId);

}
