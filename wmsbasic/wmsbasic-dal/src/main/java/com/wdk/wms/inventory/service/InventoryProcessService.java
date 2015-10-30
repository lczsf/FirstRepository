package com.wdk.wms.inventory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.common.CommonUtils;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.InventoryLogDAO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.basic.daoobject.InventoryLogDO;
import com.wdk.wms.basic.result.InventoryProcessResult;
import com.wdk.wms.inventory.parameters.InventoryAdjustParameter;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;

public class InventoryProcessService {

	@Autowired
	private InventoryInfoDAO inventoryInfoDAO;
	@Autowired
	private InventoryLogDAO inventoryLogDAO;
	@Autowired
	private CommonService commonService;
	
	private final Logger log = LoggerFactory.getLogger(InventoryProcessService.class);
	/*
	 * 增加库存
	 */
	public InventoryProcessResult<Integer> addInventory(InventoryAdjustParameter inventoryAdjustParameter) throws Exception{
		InventoryProcessResult<Integer> inventoryProcessResult=new InventoryProcessResult<Integer>();
		InventoryInfoQuery inventoryInfoQuery=new InventoryInfoQuery();
		CommonUtils.doTrans(inventoryAdjustParameter, inventoryInfoQuery);
		InventoryInfoDO inventoryInfoDO=new InventoryInfoDO();
		CommonUtils.doTrans(inventoryAdjustParameter, inventoryInfoDO);
		double quantity = commonService.quanityTransform(inventoryAdjustParameter.getItemId(),
				inventoryAdjustParameter.getItemQuainty(), inventoryAdjustParameter.getWarehouseCode(), true);// 转换后的库存数量
		if (quantity != (int) quantity) // 库存数量为小数
		{
			inventoryProcessResult.setStatus(-1);// 库存为小数，抛出异常
			log.error("库存数量为小数,单据id为"+inventoryAdjustParameter.getSourceOrderId());
			return inventoryProcessResult;
		}
		InventoryLogDO inventoryLogDO=new InventoryLogDO();  //库存变换日志
		generateInventoryLogDO(inventoryAdjustParameter.getWarehouseCode(),inventoryAdjustParameter.getItemId(), inventoryAdjustParameter.getSourceOrderId(), inventoryAdjustParameter.getSourceOrderType());
		inventoryProcessResult=onshelfInventoryProcess(inventoryInfoQuery, inventoryInfoDO, quantity, inventoryLogDO);
		return inventoryProcessResult;
	}
	/*
	 * 较少库存
	 */
	public InventoryProcessResult<Integer> reduceInventory(InventoryAdjustParameter inventoryAdjustParameter) throws Exception{
		InventoryProcessResult<Integer> inventoryProcessResult=new InventoryProcessResult<Integer>();
		InventoryInfoQuery inventoryInfoQuery=new InventoryInfoQuery();
		CommonUtils.doTrans(inventoryAdjustParameter, inventoryInfoQuery);
		InventoryInfoDO inventoryInfoDO=new InventoryInfoDO();
		CommonUtils.doTrans(inventoryAdjustParameter, inventoryInfoDO);
		double quantity = commonService.quanityTransform(inventoryAdjustParameter.getItemId(),
				inventoryAdjustParameter.getItemQuainty(), inventoryAdjustParameter.getWarehouseCode(), true);// 转换后的库存数量
		if (quantity != (int) quantity) // 库存数量为小数
		{
			inventoryProcessResult.setStatus(-1);// 库存为小数，抛出异常
			log.error("库存数量为小数,单据id为"+inventoryAdjustParameter.getSourceOrderId());
			return inventoryProcessResult;
		}
		InventoryLogDO inventoryLogDO=new InventoryLogDO();  //库存变换日志
		generateInventoryLogDO(inventoryAdjustParameter.getWarehouseCode(),inventoryAdjustParameter.getItemId(), inventoryAdjustParameter.getSourceOrderId(), inventoryAdjustParameter.getSourceOrderType());
		inventoryProcessResult=downshelfInventoryProcess(inventoryInfoQuery, inventoryInfoDO, 0-quantity, inventoryLogDO);//扣减为负数
		return inventoryProcessResult;
	}
	
	/* 上架 库存操作方法,库存记录不用锁，增量更新 */
	public InventoryProcessResult<Integer> onshelfInventoryProcess(final InventoryInfoQuery inventoryInfoQuery,
			final InventoryInfoDO inventoryInfoDO, final double inventoryQuantity, final InventoryLogDO inventoryLogDO) {
		InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();
		inventoryProcessResult.setStatus(1);
		InventoryInfoDO queryInventoryInfo = inventoryInfoDAO.querySingleInventory(inventoryInfoQuery);// 从库存中查找是否有该库存记录
		if (queryInventoryInfo == null) // 如果不存在该库存记录,则插入
		{
			long inventoryId = inventoryInfoDAO.insertInventoryInfo(inventoryInfoDO); // 新增一条库存记录库存记录
			inventoryLogDO.setInventoryId(inventoryId);
			inventoryLogDO.setRealInvent(0L);
			inventoryLogDO.setAvailableInvent(0L);
			inventoryLogDO.setWarehouseCode(inventoryInfoQuery.getWarehouseCode());// 仓库分表code
			inventoryLogDO.setChangeAccount((long) inventoryQuantity);// 库存变化数量
			inventoryLogDO.setRealInventUpdated((long) inventoryQuantity);// 实物库存增加
			inventoryLogDO.setAvailableInventUpdated((long) inventoryQuantity);// 可以库存增加
			inventoryLogDAO.insertInventoryLog(inventoryLogDO);// 插入一条库存变换日志
		} else { // 如果存在，则更新，不用锁
			inventoryInfoDO.setId(queryInventoryInfo.getId()); // 设置id fixme 待测试
			inventoryLogDO.setRealInvent(queryInventoryInfo.getRealInvent());
			inventoryLogDO.setAvailableInvent(queryInventoryInfo.getAvailableInvent());
			inventoryLogDO.setChangeAccount((long) inventoryQuantity);
			inventoryLogDO.setInventoryId(queryInventoryInfo.getId());
			inventoryLogDO.setWarehouseCode(inventoryInfoQuery.getWarehouseCode());
			inventoryLogDO.setRealInventUpdated((long) inventoryQuantity + queryInventoryInfo.getRealInvent());
			inventoryLogDO
					.setAvailableInventUpdated((long) inventoryQuantity + queryInventoryInfo.getAvailableInvent());
			inventoryInfoDAO.updateInventoryInfo(inventoryInfoDO); // 增量更新
			inventoryLogDAO.insertInventoryLog(inventoryLogDO);// 插入一条库存变换日志
		}
		return inventoryProcessResult;
	}
	
	/* 从库位上拿库存下来方法（与上架相反）,库存记录不用锁，增量更新 */
	public InventoryProcessResult<Integer> downshelfInventoryProcess(final InventoryInfoQuery inventoryInfoQuery,
			final InventoryInfoDO inventoryInfoDO, final double inventoryQuantity, final InventoryLogDO inventoryLogDO) {
		InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();
		inventoryProcessResult.setStatus(1);
		InventoryInfoDO queryInventoryInfo = inventoryInfoDAO.querySingleInventory(inventoryInfoQuery);// 从库存中查找是否有该库存记录
		if (queryInventoryInfo == null) // 如果不存在该库存记录,则插入
		{
			inventoryProcessResult.setStatus(-3);//-3代表库存调整 扣减过程中不存在库存记录
			
		} else { // 如果存在，则更新，不用锁
			inventoryInfoDO.setId(queryInventoryInfo.getId()); // 设置id fixme 待测试
			inventoryLogDO.setRealInvent(queryInventoryInfo.getRealInvent());
			inventoryLogDO.setAvailableInvent(queryInventoryInfo.getAvailableInvent());
			inventoryLogDO.setChangeAccount(0-(long) inventoryQuantity);//变换数量为负数，代表减少
			inventoryLogDO.setInventoryId(queryInventoryInfo.getId());
			inventoryLogDO.setWarehouseCode(inventoryInfoQuery.getWarehouseCode());
			inventoryLogDO.setRealInventUpdated((long) inventoryQuantity + queryInventoryInfo.getRealInvent());
			inventoryLogDO
					.setAvailableInventUpdated((long) inventoryQuantity + queryInventoryInfo.getAvailableInvent());
			int updateLow=inventoryInfoDAO.updateInventoryInfo(inventoryInfoDO); // 增量更新
			if(updateLow==0){  //如果更新失败，代表库存数量不够
				inventoryProcessResult.setStatus(-4);
				return inventoryProcessResult;//直接返回不用插入库存变换日志
			}
			inventoryLogDAO.insertInventoryLog(inventoryLogDO);// 插入一条库存变换日志
		}
		return inventoryProcessResult;
	}
	/*
	 * 属性赋值 库存查询
	 */
	public InventoryInfoQuery generateInventoryInfoQuery(long warehouseId, long warehouseCode, long itemId,
			long ownerId, long itemBatchId) {
		InventoryInfoQuery inventoryInfoQuery = new InventoryInfoQuery();
		inventoryInfoQuery.setWarehouseId(warehouseId);
		inventoryInfoQuery.setWarehouseCode(warehouseCode);
		inventoryInfoQuery.setItemId(itemId);
		inventoryInfoQuery.setOwnerId(ownerId);
		inventoryInfoQuery.setItemBatchId(itemBatchId);
		return inventoryInfoQuery;
	}

	/*
	 * 属性赋值 库存记录
	 */
	public InventoryInfoDO generateInventoryInfoDO(long warehouseId, long warehouseCode, long itemId, long ownerId,
			long itemBatchId, long cabinetId) {
		InventoryInfoDO inventoryInfoDO = new InventoryInfoDO();
		inventoryInfoDO.setWarehouseId(warehouseId);
		inventoryInfoDO.setWarehouseCode(warehouseCode);
		inventoryInfoDO.setItemId(itemId);
		inventoryInfoDO.setOwnerId(ownerId);
		inventoryInfoDO.setItemBatchId(itemBatchId);
		inventoryInfoDO.setCabinetId(cabinetId);
		return inventoryInfoDO;
	}

	/*
	 * 属性赋值 库存日志
	 */
	public InventoryLogDO generateInventoryLogDO(long warehouseCode, long itemId, long docId, int docType) {
		InventoryLogDO inventoryLogDO = new InventoryLogDO();
		inventoryLogDO.setItemId(itemId);
		inventoryLogDO.setDocId(docId);//
		inventoryLogDO.setDocType(docType);//
		inventoryLogDO.setWarehouseCode(warehouseCode);
		return inventoryLogDO;
	}
	public void setInventoryInfoDAO(InventoryInfoDAO inventoryInfoDAO) {
		this.inventoryInfoDAO = inventoryInfoDAO;
	}
	public void setInventoryLogDAO(InventoryLogDAO inventoryLogDAO) {
		this.inventoryLogDAO = inventoryLogDAO;
	}

}
