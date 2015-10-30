package com.wdk.wms.basic.client.api;

public interface OrderClientAPI {

	Integer doSubmitItem(boolean isRf, Long orderId, String containerCode, Long uid, Long wid, String itemCode, double numeric, int containerStatus,
			Long batchId);

	Integer doChangeContainer(String token, String containerCode, Long orderId, long uid, long wid);

}
