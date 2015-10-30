package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.query.parameters.BackContainerOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * 归位装箱单
 * 
 * @author 李超@
 */
public interface BackContainerOrderClientAPI {

	PageResult<BackContainerOrderDO> queryBackContainerOrderPage(BackContainerOrderQuery backContainerOrderQuery);

	long insertBackContainerOrder(BackContainerOrderDO backContainerOrderDO);

	long insertBackContainerOrderList(List<BackContainerOrderDO> backContainerOrderDOs);
	
	List<BackContainerOrderDO> queryBackContainerOrderByWaveId(Long waveId, Long warehouseId);

}
