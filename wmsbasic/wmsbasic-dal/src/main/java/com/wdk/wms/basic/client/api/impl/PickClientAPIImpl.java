package com.wdk.wms.basic.client.api.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.client.api.PickClientAPI;
import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.common.CommonUtils;
import com.wdk.wms.basic.common.Constants;
import com.wdk.wms.basic.dal.dao.ArtificialTaskDAO;
import com.wdk.wms.basic.dal.dao.BatchOrderDAO;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.InventoryBatchDAO;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.InventoryOccupancyDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDetailDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.SalesOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WaveOrderDAO;
import com.wdk.wms.basic.dal.dao.WcsPickingCompleteDAO;
import com.wdk.wms.basic.dal.dao.WcsWaveCompleteDAO;
import com.wdk.wms.basic.dal.service.InventoryInfoService;
import com.wdk.wms.basic.daoobject.ArtificialTaskDO;
import com.wdk.wms.basic.daoobject.BasicContainerDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.daoobject.InventoryBatchDO;
import com.wdk.wms.basic.daoobject.InventoryOccupancyDO;
import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.daoobject.PickingContainerDetailDO;
import com.wdk.wms.basic.daoobject.PickingOrderDO;
import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.daoobject.WcsPickingCompleteDO;
import com.wdk.wms.basic.daoobject.WcsWaveCompleteDO;
import com.wdk.wms.basic.enums.ArtificialTaskStatusEnum;
import com.wdk.wms.basic.enums.ArtificialTaskTypeEnum;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.enums.PickingContainerStatusEnum;
import com.wdk.wms.basic.enums.PickingOrderDetailStatusEnum;
import com.wdk.wms.basic.enums.PickingOrderStatusEnum;
import com.wdk.wms.basic.enums.ServiceTypeEnum;
import com.wdk.wms.basic.enums.SourceTypeEnum;
import com.wdk.wms.basic.enums.StorageTypeEnum;
import com.wdk.wms.basic.enums.WaveOrderStatusEnum;
import com.wdk.wms.basic.enums.WeightEnum;

public class PickClientAPIImpl implements PickClientAPI {

	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private PickingOrderDAO pickingOrderDAO;
	@Autowired
	private PickingOrderDetailDAO pickingOrderDetailDAO;
	@Autowired
	private PickingContainerDAO pickingContainerDAO;
	@Autowired
	private PickingContainerDetailDAO pickingContainerDetailDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private WaveOrderDAO waveOrderDAO;
	@Autowired
	private ContainerDAO containerDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private InventoryOccupancyDAO inventoryOccupancyDAO;
	@Autowired
	private InventoryInfoDAO inventoryInfoDAO;
	@Autowired
	private InventoryBatchDAO inventoryBatchDAO;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CabinetDAO cabinetDAO;
	@Autowired
	private SortingGoodsPartitionDAO sortingGoodsPartitionDAO;
	@Autowired
	private WcsPickingCompleteDAO wcsPickingCompleteDAO;
	@Autowired
	private WcsWaveCompleteDAO wcsWaveCompleteDAO;
	@Autowired
	private BatchOrderDAO batchOrderDAO;
	@Autowired
	private SalesOrderDetailDAO salesOrderDetailDAO;
	@Autowired
	private ArtificialTaskDAO artificialTaskDAO;
	@Autowired
	private InventoryInfoService inventoryInfoService;

	private int detailUndone = 0;
	private int detailDone = 1;
	private int pickCodeDone = 2;

	/**
	 * 1: 波次状态 -> 拣货中 2: 明细信息 -> 缺货/完成，数量 3: 拣货单状态 -> 完成 4：容器状态 -> 占用 5：拣货装箱单(状态) 6: 装箱单明细(数量) 7: 换箱 8: 波次完成 * 参数isStandard在非缺货完成有效
	 */
	@Override
	public Integer doSubmitItem(final String containerCode, final long uid, final long wid, final long pickOrderDetailId, final double numeric,
			final double pickNum, final String pickOrderCode, final long itemId, final int pickOrderDetailStatus, final long cabinetId, final int isStandard) {

		return (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {

					Long warehouseCode = warehouseDAO.queryWarehouseCodeById(wid);
					PickingOrderDO pickOrder = pickingOrderDAO.queryPickingOrderByCode(pickOrderCode, wid, warehouseCode);
					long waveId = pickOrder.getWaveId();
					long pickOrderId = pickOrder.getId();
					int status = detailUndone;// 明细未完成

					WaveOrderDO waveOrder = waveOrderDAO.queryWaveOrderById(waveId, wid, warehouseCode); // step 10
					if (waveOrder.getWaveStatus() == WaveOrderStatusEnum.CREATE.getIndex()) {
						waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.PICKING.getIndex(), wid, warehouseCode);
					}

					updatePickingOrderDetails(pickOrderId, pickOrderDetailId, waveId, wid, warehouseCode, numeric, pickNum, itemId, pickOrderDetailStatus); // step 11

					if (isDetailStatusOver(pickOrderDetailStatus)) { // step 12

						status = detailDone; // 明细完成
						if (isAllPickOrderDetailListDone(pickOrderId, waveId, warehouseCode)) {
							status = pickCodeDone; // 拣货单完成
							pickingOrderDAO.updatePickingOrderStatus(PickingOrderStatusEnum.FINISHED.getIndex(), pickOrderId, uid, wid, warehouseCode); // step 13
						}
					}

					BasicContainerDO container = containerDAO.queryContainerByCode(wid, containerCode);// step 14
					if (container.getStatus() == ContainerStatusEnum.Free.getIndex() && numeric > 0) {
						containerDAO.updateStatusByContainerCode(wid, containerCode, ContainerStatusEnum.Occupy.getIndex(), uid);
					}

					if (numeric > 0) { // 缺货完成

						PickingContainerDO pc = pickingContainerDAO.queryByContainerCodeAndPicOrderId(containerCode, pickOrderId, wid, warehouseCode);
						long pickContainerId = 0;
						if (pc == null) { // step 16
							pickContainerId = insertPickingContainer(containerCode, pickOrderId, uid, null, wid, warehouseCode, waveId);
						} else {
							pickContainerId = pc.getId();
						}

						PickingContainerDetailDO pickingContainerDetail = pickingContainerDetailDAO.queryByPickingContainerIdAndItemId(pickContainerId,
								pickOrderDetailId, itemId, warehouseCode, waveId); // step 17
						if (pickingContainerDetail == null) {
							insertPickingContainerDetail(pickContainerId, itemId, numeric, pickNum, warehouseCode, waveId, pickOrderDetailId);
						} else {
							long pcdId = pickingContainerDetail.getId();
							if (isStandard == Constants.ACTIVE) {
								pickingContainerDetailDAO.updateItemQuantity(pcdId, pickContainerId, numeric, numeric, warehouseCode, waveId);
							} else {
								pickingContainerDetailDAO.updateItemQuantity(pcdId, pickContainerId, numeric, pickNum, warehouseCode, waveId);
							}
						}

						if (status == pickCodeDone) { // step 19
							doChangeContainer(pickOrderCode, containerCode, pickContainerId, wid, uid, waveId);
						}
					}

					if (isAllPickOrderListDone(waveId, wid, warehouseCode)) {// step 21

						waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.PICKED.getIndex(), wid, warehouseCode);

						if (isAllNotHanging(waveId, wid, warehouseCode)) { // step 22
							insertWaveComplete(waveId, wid, warehouseCode);
						}
					}

					return status;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					return Constants.TRANSACTION_FAIL;
				}
			}
		});
	}

	/**
	 * 创建 拣货装箱单
	 */
	private Long insertPickingContainer(String containerCode, Long pickingOrderId, Long responsibleId, Long cabinetId, Long warehouseId, Long warehouseCode,
			Long waveId) {

		PickingContainerDO pickingContainerDO = new PickingContainerDO();
		pickingContainerDO.setContainerCode(containerCode);
		pickingContainerDO.setPickingOrderId(pickingOrderId);
		pickingContainerDO.setResponsibleId(responsibleId);
		pickingContainerDO.setOperatorId(responsibleId);
		pickingContainerDO.setCabinetId(cabinetId);
		pickingContainerDO.setWarehouseId(warehouseId);
		pickingContainerDO.setWarehouseCode(warehouseCode);
		pickingContainerDO.setStatus(PickingOrderDetailStatusEnum.CREATE.getIndex());
		pickingContainerDO.setWaveId(waveId);

		return pickingContainerDAO.insertPickingContainerDO(pickingContainerDO);
	}

	/**
	 * 创建 拣货装箱单明细
	 * 
	 * @param pickingContainerId
	 *            拣货装箱单id
	 * @param itemId
	 *            商品id
	 * @param mainSortNumber
	 *            主计价数量
	 * @param pickingSortNumbe
	 *            拣货数量
	 * @param warehouseCode
	 *            分表code
	 * @param waveId
	 *            波次id
	 * @param pickingOrderDetailId
	 *            拣货单明细id
	 */
	private void insertPickingContainerDetail(long pickingContainerId, long itemId, Double mainSortNumber, Double pickingSortNumbe, long warehouseCode,
			long waveId, long pickingOrderDetailId) {

		PickingContainerDetailDO pickingContainerDetailDO = new PickingContainerDetailDO();
		pickingContainerDetailDO.setPickingContainerId(pickingContainerId); // 拣货装箱单id
		pickingContainerDetailDO.setItemId(itemId); // 商品id
		pickingContainerDetailDO.setMainSortNumber(mainSortNumber); // 商品主计价数量
		pickingContainerDetailDO.setPickingSortNumber(pickingSortNumbe);
		pickingContainerDetailDO.setWarehouseCode(warehouseCode); // 分表code
		pickingContainerDetailDO.setWaveId(waveId); // 波次id
		pickingContainerDetailDO.setPickingOrderDetailId(pickingOrderDetailId); // 拣货单明细id

		pickingContainerDetailDAO.insertPickingContainerDetail(pickingContainerDetailDO);
	}

	private boolean isDetailStatusOver(int status) {

		return (status == PickingOrderDetailStatusEnum.OUTOFSTOCK.getIndex() || status == PickingOrderDetailStatusEnum.FINISHED.getIndex());
	}

	private boolean isAllPickOrderDetailListDone(long pickOrderId, long waveId, long warehouseCode) {

		for (PickingOrderDetailDO detail : pickingOrderDetailDAO.queryByPickingOrderId(pickOrderId, waveId, warehouseCode)) {
			if (!isDetailStatusOver(detail.getStatus())) {
				return false;
			}
		}

		return true;
	}

	private boolean isStatusOver(int status) {

		return (status == PickingOrderStatusEnum.FINISHED.getIndex() || status == PickingOrderStatusEnum.ASSIGNMENTED.getIndex());
	}

	private boolean isAllPickOrderListDone(long waveId, long wid, long warehouseCode) {

		for (PickingOrderDO order : pickingOrderDAO.queryByWaveId(waveId, wid, warehouseCode)) {
			if (!isStatusOver(order.getStatus())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 更新拣货单明细
	 * 
	 * @param numeric
	 *            拣货数量
	 */
	private void updatePickingOrderDetails(long pickOrderId, long pickOrderDetailId, long waveId, long wid, long warehouseCode, double numeric, double pickNum,
			long itemId, int pickOrderDetailStatus) {

		pickingOrderDetailDAO.updateStatus(pickOrderDetailId, pickOrderId, waveId, pickOrderDetailStatus, warehouseCode);

		if (itemDAO.queryById(itemId).getIsStandard() == 1) {
			pickingOrderDetailDAO.updateQuanityByArguments(pickOrderId, pickOrderDetailId, waveId, null, null, numeric, null, warehouseCode);
		} else {
			pickingOrderDetailDAO.updateQuanityByArguments(pickOrderId, pickOrderDetailId, waveId, null, null, numeric, pickNum, warehouseCode);
		}
	}

	// 去重
	@Override
	public Integer doAssignPickResult(final long waveId, final long pickOrderId, final List<PickingOrderDetailDO> detailList, final long wid, final Long uid) {

		boolean addTask = false;
		final Long warehouseCode = warehouseDAO.queryWarehouseCodeById(wid);

		Integer result = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {

					for (PickingOrderDetailDO detail : detailList) { // step 11

						double mainShouldNumber = detail.getMainShouldNumber();
						long itemId = detail.getItemId();

						List<InventoryOccupancyDO> inveOccList = inventoryOccupancyDAO.queryByOperateOrder(detail.getId(),
								SourceTypeEnum.PICKING_ORDER_DETAIL.getIndex(), warehouseCode, waveId);

						boolean equals = true; // 是否实拣等于占用, 时间大于占用
						if (detail.getMainActualNumber() <= mainShouldNumber) {
							equals = false;
						}

						if (equals) { // step 11

							for (InventoryOccupancyDO inventory : inveOccList) { // step 12

								inventoryOccupancyDAO.updateActualQuantity(inventory.getId(), inventory.getOccupancyQuantity(), warehouseCode, waveId);
								inventoryInfoService.updateDeduction(inventory.getInventoryInfoId(), wid, inventory.getOccupancyQuantity(),
										inventory.getOccupancyQuantity(), itemId, SourceTypeEnum.INVENTORY_OCCUPY.getIndex(), inventory.getId());
								updateSalesOrderQuantity(waveId, warehouseCode, detail.getMainActualNumber(), detail.getPickingActualNumber(),
										inventory.getOperateOrderId(), inventory.getItemId());
							}

						} else {

							List<InventoryOccupy> occupyList = Lists.newArrayList();
							for (InventoryOccupancyDO inventory : inveOccList) {

								InventoryOccupy obj = new InventoryOccupy();
								CommonUtils.doTrans(inventory, obj);
								occupyList.add(obj);
							}

							for (InventoryOccupy inventory : occupyList) {
								InventoryBatchDO batch = inventoryBatchDAO.queryById(inventory.getInventoryBatchId());
								CommonUtils.doTrans(batch, inventory);
							}

							Collections.sort(occupyList, inventoryComparator);

							for (InventoryOccupy inventory : occupyList) {

								double occupyQuantity = inventory.getOccupancyQuantity();

								if (mainShouldNumber >= occupyQuantity) { // step 12 & 13

									inventoryOccupancyDAO.updateActualQuantity(inventory.getId(), occupyQuantity, warehouseCode, waveId);
									inventoryInfoService.updateDeduction(inventory.getInventoryInfoId(), wid, occupyQuantity, occupyQuantity, itemId,
											SourceTypeEnum.INVENTORY_OCCUPY.getIndex(), inventory.getId());
									mainShouldNumber -= occupyQuantity;
									updateSalesOrderQuantity(waveId, warehouseCode, occupyQuantity, detail.getPickingActualNumber(),
											inventory.getOperateOrderId(), itemId);
								} else {

									inventoryOccupancyDAO.updateActualQuantity(inventory.getId(), mainShouldNumber, warehouseCode, waveId);
									inventoryInfoService.updateDeduction(inventory.getInventoryInfoId(), wid, occupyQuantity, mainShouldNumber, itemId,
											SourceTypeEnum.INVENTORY_OCCUPY.getIndex(), inventory.getId());
									updateSalesOrderQuantity(waveId, warehouseCode, mainShouldNumber, detail.getPickingActualNumber(),
											inventory.getOperateOrderId(), itemId);
									break;
								}
							}
						}
					}

					pickingOrderDAO.updatePickingOrderStatus(PickingOrderStatusEnum.ASSIGNMENTED.getIndex(), pickOrderId, uid, wid, warehouseCode); // step 17

					long cabinetId = cabinetDAO.queryDefaultCabinetId(); // step 18
					PickingContainerDO pickContainer = pickingContainerDAO.queryByContainerCodeAndPicOrderId(null, pickOrderId, wid, warehouseCode);
					pickingContainerDAO.updateStatusAndCabinet(pickContainer.getId(), PickingContainerStatusEnum.TEMORARY.getIndex(), cabinetId, wid,
							warehouseCode);

					int count = 0;
					List<PickingOrderDO> list = pickingOrderDAO.queryByWaveId(waveId, wid, warehouseCode); // step 19

					for (PickingOrderDO obj : list) {
						int pickOrderStatus = pickingOrderDAO.queryPickingOrderByCode(obj.getCode(), wid, warehouseCode).getStatus();
						if (pickOrderStatus == PickingOrderStatusEnum.FINISHED.getIndex() || pickOrderStatus == PickingOrderStatusEnum.ASSIGNMENTED.getIndex()) {
							count++;
						}
					}

					if (count == list.size()) {
						waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.PICKED.getIndex(), wid, warehouseCode);
					}

					if (existsPickingContainerByWaveId(waveId, wid, warehouseCode)) {
						waveOrderDAO.updateStatusById(waveId, WaveOrderStatusEnum.FINISH.getIndex(), wid, warehouseCode);
					}

					return Constants.TRANSACTION_SUCC;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					return Constants.TRANSACTION_FAIL;
				}
			}
		});

		if (addTask) {
			addArtificailTask(pickOrderId, wid, waveId, warehouseCode);
		}

		return result;
	}

	private void updateSalesOrderQuantity(final long waveId, Long warehouseCode, double mainNumber, double pickNumber, long orderId, long itemId) {
		if (isItemStandard(itemId)) {
			salesOrderDetailDAO.updateSortQuanity(orderId, waveId, warehouseCode, mainNumber, mainNumber, pickNumber);
		} else {
			if (isKgOrG(itemId)) {
				salesOrderDetailDAO.updateSortQuanity(orderId, waveId, warehouseCode, mainNumber, mainNumber, pickNumber);
			} else {
				salesOrderDetailDAO.updateSortQuanity(orderId, waveId, warehouseCode, mainNumber, pickNumber, pickNumber);
			}
		}
	}

	private boolean existsPickingContainerByWaveId(long waveId, long wid, long warehouseCode) {

		return (pickingContainerDAO.queryByWaveIdAndContainerCode(waveId, null, wid, warehouseCode, null).size() == 0);
	}

	private boolean isItemStandard(long itemId) {

		return (itemDAO.queryById(itemId).getIsStandard() == Constants.ACTIVE);
	}

	private boolean isKgOrG(long itemId) {

		BasicItemDO item = itemDAO.queryById(itemId);
		if (item.getInventoryUnit().equals(WeightEnum.g.getValue()) || item.getInventoryUnit().equals(WeightEnum.kg.getValue())) {
			return true;
		} else {
			return false;
		}
	}

	private void addArtificailTask(long pickOrderId, long wid, long waveId, long warehouseCode) {

		ArtificialTaskDO artificialTask = new ArtificialTaskDO();

		artificialTask.setOrderId(pickOrderId);
		artificialTask.setOrderType(SourceTypeEnum.PICKING_ORDER.getIndex());
		artificialTask.setWarehouseCode(warehouseCode);
		artificialTask.setWarehouseId(wid);
		artificialTask.setWaveId(waveId);
		artificialTask.setTaskType(ArtificialTaskTypeEnum.ARTIFICIAL_DELIVERY.getIndex());
		artificialTask.setStatus(ArtificialTaskStatusEnum.CREATE.getIndex());
		artificialTask.setTaskDescription("拣货单：" + pickOrderId + " 波次：" + waveId);

		artificialTaskDAO.insertArtificialTask(artificialTask);
	}

	private InventoryComparator inventoryComparator = new InventoryComparator();

	private class InventoryComparator implements Comparator<InventoryOccupy> {
		@Override
		public int compare(InventoryOccupy o1, InventoryOccupy o2) {

			if (o1.getProduceDate() != null) {

				int result = compareDate(o1.getProduceDate(), o2.getProduceDate());
				if (result != 0) {
					return result;
				}

				return compareDate(o1.getArriveDate(), o2.getArriveDate());
			} else {
				return compareDate(o1.getArriveDate(), o2.getArriveDate());
			}
		}
	}

	private int compareDate(Date d1, Date d2) {

		if (d1.equals(d2)) {
			return 0;
		}

		if (d1.after(d2)) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public Integer doChangeContainer(final String pickOrderCode, final String containerCode, final long pickContainerId, final long wid, final long uid,
			final long waveId) {

		return (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {
					Long warehouseCode = warehouseDAO.queryWarehouseCodeById(wid);

					pickingContainerDAO.updateStatusAndCabinet(pickContainerId, PickingContainerStatusEnum.FULLTANK.getIndex(), null, wid, warehouseCode);

					if (isHanging(pickOrderCode, wid, warehouseCode) == Constants.ACTIVE) {
						insertPackingComplete(waveId, wid, warehouseCode, pickContainerId, containerCode);
					}

					return Constants.TRANSACTION_SUCC;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					return Constants.TRANSACTION_FAIL;
				}
			}
		});
	}

	private void insertWaveComplete(long waveId, long wid, Long warehouseCode) {

		WcsWaveCompleteDO db = new WcsWaveCompleteDO();
		db.setWaveCode(waveOrderDAO.queryWaveOrderById(waveId, wid, warehouseCode).getWaveCode());
		db.setContainerNum(pickingContainerDAO.queryByWaveIdAndContainerCode(waveId, null, wid, warehouseCode, null).size());
		db.setWarehouseId(wid);
		wcsWaveCompleteDAO.insertWcsWaveComplete(db);
	}

	private boolean isAllNotHanging(long waveId, Long wid, Long warehouseCode) {

		for (PickingOrderDO order : pickingOrderDAO.queryByWaveId(waveId, wid, warehouseCode)) {
			if (isHanging(order.getCode(), wid, warehouseCode) == Constants.ACTIVE) {
				return true;
			}
		}

		return false;
	}

	private int isHanging(String pickOrderCode, Long wid, Long warehouseCode) {

		PickingOrderDO pickOrder = pickingOrderDAO.queryPickingOrderByCode(pickOrderCode, wid, warehouseCode);
		SortingGoodsPartitionDO part = sortingGoodsPartitionDAO.querySortingGoodsPartitionById(pickOrder.getSortingGoodsPartitionId());

		return part.getIsHanging();
	}

	private void insertPackingComplete(long waveId, long wid, Long warehouseCode, Long pickContainerId, String containerCode) {

		WcsPickingCompleteDO db = new WcsPickingCompleteDO();
		db.setContainerCode(containerCode);
		db.setWaveCode(waveOrderDAO.queryWaveOrderById(waveId, wid, warehouseCode).getWaveCode());
		db.setAttribute(getContainerStatus(waveId, wid, warehouseCode));
		db.setWarehouseId(wid);
		wcsPickingCompleteDAO.insertWcsPackingComplete(db);
	}

	private int getContainerStatus(long waveId, long wid, Long warehouseCode) {

		BatchOrderDO batchOrder = batchOrderDAO.queryByWaveId(waveId, wid, warehouseCode);

		if (batchOrder.getBatchProperty() == ServiceTypeEnum.IN_TIME.getIndex()) {
			return Constants.IN_TIME_ORDER;
		}

		List<PickingContainerDetailDO> list = pickingContainerDetailDAO.queryListByPickingContainerId(null, warehouseCode, waveId);

		for (PickingContainerDetailDO pc : list) {
			BasicItemDO item = itemDAO.queryById(pc.getItemId());
			if (item.getStorageType().equals(StorageTypeEnum.HOT.getIndex())) {
				return Constants.SET_TIME_ORDER_HOT;
			}
		}

		return Constants.SET_TIME_ORDER_NO_HOT;
	}
}
