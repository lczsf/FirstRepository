package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;

public interface PickClientAPI {

	Integer doSubmitItem(String containerCode, long uid, long wid, long pickOrderDetailId, double numeric, double pickNum, String pickOrderCode, long itemId,
			int pickOrderDetailStatus, long cabinetId, int isStandard);

	Integer doAssignPickResult(long waveId, long pickOrderId, List<PickingOrderDetailDO> detailList, long wid, Long uid);

	Integer doChangeContainer(String pickOrderCode, String containerCode, long pickContainerId, long wid, long uid, long waveId);
}
