package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.groovy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.OrderInventoryOccupyClientAPI;
import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.dal.dao.BatchOrderDAO;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.InventoryLogDAO;
import com.wdk.wms.basic.dal.dao.InventoryOccupancyDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.SalesOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionCabinetDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WaveOrderDAO;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.BatchOrderDO;
import com.wdk.wms.basic.daoobject.InventoryInfoAndBatchDO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.basic.daoobject.InventoryLogDO;
import com.wdk.wms.basic.daoobject.InventoryOccupancyDO;
import com.wdk.wms.basic.daoobject.PickingOrderDO;
import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;
import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.enums.InventoryOperateModeEnum;
import com.wdk.wms.basic.enums.InventoryResultFailCauseEnum;
import com.wdk.wms.basic.enums.OutOperationModeEnum;
import com.wdk.wms.basic.enums.PickingOrderDetailStatusEnum;
import com.wdk.wms.basic.enums.PickingOrderStatusEnum;
import com.wdk.wms.basic.enums.PickingOrderTypeEnum;
import com.wdk.wms.basic.enums.SortingGoodsPartitionTypeEnum;
import com.wdk.wms.basic.enums.SourceTypeEnum;
import com.wdk.wms.basic.out.order.parameters.SaleOrderInfo;
import com.wdk.wms.basic.result.CabinetInventoryInfo;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;
import com.wdk.wms.inventory.parameters.ItemInventoryProcesssParameter;
import com.wdk.wms.inventory.parameters.OrderInventoryResult;

public class OrderInventoryOccupyClientAPIImpl implements OrderInventoryOccupyClientAPI {

	@Autowired
	private InventoryInfoDAO inventoryInfoDAO;
	@Autowired
	private InventoryLogDAO inventoryLogDAO;
	@Autowired
	private CabinetDAO cabinetDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private SalesOrderDetailDAO salesOrderDetailDAO;
	@Autowired
	private SortingGoodsPartitionCabinetDAO sortingGoodsPartitionCabinetDAO;// 分区dao
	@Autowired
	private PickingOrderDAO pickingOrderDAO;
	@Autowired
	private WaveOrderDAO waveOrderDAO;
	@Autowired
	private PickingOrderDetailDAO pickingOrderDetailDAO;
	@Autowired
	private SortingGoodsPartitionDAO sortingGoodsPartitionDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private BatchOrderDAO batchOrderDAO;
	@Autowired
	private InventoryOccupancyDAO inventoryOccupancyDAO;
	@Autowired
	private CommonService commonService; // 用于库存数量转换
	@Autowired
	private TransactionTemplate transactionTemplate;

	private final Logger log = LoggerFactory.getLogger(OrderInventoryOccupyClientAPIImpl.class);

	@Override
	public List<OrderInventoryResult> orderInventoryOccupy(List<SaleOrderInfo> saleOrderInfos, int[] cabinetTypeRange, int isSale, int outOperationMode,
			boolean isStockoutOccupy) {
		List<OrderInventoryResult> results = new ArrayList<OrderInventoryResult>();
		for (SaleOrderInfo saleOrderInfo : saleOrderInfos) {
			OrderInventoryResult orderInventoryResult=new OrderInventoryResult();
			SalesOrderDO salesOrderDO = saleOrderInfo.getSalesOrderDO();// 主订单
			List<SalesOrderDetailDO> salesOrderDetailDOs = saleOrderInfo.getSalesOrderDetailDOs();// 子订单集合  （集合不可能为空）
			if (checkHaveProcess(salesOrderDetailDOs, salesOrderDO.getWarehouseId(), salesOrderDO.getWaveId())) { // 如果输入人工波次,并且该主订单上次库存操作成功了
				orderInventoryResult.setSuccess(true);//不进行再次的库存操作，直接跳过
			}else{
				 orderInventoryResult = singleMainOrderInventoryOccupy(saleOrderInfo, cabinetTypeRange, isSale, outOperationMode,
							isStockoutOccupy);
			}
			orderInventoryResult.setSalesOrderId(saleOrderInfo.getSalesOrderDO().getId()); // 销售主订单id
			orderInventoryResult.setWaveOrderId(saleOrderInfo.getSalesOrderDO().getWaveId());// 波次id
			results.add(orderInventoryResult);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	private OrderInventoryResult singleMainOrderInventoryOccupy(SaleOrderInfo saleOrderInfo, final int[] cabinetTypeRange, final int isSale,
			final int outOperationMode, final boolean isStockoutOccupy) {
		SalesOrderDO salesOrderDO = saleOrderInfo.getSalesOrderDO();// 主订单
		final long warehouseId = salesOrderDO.getWarehouseId();// 仓库id
		final long warehouseCode = salesOrderDO.getWarehouseCode();
		final long ownerId = salesOrderDO.getOwnerId();// 货主id
		List<SalesOrderDetailDO> salesOrderDetailDOs = saleOrderInfo.getSalesOrderDetailDOs();// 子订单集合  （集合不可能为空）
		Collections.sort(salesOrderDetailDOs, new Comparator<SalesOrderDetailDO>() { // 根据商品id进行排序
					public int compare(SalesOrderDetailDO o1, SalesOrderDetailDO o2) {
						if (o1.getItemId() > o2.getItemId()) { // 降序 大于 -1 小于 1
							return -1;
						} else if (o1.getItemId() < o2.getItemId()) {
							return 1;
						} else {
							return 0;
						}
					}
				});
		OrderInventoryResult orderInventoryResult = new OrderInventoryResult();// 返回结果
		final List<SalesOrderDetailDO> existInventoryOrderDetalis = new ArrayList<SalesOrderDetailDO>();// 库存中存在的商品的子订单
		final List<SalesOrderDetailDO> inExistInventoryOrderDetalis = new ArrayList<SalesOrderDetailDO>();// 库存中不存在的商品的子订单
		for (SalesOrderDetailDO salesOrderDetailDO : salesOrderDetailDOs) {

			InventoryInfoQuery inventoryInfoQuery = new InventoryInfoQuery();// 库存查询条件
			inventoryInfoQuery.setItemId(salesOrderDetailDO.getItemId());// 商品id
			inventoryInfoQuery.setOwnerId(ownerId);// 货主
			inventoryInfoQuery.setWarehouseId(warehouseId);// 仓库
			inventoryInfoQuery.setWarehouseCode(warehouseCode);// 仓库分表code
			List<Long> cabinetIds = cabinetDAO.queryIdsByTypeAndIsActive(cabinetTypeRange, isSale, warehouseId);
			inventoryInfoQuery.setCabinetTypeIds(cabinetIds);
			List<InventoryInfoAndBatchDO> inventoryDetailList = inventoryInfoDAO.queryInventoryByCabinetType(inventoryInfoQuery);// 查出所有符合条件的库存记录
			if (inventoryDetailList.isEmpty()) // 如果库存中不存在该商品的相关记录
			{
				inExistInventoryOrderDetalis.add(salesOrderDetailDO);
			} else {
				existInventoryOrderDetalis.add(salesOrderDetailDO);
			}
			if (!inExistInventoryOrderDetalis.isEmpty()) // 如果库存记录中不存在该商品
			{
				if (outOperationMode == OutOperationModeEnum.SCENE.getIndex() || outOperationMode == OutOperationModeEnum.WHOLESALE.getIndex()) {
					orderInventoryResult.setDetailOrderId(salesOrderDetailDO.getId());
					orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.INVENTORY_OUTSTOCK.getIndex()); // 缺货
					orderInventoryResult.setSuccess(false);
				}
				if (outOperationMode == OutOperationModeEnum.ONLINE.getIndex() && !isStockoutOccupy) { // 线上，并且不允许缺货占用
					orderInventoryResult.setDetailOrderId(salesOrderDetailDO.getId());
					orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.INVENTORY_OUTSTOCK.getIndex()); // 缺货
					orderInventoryResult.setSuccess(false);
				}
				return orderInventoryResult; // 缺货异常 返回
			}
		}
		orderInventoryResult = (OrderInventoryResult) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				OrderInventoryResult orderInventoryResult = new OrderInventoryResult();
				try {
					for (SalesOrderDetailDO salesOrderDetailDO : existInventoryOrderDetalis) {
						ItemInventoryProcesssParameter itemInventoryProcesssParameter = new ItemInventoryProcesssParameter();// 单个商品库存占用方法参数组装
						itemInventoryProcesssParameter.setSourceOrderId(salesOrderDetailDO.getId());
						itemInventoryProcesssParameter.setSourceOrderType(SourceTypeEnum.SALES_ORDER_DETAIL.getIndex());
						itemInventoryProcesssParameter.setOwnerId(ownerId);
						itemInventoryProcesssParameter.setWarehouseId(warehouseId);
						itemInventoryProcesssParameter.setWarehouseCode(warehouseCode);
						itemInventoryProcesssParameter.setItemId(salesOrderDetailDO.getItemId());
						itemInventoryProcesssParameter.setItemQuanity(salesOrderDetailDO.getMainBuyNumber());
						itemInventoryProcesssParameter.setCabinetTypeRange(cabinetTypeRange);
						itemInventoryProcesssParameter.setIsSale(isSale);
						itemInventoryProcesssParameter.setStockoutOccupy(isStockoutOccupy);// 是否可以缺货占用
						itemInventoryProcesssParameter.setWaveId(salesOrderDetailDO.getWaveId());
						if (outOperationMode == OutOperationModeEnum.SCENE.getIndex() || outOperationMode == OutOperationModeEnum.WHOLESALE.getIndex()) {
							itemInventoryProcesssParameter.setOccupyOrDedution(InventoryOperateModeEnum.DEDUCTION.getIndex());// 1代表占用，2代表扣减,现场和批发为扣减，即2
						} else {
							itemInventoryProcesssParameter.setOccupyOrDedution(InventoryOperateModeEnum.OCCUPY.getIndex());// 线上为1
						}
						BasicItemDO itemDO = itemDAO.queryById(salesOrderDetailDO.getItemId());
						if (itemDO.getIsStandard() == 0 && outOperationMode == OutOperationModeEnum.ONLINE.getIndex()) { // 如果是非标品，且是线上
							itemInventoryProcesssParameter.setMultipleCabinet(false);// 不能多个库位操作
						} else {
							itemInventoryProcesssParameter.setMultipleCabinet(true);
						}
						orderInventoryResult = itemInventoryProcess(itemInventoryProcesssParameter);// 调用单个商品的库存占用方法
						if (!orderInventoryResult.isSuccess()) {
							status.setRollbackOnly();
							return orderInventoryResult;
						}
					}
					orderInventoryResult.setSuccess(true);
					return orderInventoryResult;

				} catch (Exception e) {
					orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.SYSTEM_ERROR.getIndex());// 后端系统异常
					orderInventoryResult.setSuccess(false);
					status.setRollbackOnly();
					log.error("system error", e);
					return orderInventoryResult;
				}
			}
		});
		return orderInventoryResult;
	}

	/*
	 * 对于非标品，在库存记录中找到最佳库位的库存记录集合
	 */
	private List<InventoryInfoAndBatchDO> getCabinetInventoryInfos(List<InventoryInfoAndBatchDO> inventoryDetailList, double itemRemainCount) {
		// 如果是非标品，按库位整合库存记录
		List<InventoryInfoAndBatchDO> targetInventoryInfoAndBatchs = new ArrayList<InventoryInfoAndBatchDO>();// 得到的最终的具体库位下的库存记录
		HashMap<Long, CabinetInventoryInfo> map = new HashMap<Long, CabinetInventoryInfo>();
		map = reorganizeInventoryInfo(inventoryDetailList);
		List<CabinetInventoryInfo> enableCabinetInventorys = new ArrayList<CabinetInventoryInfo>(); // 数量超过
		List<CabinetInventoryInfo> unableCabinetInventorys = new ArrayList<CabinetInventoryInfo>(); // 数量少于
		for (Entry<Long, CabinetInventoryInfo> entry : map.entrySet()) {
			if (entry.getValue().getTotalAvailableQuanity() >= itemRemainCount) {
				enableCabinetInventorys.add(entry.getValue());
			} else {
				unableCabinetInventorys.add(entry.getValue());
			}
		}
		if (enableCabinetInventorys.isEmpty()) { // 如果所有库位的库存都少于要求值
			Collections.sort(unableCabinetInventorys, new Comparator<CabinetInventoryInfo>() { // 根据商品id进行排序
						public int compare(CabinetInventoryInfo o1, CabinetInventoryInfo o2) {
							if (o1.getTotalAvailableQuanity() > o2.getTotalAvailableQuanity())
								return -1;
							else if (o1.getTotalAvailableQuanity() < o2.getTotalAvailableQuanity()) {
								return 1;
							} else {
								return 0;
							}
						}
					});
			targetInventoryInfoAndBatchs = unableCabinetInventorys.get(0).getInventoryInfoDOs();// 数量最多的一个库位下的库存记录
		} else { // 如果有库位满足要求
			for (CabinetInventoryInfo cabinetInventoryInfo : enableCabinetInventorys) {
				Date produceDate = new Date();
				Date arriveDate = new Date();
				List<InventoryInfoAndBatchDO> inventoryInfoAndBatchDOs = cabinetInventoryInfo.getInventoryInfoDOs();
				for (InventoryInfoAndBatchDO inventoryInfoAndBatchDO : inventoryInfoAndBatchDOs) {
					if (inventoryInfoAndBatchDO.getProduceDate() == null) {
						inventoryInfoAndBatchDO.setProduceDate(inventoryInfoAndBatchDO.getArriveDate());// 如果生产日期为空，则生产日期设置为到货日期
					}
					if (inventoryInfoAndBatchDO.getProduceDate().before(produceDate)) {
						produceDate = inventoryInfoAndBatchDO.getProduceDate();
					}
					if (inventoryInfoAndBatchDO.getArriveDate().before(arriveDate)) {
						arriveDate = inventoryInfoAndBatchDO.getArriveDate();
					}
				}
				cabinetInventoryInfo.setArriveDate(arriveDate);
				cabinetInventoryInfo.setProduceDate(produceDate);
			}
			Collections.sort(enableCabinetInventorys, new PriorityCabinetComparator());
			targetInventoryInfoAndBatchs = enableCabinetInventorys.get(0).getInventoryInfoDOs();// 取得特定库位上面的库存相关记录
		}
		return targetInventoryInfoAndBatchs;
	}

	/* 根据库位整理订单 */
	private HashMap<Long, CabinetInventoryInfo> reorganizeInventoryInfo(List<InventoryInfoAndBatchDO> inventoryInfoDOs) {
		HashMap<Long, CabinetInventoryInfo> map = new HashMap<Long, CabinetInventoryInfo>();
		for (InventoryInfoAndBatchDO inventoryInfoAndBatchDO : inventoryInfoDOs) {
			if (!map.containsKey(inventoryInfoAndBatchDO.getCabinetId())) {
				CabinetInventoryInfo cabinetInventoryInfo = new CabinetInventoryInfo();
				cabinetInventoryInfo.setCabinetId(inventoryInfoAndBatchDO.getCabinetId());
				cabinetInventoryInfo.setTotalAvailableQuanity(inventoryInfoAndBatchDO.getAvailableInvent());// 可用库存
				List<InventoryInfoAndBatchDO> list = new ArrayList<InventoryInfoAndBatchDO>();
				list.add(inventoryInfoAndBatchDO);
				cabinetInventoryInfo.setInventoryInfoDOs(list);
				map.put(inventoryInfoAndBatchDO.getCabinetId(), cabinetInventoryInfo);
			} else {
				CabinetInventoryInfo cabinetInventoryInfo = map.get(inventoryInfoAndBatchDO.getCabinetId());
				cabinetInventoryInfo.setTotalAvailableQuanity(cabinetInventoryInfo.getTotalAvailableQuanity() + inventoryInfoAndBatchDO.getAvailableInvent());
				List<InventoryInfoAndBatchDO> list = cabinetInventoryInfo.getInventoryInfoDOs();
				list.add(inventoryInfoAndBatchDO);
			}
		}
		return map;
	}

	@Override
	public boolean generatePickingOrder(final long waveId, final long warehouseId) {

		boolean result = true;// 定义操作结果，用于返回

		result = (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				Boolean result = true;
				try {
					BasicWarehouseDO warehouseDO = warehouseDAO.queryWarehouseById(warehouseId);
					List<InventoryOccupancyDO> inventoryOccupancyDOs = inventoryOccupancyDAO.queryByWaveId(warehouseId, warehouseDO.getWarehouseCode(), waveId);// 根据波次id查找库存占用表
					for (InventoryOccupancyDO inventoryOccupancyDO : inventoryOccupancyDOs) {
						long cabinetId = inventoryOccupancyDO.getCabinetId();
						String pickingAreaCode = sortingGoodsPartitionCabinetDAO.queryByCabinetIdAndType(cabinetId,
								SortingGoodsPartitionTypeEnum.PICKING.getIndex(), warehouseId);// 拣货分区编码

						PickingOrderDO pickingOrderDO = pickingOrderDAO.queryByWaveIdAndAreaCode(waveId, pickingAreaCode, warehouseId,
								warehouseDO.getWarehouseCode());// 通过波次id和拣货分区code查找拣货单
						BatchOrderDO batchOrderDO = batchOrderDAO.queryByWaveId(waveId, warehouseId, warehouseDO.getWarehouseCode());// 批次
						SortingGoodsPartitionDO sortingGoodsPartitionDO = sortingGoodsPartitionDAO.querySortingGoodsPartitionByCode(pickingAreaCode,
								warehouseId);// 拣货分区
						WaveOrderDO waveOrderDO = waveOrderDAO.queryWaveOrderById(waveId, warehouseId, warehouseDO.getWarehouseCode());
						SalesOrderDetailDO salesOrderDetailDO = salesOrderDetailDAO.queryByDetailIdAndWaveId(inventoryOccupancyDO.getOccupancyOrderId(),
								waveId, warehouseDO.getWarehouseCode());// 通过波次id
						Long pickingOrderId = 0L;// 拣货单id
						if (pickingOrderDO == null) // 如果拣货单不存在，就创建
						{
							PickingOrderDO newPickingOrderDO = new PickingOrderDO();
							newPickingOrderDO.setCode("TestCode");// 规则生成规则待定
							newPickingOrderDO.setSortingGoodsPartitionId(sortingGoodsPartitionDO.getId());// 拣货分区id
							newPickingOrderDO.setWarehouseId(warehouseId);
							newPickingOrderDO.setWarehouseCode(warehouseDO.getWarehouseCode());
							newPickingOrderDO.setOwnerId(inventoryOccupancyDO.getOwnerId());// 货主
							newPickingOrderDO.setWaveId(waveId);
							newPickingOrderDO.setStatus(PickingOrderStatusEnum.CREATE.getIndex());// 创建货单状态创建
							newPickingOrderDO.setType(PickingOrderTypeEnum.SALES.getIndex());// 拣货单类型为销售拣货
							newPickingOrderDO.setPickingTool(sortingGoodsPartitionDO.getPickTool());// 拣货工具为拣货分区里的字段
							newPickingOrderDO.setPickingPriority(getPickingPrior(batchOrderDO.getBatchProperty()));// 根据批次字段计算拣货优先级
							pickingOrderId = pickingOrderDAO.insertPickingOrder(newPickingOrderDO);
						} else {
							pickingOrderId = pickingOrderDO.getId();
						}
						BasicItemDO item = itemDAO.queryById(inventoryOccupancyDO.getItemId());// 商品id
						long pickingOrderDetailId = 0L;
						PickingOrderDetailDO pickingOrderDetailDO = null;
						if (item.getIsStandard() == 1) { // 如果是标品
															// 通过拣货单，商品和库位查询拣货单明细
							pickingOrderDetailDO = pickingOrderDetailDAO.queryByPickingOrderIdAndItemAndCabinet(pickingOrderId, waveId, item.getId(),
									cabinetId, warehouseDO.getWarehouseCode());
						} else { // 如果是非标品，则根据销售订单子订单和货位查询
							pickingOrderDetailDO = pickingOrderDetailDAO.queryBySalesOrderDetailIdAndCabinet(pickingOrderId, waveId,
									salesOrderDetailDO.getId(), item.getId(), cabinetId, warehouseDO.getWarehouseCode());// 通过子订单和货位查询明细
						}
						if (pickingOrderDetailDO == null) { // 如果不存在，则创建
															// ，标品没有拣货单位
							PickingOrderDetailDO newPickingOrderDetailDO = new PickingOrderDetailDO();
							newPickingOrderDetailDO.setPickingOrderId(pickingOrderId);// 拣货单id
							newPickingOrderDetailDO.setItemId(item.getId());
							newPickingOrderDetailDO.setItemName(item.getName());// 商品名称
							newPickingOrderDetailDO.setWarehouseCode(warehouseDO.getWarehouseCode());
							newPickingOrderDetailDO.setWaveId(waveId); // 波次id
							newPickingOrderDetailDO.setCabinetId(cabinetId);
							newPickingOrderDetailDO.setMainUnit(salesOrderDetailDO.getMainUnit());
							newPickingOrderDetailDO.setStatus(PickingOrderDetailStatusEnum.CREATE.getIndex()); // 状态
							newPickingOrderDetailDO.setMainShouldNumber(inventoryOccupancyDO.getOccupancyQuantity());// 应该拣货数量为库存占用数量
							if (item.getIsStandard() == 0) { // 对于非标品来说，需要拣货单位和拣货数量
																// ,来自销售订单明细
								newPickingOrderDetailDO.setPickingShouldNumber(salesOrderDetailDO.getPickingBuyNumber());
								newPickingOrderDetailDO.setPickingUnit(salesOrderDetailDO.getPickingUnit());
								newPickingOrderDetailDO.setSalesOrderDetailId(salesOrderDetailDO.getId()); // 销售子订单id
								newPickingOrderDetailDO.setAccessorialService(salesOrderDetailDO.getAccessorialService());// 对于非标品，需要把子订单中的服务待下去
							}
							pickingOrderDetailId = pickingOrderDetailDAO.insertPickingOrderDetail(newPickingOrderDetailDO);

						} else { // 如果存在，则更新数量
							pickingOrderDetailId = pickingOrderDetailDO.getId();
							pickingOrderDetailDAO.updateQuanityByArguments(pickingOrderDetailId, pickingOrderId, waveId,
									inventoryOccupancyDO.getOccupancyQuantity(), null, null, null, warehouseDO.getWarehouseCode());// 跟新明细数量
						}
						if (item.getIsStandard() == 0) { // 如果是非标品，则更新拣货表明细中销售子订单id字段
							pickingOrderDetailDAO.updateSalesOrderDeailId(salesOrderDetailDO.getId(), waveId, pickingOrderDetailId, pickingOrderId,
									warehouseDO.getWarehouseCode());
						}
						inventoryOccupancyDAO.updateOccupancyOrderOperater(inventoryOccupancyDO.getId(), pickingOrderDetailId,
								SourceTypeEnum.PICKING_ORDER_DETAIL.getIndex(), warehouseId, warehouseDO.getWarehouseCode(), waveId);// 更新库存占用表中操作单
					}
					return result;
				} catch (Exception e) {
					result = false;
					status.setRollbackOnly();
					log.error("system error", e);
					return result;

				}
			}
		});
		return result;
	}

	/*
	 * 获取拣货单的优先级
	 */
	private Long getPickingPrior(int property) { // 根据属性 找拣货优先级 及时达10：定时达20
		StringBuffer sb;
		String date = DateFormatUtils.format(new Date(), "yyMMddHHmmss");
		if (property == 1) { // 及时达
			sb = new StringBuffer();
			sb.append("10");
			sb.append(date);
			return Long.valueOf(sb.toString());
		} else if (property == 2) { // 定时达
			sb = new StringBuffer();
			sb.append("20");
			sb.append(date);
			return Long.valueOf(sb.toString());
		}
		sb = new StringBuffer();
		sb.append("99");
		sb.append(date);
		return Long.valueOf(sb.toString()); // 不满足条件
	}

	class PriorityComparator implements Comparator<InventoryInfoAndBatchDO> {

		@Override
		public int compare(InventoryInfoAndBatchDO o1, InventoryInfoAndBatchDO o2) {

			Date d1 = o1.getProduceDate();
			Date d2 = o2.getProduceDate();
			if (d1 == null) {
				d1 = o1.getArriveDate();// 生产日期为空，则为到货日期
			}
			if (d2 == null) {
				d2 = o2.getArriveDate();
			}
			if (d1.getTime() != d2.getTime()) {
				if (d1.before(d2)) // 生产日期早的优先级较高，排在前面
					return 1;
				if (d1.after(d2)) {
					return -1;
				}
				return 0;
			} else {
				if (o1.getArriveDate().before(o2.getArriveDate())) { // 到货日期造的，拍在前面
					return 1;
				}
				if (o1.getArriveDate().after(o2.getArriveDate())) {
					return -1;
				}
				BasicCabinetDO basicCabinetDO1 = cabinetDAO.queryCabinetById(o1.getCabinetId());// 库位
				BasicCabinetDO basicCabinetDO2 = cabinetDAO.queryCabinetById(o2.getCabinetId());//

				int cabinetPriority1 = basicCabinetDO1.getPickPriority(); // 根据库位的拣货优先级来排
				int cabinetPriority2 = basicCabinetDO2.getPickPriority();
				if (cabinetPriority1 > cabinetPriority2) {
					return -1;
				}
				if (cabinetPriority1 < cabinetPriority2) {
					return 1;
				} else {
					long inventoryid1 = o1.getId();
					long inventoryid2 = o2.getId();
					if (inventoryid1 < inventoryid2) {
						return 1;
					}
					if (inventoryid1 > inventoryid2) {
						return -1;
					}
					return 0;
				}
			}
		}

	}

	class PriorityCabinetComparator implements Comparator<CabinetInventoryInfo> {

		@Override
		public int compare(CabinetInventoryInfo o1, CabinetInventoryInfo o2) {

			Date d1 = o1.getProduceDate();
			Date d2 = o2.getProduceDate();
			if (d1 == null) {
				d1 = o1.getArriveDate();// 生产日期为空，则为到货日期
			}
			if (d2 == null) {
				d2 = o2.getArriveDate();
			}
			if (d1.getTime() != d2.getTime()) {
				if (d1.before(d2)) // 生产日期早的优先级较高，排在前面
					return 1;
				if (d1.after(d2)) {
					return -1;
				}
				return 0;
			} else {
				if (o1.getArriveDate().before(o2.getArriveDate())) { // 到货日期早的，排在前面
					return 1;
				}
				if (o1.getArriveDate().after(o2.getArriveDate())) {
					return -1;
				}
				return 1; // 条件一样
			}
		}

	}

	/*
	 * 独立的库存占用方法，以item为粒度
	 */
	private OrderInventoryResult itemInventoryProcess(ItemInventoryProcesssParameter itemInventoryProcesssParameter)
			throws InterruptedException {
		OrderInventoryResult orderInventoryResult = new OrderInventoryResult();

		InventoryInfoQuery inventoryInfoQuery = new InventoryInfoQuery();// 库存查询条件
		inventoryInfoQuery.setItemId(itemInventoryProcesssParameter.getItemId());// 商品id
		inventoryInfoQuery.setOwnerId(itemInventoryProcesssParameter.getOwnerId());// 货主
		inventoryInfoQuery.setWarehouseId(itemInventoryProcesssParameter.getWarehouseId());// 仓库
		inventoryInfoQuery.setWarehouseCode(itemInventoryProcesssParameter.getWarehouseCode());// 仓库分表code
		inventoryInfoQuery.setStatus(1);
		List<Long> cabinetIds = cabinetDAO.queryIdsByTypeAndIsActive(itemInventoryProcesssParameter.getCabinetTypeRange(),
				itemInventoryProcesssParameter.getIsSale(), itemInventoryProcesssParameter.getWarehouseId());
		inventoryInfoQuery.setCabinetTypeIds(cabinetIds);

		int retry = 0; // 重试次数，最多为3
		int lockChangeNum = 0; // 标记是否锁成功
		do {
			if (retry != 0)
				Thread.sleep(200);// 等待200ms
			lockChangeNum = inventoryInfoDAO.updateInventoryInfoStatusByCabinetType(inventoryInfoQuery);// 锁住该商品的库存记录
			retry++; // 记录重试次数
		} while (retry < 3 && lockChangeNum == 0);
		if (lockChangeNum == 0) { // 如果没锁住
			orderInventoryResult.setDetailOrderId(itemInventoryProcesssParameter.getSourceOrderId());// 未被锁住库存的子订单id
			orderInventoryResult.setSuccess(false);// 库存操作失败
			orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.INVENTORY_LOCK.getIndex());// 锁原因造成的失败
			log.info("库存锁失败，商品id为：" + itemInventoryProcesssParameter.getItemId());
			return orderInventoryResult;
		}
		List<InventoryInfoAndBatchDO> inventoryDetailList = inventoryInfoDAO.queryInventory(inventoryInfoQuery);// 查出所有符合条件的库存记录
		double inventoryQuanity = commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), itemInventoryProcesssParameter.getItemQuanity(),
				itemInventoryProcesssParameter.getWarehouseId(), true);
		if (inventoryQuanity != (int) inventoryQuanity) { // 库存小数问题
			orderInventoryResult.setDetailOrderId(itemInventoryProcesssParameter.getSourceOrderId());// 未被锁住库存的子订单id
			orderInventoryResult.setSuccess(false);// 库存操作失败
			orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.INVENTORY_DECIMAL.getIndex());// 库存小数造成的失败
			log.info("库存小数原因，商品id为：" + itemInventoryProcesssParameter.getItemId());
			return orderInventoryResult;
		}
		long itemRemainCount = (long) inventoryQuanity;// 需要占用的商品库存数量
		if (!itemInventoryProcesssParameter.isMultipleCabinet()) { // 如果是单个库位
			inventoryDetailList = getCabinetInventoryInfos(inventoryDetailList, itemRemainCount);// 取得一个库位上的库存信息
		}
		Collections.sort(inventoryDetailList, new PriorityComparator());// 库存优先级排序
		List<InventoryOccupancyDO> itemOccupyDetails = new ArrayList<InventoryOccupancyDO>();// 库存占用表记录
		for (InventoryInfoAndBatchDO inventoryInfoAndBatchDO : inventoryDetailList) {
			if (itemRemainCount == 0) // 如果需要占用的商品库存数量为0，结束此次库存占用过程
				break;
			if (inventoryInfoAndBatchDO.getAvailableInvent() == 0) // 如果可用库存的数量为0，则考虑下一条库存记录
				continue;
			InventoryInfoDO inventoryInfoDO = new InventoryInfoDO();// 库存变化参数
			inventoryInfoDO.setId(inventoryInfoAndBatchDO.getId()); // 设置id
			inventoryInfoDO.setWarehouseId(inventoryInfoAndBatchDO.getWarehouseId());
			inventoryInfoDO.setWarehouseCode(inventoryInfoAndBatchDO.getWarehouseCode());
			inventoryInfoDO.setCabinetId(inventoryInfoAndBatchDO.getCabinetId());
			inventoryInfoDO.setItemBatchId(inventoryInfoAndBatchDO.getItemBatchId());
			inventoryInfoDO.setItemId(inventoryInfoAndBatchDO.getItemId());
			inventoryInfoDO.setOwnerId(inventoryInfoAndBatchDO.getOwnerId());

			InventoryLogDO inventoryLogDO = new InventoryLogDO();// 库存变换日志
			inventoryLogDO.setInventoryId(inventoryInfoAndBatchDO.getId());// 库存id
			inventoryLogDO.setItemId(inventoryInfoAndBatchDO.getItemId());// 商品id
			inventoryLogDO.setDocId(itemInventoryProcesssParameter.getSourceOrderId());// 单据id
			inventoryLogDO.setDocType(itemInventoryProcesssParameter.getSourceOrderType());// 单据类型为销售子订单
			inventoryLogDO.setRealInvent(inventoryInfoAndBatchDO.getRealInvent());// 原来的实物库存
			inventoryLogDO.setAvailableInvent(inventoryInfoAndBatchDO.getAvailableInvent());// 原来的可用库存

			InventoryOccupancyDO inventoryOccupancyDO = new InventoryOccupancyDO();// 库存占用表
			inventoryOccupancyDO.setOccupancyOrderId(itemInventoryProcesssParameter.getSourceOrderId());
			inventoryOccupancyDO.setOccupancyOrderType(itemInventoryProcesssParameter.getSourceOrderType());
			inventoryOccupancyDO.setWarehouseCode(itemInventoryProcesssParameter.getWarehouseCode());
			inventoryOccupancyDO.setWarehouseId(itemInventoryProcesssParameter.getWarehouseId());
			inventoryOccupancyDO.setOwnerId(inventoryInfoAndBatchDO.getOwnerId());
			inventoryOccupancyDO.setItemId(inventoryInfoAndBatchDO.getItemId());
			inventoryOccupancyDO.setCabinetId(inventoryInfoAndBatchDO.getCabinetId());
			inventoryOccupancyDO.setInventoryBatchId(inventoryInfoAndBatchDO.getItemBatchId());
			inventoryOccupancyDO.setWaveId(itemInventoryProcesssParameter.getWaveId());// 波次id
			inventoryOccupancyDO.setInventoryInfoId(inventoryInfoAndBatchDO.getId()); // 设置库存id
			inventoryOccupancyDO.setInventoryOperateMode(itemInventoryProcesssParameter.getOccupyOrDedution());//库存操作方式，扣减还是占用

			if (inventoryInfoAndBatchDO.getAvailableInvent() >= itemRemainCount) {
				if (itemInventoryProcesssParameter.getOccupyOrDedution() == InventoryOperateModeEnum.OCCUPY.getIndex()) { // 线上的操作占用库存
					inventoryInfoDO.setAvailableInvent(0 - itemRemainCount); // 可用库存-itemRemainCount
					inventoryInfoDO.setOrderOccupy(itemRemainCount);// 订单占用+itemRemainCount
					inventoryLogDO.setInventoryOccupy(itemRemainCount);
					inventoryLogDO.setAvailableInventUpdated(inventoryInfoAndBatchDO.getAvailableInvent() - itemRemainCount);
					inventoryOccupancyDO.setOccupancyQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), itemRemainCount,
							itemInventoryProcesssParameter.getWarehouseId(), false));
				} else {
					inventoryInfoDO.setAvailableInvent(0 - itemRemainCount); // 可用库存-itemRemainCount
					inventoryInfoDO.setRealInvent(0 - itemRemainCount); // 批发和线下实物库存减少
					inventoryLogDO.setChangeAccount(itemRemainCount);
					inventoryLogDO.setRealInventUpdated(inventoryInfoAndBatchDO.getRealInvent() - itemRemainCount);
					inventoryLogDO.setAvailableInventUpdated(inventoryInfoAndBatchDO.getAvailableInvent() - itemRemainCount);
					inventoryOccupancyDO.setActualQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), itemRemainCount,
							itemInventoryProcesssParameter.getWarehouseId(), false));//扣减情况 改变库存操作表的实操,实操和占用一致
					inventoryOccupancyDO.setOccupancyQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), itemRemainCount,
							itemInventoryProcesssParameter.getWarehouseId(), false));
				}
				itemRemainCount = 0;// 剩余需要占用的库存为0
			} else {
				itemRemainCount = itemRemainCount - inventoryInfoAndBatchDO.getAvailableInvent();
				if (itemInventoryProcesssParameter.getOccupyOrDedution() == InventoryOperateModeEnum.OCCUPY.getIndex()) { // 线上的操作占用库存
					inventoryInfoDO.setAvailableInvent(0 - inventoryInfoAndBatchDO.getAvailableInvent()); // 可用库存变化量
					inventoryInfoDO.setOrderOccupy(inventoryInfoAndBatchDO.getAvailableInvent());// 订单占用变化量
					inventoryLogDO.setInventoryOccupy(inventoryInfoAndBatchDO.getAvailableInvent());
					inventoryLogDO.setAvailableInventUpdated(0L);
					inventoryOccupancyDO.setOccupancyQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(),
							itemInventoryProcesssParameter.getItemQuanity(), itemInventoryProcesssParameter.getWarehouseId(), false));
				} else {
					inventoryInfoDO.setAvailableInvent(0 - inventoryInfoAndBatchDO.getAvailableInvent()); // 可用库存变化量
					inventoryInfoDO.setRealInvent(0 - inventoryInfoAndBatchDO.getAvailableInvent()); // 实物库存变化量
					inventoryLogDO.setChangeAccount(inventoryInfoAndBatchDO.getAvailableInvent());
					inventoryLogDO.setAvailableInventUpdated(0L);
					inventoryLogDO.setRealInventUpdated(0L);
					inventoryOccupancyDO.setActualQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), inventoryInfoAndBatchDO.getAvailableInvent(),
							itemInventoryProcesssParameter.getWarehouseId(), false));//扣减情况 改变库存操作表的实操,实操和占用一致
					inventoryOccupancyDO.setOccupancyQuantity(commonService.quanityTransform(itemInventoryProcesssParameter.getItemId(), inventoryInfoAndBatchDO.getAvailableInvent(),
							itemInventoryProcesssParameter.getWarehouseId(), false));

				}
			}
			inventoryLogDO.setWarehouseCode(itemInventoryProcesssParameter.getWarehouseCode()); // 分表code
			inventoryLogDO.setInventoryId(inventoryInfoAndBatchDO.getId()); // 库存id
			itemOccupyDetails.add(inventoryOccupancyDO);// 库存占用记录
			inventoryInfoDAO.updateInventoryInfo(inventoryInfoDO);// 更新库存
			inventoryLogDAO.insertInventoryLog(inventoryLogDO);// 插入库存变化日志
		}
		if (itemRemainCount > 0){   //如果占用或者扣减失败
			if(itemInventoryProcesssParameter.getOccupyOrDedution() == InventoryOperateModeEnum.DEDUCTION.getIndex()||!itemInventoryProcesssParameter.isStockoutOccupy()){
				orderInventoryResult.setDetailOrderId(itemInventoryProcesssParameter.getSourceOrderId()); //占用失败子订单id
				orderInventoryResult.setSuccess(false);
				orderInventoryResult.setCauseType(InventoryResultFailCauseEnum.INVENTORY_OUTSTOCK.getIndex()); // 缺货
				return orderInventoryResult;
			}
		}
		for (InventoryOccupancyDO inventoryOccupancyDO : itemOccupyDetails) {// 插入库存占用表，对于扣减情况也需要插入库存占用表
			inventoryOccupancyDAO.insertInventoryOccupancyDO(inventoryOccupancyDO);// 插入库存占用表
		}
		inventoryInfoQuery.setStatus(0); // 释放锁
		inventoryInfoDAO.updateInventoryInfoStatusByCabinetType(inventoryInfoQuery);// 释放锁
		orderInventoryResult.setSuccess(true);
		return orderInventoryResult;
	}
	/*
	 * 判断一个主订单是否已经处理过，主要用于人工任务判断的依据
	 */
	private boolean checkHaveProcess(List<SalesOrderDetailDO> salesOrderDetailDOs, long warehouseId, long waveId) {
		List<Long> salesOrderDetailIds = Lists.newArrayList(); // 销售子订单ids
		for (SalesOrderDetailDO salesOrderDetailDO : salesOrderDetailDOs) { // 封装销售子订单ids
			salesOrderDetailIds.add(salesOrderDetailDO.getId());
    	}
		List<InventoryOccupancyDO> inventoryOccupancyDOs = inventoryOccupancyDAO.queryByOccupancyOrderId(warehouseId,
				warehouseDAO.queryWarehouseCodeById(warehouseId), waveId, SourceTypeEnum.SALES_ORDER_DETAIL.getIndex(), salesOrderDetailIds);
		if (CollectionUtils.isNotEmpty(inventoryOccupancyDOs)) {
			return true;
		}
    	return false;
    }
	public void setInventoryInfoDAO(InventoryInfoDAO inventoryInfoDAO) {
		this.inventoryInfoDAO = inventoryInfoDAO;
	}

	public void setInventoryLogDAO(InventoryLogDAO inventoryLogDAO) {
		this.inventoryLogDAO = inventoryLogDAO;
	}

	public void setCabinetDAO(CabinetDAO cabinetDAO) {
		this.cabinetDAO = cabinetDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setSalesOrderDetailDAO(SalesOrderDetailDAO salesOrderDetailDAO) {
		this.salesOrderDetailDAO = salesOrderDetailDAO;
	}

	public void setSortingGoodsPartitionCabinetDAO(SortingGoodsPartitionCabinetDAO sortingGoodsPartitionCabinetDAO) {
		this.sortingGoodsPartitionCabinetDAO = sortingGoodsPartitionCabinetDAO;
	}

	public void setPickingOrderDAO(PickingOrderDAO pickingOrderDAO) {
		this.pickingOrderDAO = pickingOrderDAO;
	}

	public void setWaveOrderDAO(WaveOrderDAO waveOrderDAO) {
		this.waveOrderDAO = waveOrderDAO;
	}

	public void setPickingOrderDetailDAO(PickingOrderDetailDAO pickingOrderDetailDAO) {
		this.pickingOrderDetailDAO = pickingOrderDetailDAO;
	}

	public void setSortingGoodsPartitionDAO(SortingGoodsPartitionDAO sortingGoodsPartitionDAO) {
		this.sortingGoodsPartitionDAO = sortingGoodsPartitionDAO;
	}

	public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
		this.warehouseDAO = warehouseDAO;
	}

	public void setBatchOrderDAO(BatchOrderDAO batchOrderDAO) {
		this.batchOrderDAO = batchOrderDAO;
	}

	public void setInventoryOccupancyDAO(InventoryOccupancyDAO inventoryOccupancyDAO) {
		this.inventoryOccupancyDAO = inventoryOccupancyDAO;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

}
