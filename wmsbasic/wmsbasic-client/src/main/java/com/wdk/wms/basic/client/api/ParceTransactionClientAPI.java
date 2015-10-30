package com.wdk.wms.basic.client.api;

import java.util.List;

/**
 * 
 * @author 川丘
 * @date 2015年10月22日
 */
public interface ParceTransactionClientAPI {
	/**
	 * 打包完成后打印完的状态更新
	 * 
	 * @param waveId
	 *            波次id
	 * @param parcelNumber
	 *            包裹号
	 * @return
	 */
	public boolean afterParcelUpdate(Long waveId, String parcelNumber,long warehouseId);
	/**
	 * 扫描完成后校验做的更新
	 * 
	 * @param warehouseId
	 *            库存id
	 * @param waveId
	 *            波次id
	 * @param containerCodes容器code
	 *            list
	 * @param isUpdateWave
	 *            表示是否更新波次状态 true 更新 false 不更新
	 * @return
	 */
	public boolean afterScanContainerUpdate(Long warehouseId, Long waveId, List<String> containerCodes, long operatorId,boolean isUpdateWave);
}

