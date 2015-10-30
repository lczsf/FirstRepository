package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.WcsPickingCompleteDO;
import com.wdk.wms.basic.daoobject.WcsWaveCompleteDO;

public interface WcsClientAPI {

	void doSendPickingCompleteCommand();

	void doSendWaveCompleteCommand();

	List<WcsWaveCompleteDO> queryUnsentWaveCompleteRecord();

	List<WcsPickingCompleteDO> queryUnsentPickingCompleteRecord();
}
