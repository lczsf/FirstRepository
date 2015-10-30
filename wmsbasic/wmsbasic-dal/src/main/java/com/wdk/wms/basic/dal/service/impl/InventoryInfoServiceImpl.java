package com.wdk.wms.basic.dal.service.impl;

import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.InventoryLogDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.service.InventoryInfoService;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.basic.daoobject.InventoryLogDO;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * Description: 库存服务
 *
 * @author 刘勇
 * @Date 15/10/29
 */
@Service
public class InventoryInfoServiceImpl implements InventoryInfoService {

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private InventoryInfoDAO inventoryInfoDAO;

	@Autowired
	private CommonService commonService;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private InventoryLogDAO inventoryLogDAO;


	@Override
	public int updateDeduction(final long id, final long warehouseId, final double orderOccupy, final double deduction, final long itemId, final int docType,
			final long docId) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				InventoryInfoDO inventoryInfoDO = getInventoryInfoDO(id, warehouseId, itemId); // 查询库存
				int update = updateInventoryInfo(id, warehouseId, orderOccupy, deduction, itemId); // 更新库存
				Long insert = insertInventoryLog(inventoryInfoDO, deduction, docType, docId); // 插入库存log
				if (update == 1 && !insert.equals(0l)) { // 更新和插入都成功
					return 1;
				} else {
					status.setRollbackOnly();
					return 0;
				}
			}
		});
	}

	/**
	 * 获取库存
	 * 
	 * @param id
	 *            库存id
	 * @param warehouseId
	 *            仓库id
	 * @param itemId
	 *            商品id
	 * @return
	 */
	private InventoryInfoDO getInventoryInfoDO(long id, long warehouseId, long itemId) {
		InventoryInfoQuery inventoryInfoQuery = new InventoryInfoQuery(); // 库存查询条件
		inventoryInfoQuery.setId(id); // 库存id
		inventoryInfoQuery.setWarehouseId(warehouseId); // 库存id
		inventoryInfoQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(warehouseId)); // 分表code
		inventoryInfoQuery.setItemId(itemId);
		return inventoryInfoDAO.querySingleInventory(inventoryInfoQuery);
	}

	/**
	 * 更新库存
	 * 
	 * @param id
	 *            库存id
	 * @param warehouseId
	 *            仓库id
	 * @param orderOccupy
	 *            占用数
	 * @param deduction
	 *            扣减书
	 * @param itemId
	 *            商品id
	 * @return
	 */
	private int updateInventoryInfo(long id, long warehouseId, double orderOccupy, double deduction, long itemId) {
		InventoryInfoDO inventoryInfoDO = new InventoryInfoDO();
		inventoryInfoDO.setId(id); // id
		inventoryInfoDO.setWarehouseId(warehouseId); // 仓库id
		inventoryInfoDO.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(warehouseId)); // 分表code
		orderOccupy = commonService.quanityTransform(itemId, orderOccupy, warehouseId, true); // 转换库存数量
		deduction = commonService.quanityTransform(itemId, deduction, warehouseId, true); // 转换库存数量
		long newDeduction = BigDecimal.valueOf(deduction).negate().longValue(); // 取反扣减数
		long newOrderOccupy = BigDecimal.valueOf(orderOccupy).negate().longValue(); // 取反占用数
		inventoryInfoDO.setRealInvent(newDeduction); // 实物库存
		long availableInvent = BigDecimal.valueOf(orderOccupy).subtract(BigDecimal.valueOf(deduction)).longValue(); // 计算可用库存
		inventoryInfoDO.setAvailableInvent(availableInvent); // 可用库存
		inventoryInfoDO.setOrderOccupy(newOrderOccupy); // 占用数量
		return inventoryInfoDAO.updateInventoryInfo(inventoryInfoDO);

	}

	/**
	 * 插入库存变化log
	 * 
	 * @param inventoryInfoDO
	 *            库存
	 * @param quantity
	 *            改变数量
	 * @param docType
	 *            来源单据leix
	 * @param docId
	 *            来源单据id
	 * @return
	 */
	private Long insertInventoryLog(InventoryInfoDO inventoryInfoDO, double quantity, int docType, long docId) {
		InventoryLogDO inventoryLogDO = new InventoryLogDO();
		inventoryLogDO.setInventoryId(inventoryInfoDO.getId()); // 库存id
		inventoryLogDO.setWarehouseCode(inventoryInfoDO.getWarehouseCode()); // 分表code
		inventoryLogDO.setRealInvent(inventoryInfoDO.getRealInvent()); // 实物库存
		inventoryLogDO.setAvailableInvent(inventoryInfoDO.getAvailableInvent()); // 可用库存
		inventoryLogDO.setInventoryOccupy(inventoryInfoDO.getOrderOccupy()); // 占用库存
		quantity = commonService.quanityTransform(inventoryInfoDO.getItemId(), quantity, inventoryInfoDO.getWarehouseId(), true);// 转换库存数量
		BigDecimal negate = BigDecimal.valueOf(quantity).negate();
		inventoryLogDO.setChangeAccount(Double.valueOf(quantity).longValue()); // 改变数量
		long realInventUpdated = BigDecimal.valueOf(inventoryInfoDO.getRealInvent()).add(negate).longValue(); // 变更后实物库存
		inventoryLogDO.setRealInventUpdated(realInventUpdated);
		long availableInventUpdated = BigDecimal.valueOf(inventoryInfoDO.getAvailableInvent()).add(negate).longValue(); // 变更后可用库存
		inventoryLogDO.setAvailableInventUpdated(availableInventUpdated);
		inventoryLogDO.setDocType(docType); // 来源单据类型
		inventoryLogDO.setDocId(docId); // 来源单据id
		inventoryLogDO.setItemId(inventoryInfoDO.getItemId()); // 商品id
		try {
			return inventoryLogDAO.insertInventoryLog(inventoryLogDO);
		} catch (Exception e) { // 插入异常
			return 0l;
		}

	}

}
