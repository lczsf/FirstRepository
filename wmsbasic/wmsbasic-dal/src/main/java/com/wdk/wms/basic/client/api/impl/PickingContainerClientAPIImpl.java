package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.PickingContainerClientAPI;
import com.wdk.wms.basic.dal.dao.PickingContainerDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDetailDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.daoobject.PickingContainerDetailDO;

/**
 * Description: 拣货装箱单接口
 *
 * @author 刘勇
 * @Date 15/10/16
 */
public class PickingContainerClientAPIImpl implements PickingContainerClientAPI {

	@Autowired
	private PickingContainerDAO pickingContainerDAO;

	@Autowired
	private PickingContainerDetailDAO pickingContainerDetailDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public int updateStatusAndCabinet(Long id, int status, Long cabinetId, Long warehouseId) {
		return pickingContainerDAO.updateStatusAndCabinet(id, status, cabinetId, warehouseId,
				warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public PickingContainerDO queryByContainerCodeAndPicOrderId(String containerCode, Long pickingOrderId, Long warehouseId) {
		return pickingContainerDAO.queryByContainerCodeAndPicOrderId(containerCode, pickingOrderId, warehouseId,
				warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public List<PickingContainerDO> queryByWaveIdAndContainerCode(Long waveId, String containerCode, Long warehouseId, Integer status) {
		return pickingContainerDAO.queryByWaveIdAndContainerCode(waveId, containerCode, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId), status);
	}


	@Override
	public PickingContainerDetailDO queryByPickingOrderDetailId(Long pickingOrderDetailId, Long waveId, Long warehouseId) {
		return pickingContainerDetailDAO.queryByPickingContainerIdAndItemId(null, pickingOrderDetailId, null,
				warehouseDAO.queryWarehouseCodeById(warehouseId), waveId);
	}
	
	public boolean updatePickingContainerStatus(int status, long waveId, long warehouseId,long operatorId){
		
		if (pickingContainerDAO.updatePickingContainerStatus(status, waveId, warehouseId,warehouseDAO.queryWarehouseCodeById(warehouseId),operatorId) !=0)
	    	return true;	
	    return false;
	}

	@Override
	public List<PickingContainerDetailDO> queryByPickingContainerIds(Long waveId, Long warehouseId, List<Long> pickingContainerIds) {
		return pickingContainerDetailDAO.queryByPickingContainerIds(waveId, warehouseDAO.queryWarehouseCodeById(warehouseId), pickingContainerIds);
	}
}
