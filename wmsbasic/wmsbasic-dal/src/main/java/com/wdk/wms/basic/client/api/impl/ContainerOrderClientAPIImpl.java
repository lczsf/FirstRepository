package com.wdk.wms.basic.client.api.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.wdk.wms.basic.common.WdkWmsSerialNumberUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.ContainerOrderClientAPI;
import com.wdk.wms.basic.dal.dao.ArrivalNoticeDAO;
import com.wdk.wms.basic.dal.dao.ArrivalNoticeDetailDAO;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.ContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.ContainerOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.InventoryBatchDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDetailDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDetailDO;
import com.wdk.wms.basic.daoobject.InventoryBatchDO;
import com.wdk.wms.basic.query.parameters.ContainerOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class ContainerOrderClientAPIImpl implements ContainerOrderClientAPI {

	@Autowired
	private ContainerOrderDAO containerOrderDAO;
	@Autowired
	private ContainerOrderDetailDAO containerOrderDetailDAO;
	@Autowired
	private InventoryBatchDAO inventoryBatchDAO;
	@Autowired
	private ArrivalNoticeDAO arrivalNoticeDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private CabinetDAO cabinetDAO;
	@Autowired
	private ArrivalNoticeDetailDAO arrivalNoticeDetailDAO;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private WdkWmsSerialNumberUtil wdkWmsSerialNumberUtil;

	@Override
	public long insertContainerOrder(ContainerOrderDO containerOrderDO) {
		return containerOrderDAO.insertContainerOrder(containerOrderDO);
	}

	@Override
	public PageResult<ContainerOrderDO> queryContainerOrder(ContainerOrderQuery containerOrderQuery) {
		PageResult<ContainerOrderDO> pageResult = new PageResult<ContainerOrderDO>();
		containerOrderQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(containerOrderQuery.getWarehouseId())); // 查询分表code
		List<ContainerOrderDO> containerOrderDOs = containerOrderDAO.queryContainerOrder(containerOrderQuery);
		Integer count = containerOrderDAO.queryContainerCount(containerOrderQuery);
		// 封装分页信息
		pageResult.setIndex(containerOrderQuery.getIndex());
		pageResult.setTotalNum(count);
		pageResult.setList(containerOrderDOs);
		return pageResult;
	}

	@Override
	public long insertContainerOrderDetail(ContainerOrderDetailDO containerOrderDetailDO) {
		return containerOrderDetailDAO.insertContainerOrderDetail(containerOrderDetailDO);
	}

	@Override
	public List<ContainerOrderDetailDO> queryContainerOrderDetail(long containerOrderId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDetailDAO.queryContainerOrderDetail(containerOrderId, warehouseCode);
	}

	@Override
	public ContainerOrderDO queryByWarehouseIdAndCode(String containerCode, int status, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDAO.queryByWarehouseIdAndCode(containerCode, status, warehouseId, warehouseCode);
	}

	@Override
	public ContainerOrderDetailDO queryByOrderIdAndItemCode(Long containerOrderId, String itemCode, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDetailDAO.queryByOrderIdAndItemCode(containerOrderId, itemCode, warehouseCode);
	}

	@Override
	public ContainerOrderDO queryById(Long id, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDAO.queryById(id, warehouseId, warehouseCode);
	}

	@Override
	public ContainerOrderDetailDO queryDetailById(Long id, long containerOrderId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDetailDAO.queryById(id, containerOrderId, warehouseCode);
	}

	@Override
	public Boolean checkItemBatch(Long asnId, String containerCode, String itemCode, Long batchId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId); // 仓库分表code
		// 获取庄装箱单
		ContainerOrderDO containerOrderDO = containerOrderDAO.queryByAsnIdAndCode(asnId, containerCode, warehouseId, warehouseCode);
		if (containerOrderDO != null) { // 判断是否有装箱单
			// 校验商品批次
			ContainerOrderDetailDO containerOrderDetailDO = containerOrderDetailDAO.queryCountBatch(containerOrderDO.getId(), itemCode, warehouseCode);
			if (containerOrderDetailDO == null || containerOrderDetailDO.getItemBatchId().equals(batchId)) { // 为空 或 批次相同
				return false; // 可以插入
			} else {
				return true; // 不可以插入
			}
		}
		return false;
	}

	@Override
	public Long generateBatchId(Date produceDate, Date arriveDate) {
		// 通过生成日期和到货日期获得批次
		InventoryBatchDO inventoryBatchDO = inventoryBatchDAO.queryInventoryBatchDO(produceDate, arriveDate);
		if (inventoryBatchDO != null) { // 判断是否存在此批次 存在直接返回 不存在新建批次
			return inventoryBatchDO.getId();
		} else {
			InventoryBatchDO batchDO = new InventoryBatchDO();
			batchDO.setProduceDate(produceDate);
			batchDO.setArriveDate(arriveDate);
			return inventoryBatchDAO.insertInventoryBatch(batchDO);
		}
	}

	@Override
	public ContainerOrderDO queryByAsnIdAndCode(Long asnId, String containerCode, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDAO.queryByAsnIdAndCode(asnId, containerCode, warehouseId, warehouseCode);
	}

	@Override
	public Long generateContainerOrder(Long asnId, Boolean isRF, String containerCode, Long operatorId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId); // 仓库分表code
		// 查询到货通知单
		ArrivalNoticeDO arrivalNoticeDO = arrivalNoticeDAO.queryById(asnId, warehouseId);
		if (arrivalNoticeDO == null) { // 无收货单
			return 0L;
		}
		// 组装装箱单数据
		ContainerOrderDO containerOrderDO = new ContainerOrderDO();
		containerOrderDO.setAsnId(asnId);// 通知单id
		containerOrderDO.setWarehouseId(arrivalNoticeDO.getWarehouseId());// 收货仓库
		containerOrderDO.setWarehouseCode(warehouseCode); // 分表code
		containerOrderDO.setSupplierId(arrivalNoticeDO.getSupplierId());// 供应商编号
		containerOrderDO.setIsRf(isRF == true ? 1 : 0);// 是否RF收货 0 false 1 true
		containerOrderDO.setCode(wdkWmsSerialNumberUtil.createCode(arrivalNoticeDO.getWarehouseId(), "ZX", "ZXD"));// 收货装箱号
		containerOrderDO.setContainerCode(containerCode); // 容器编号
		containerOrderDO.setOwnerId(arrivalNoticeDO.getOwnerId()); // 货主id
		containerOrderDO.setOperationId(operatorId);// 操作人
		containerOrderDO.setResponsibleId(operatorId); // 收货人
		containerOrderDO.setOwnerId(arrivalNoticeDO.getOwnerId()); // 货主ID
		containerOrderDO.setBizOrderCode(arrivalNoticeDO.getBizOrderCode());// 业务单号 外部单号
		long containerOrderId = containerOrderDAO.insertContainerOrder(containerOrderDO); // TODO 操作人无法插入
		return containerOrderId;
	}

	@Override
	public int updateOrderStatus(Long id, int status, Long operatorId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDAO.updateOrderStatus(id, status, operatorId, warehouseId, warehouseCode);
	}

	@Override
	public Long generateContainerOrderData(Long orderId, String itemCode, Long itemBatchId, double packageQuantity, Long operatorId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId); // 分表code
		// 更新操作人
		containerOrderDAO.updateOperatorId(orderId, operatorId, warehouseId, warehouseCode);
		final ContainerOrderDetailDO containerOrderDetailDO = new ContainerOrderDetailDO();

		ContainerOrderDetailDO orderDetailDO = containerOrderDetailDAO.queryByOrderIdAndItemCode(orderId, itemCode, warehouseCode);
		if (orderDetailDO != null) { // 判断是否已有该装箱单和商品的记录 有责累加实收件数
			double actualPackageQuantity = BigDecimal.valueOf(orderDetailDO.getActualPackageQuantity()).add(BigDecimal.valueOf(packageQuantity)).doubleValue();
			orderDetailDO.setActualPackageQuantity(actualPackageQuantity); // 累加收货
			return getContainerOrderDetailId(packageQuantity, orderDetailDO, orderId, warehouseId, warehouseCode, itemCode);
		}
		// 通过商品code 获取
		BasicItemDO basicItemDO = itemDAO.queryByCode(itemCode);
		if (basicItemDO == null) {
			return 0L;
		}
		// 组装数据
		containerOrderDetailDO.setWarehouseCode(warehouseCode); // 分表code
		containerOrderDetailDO.setContainerOrderId(orderId); // 装箱单id
		containerOrderDetailDO.setItemId(basicItemDO.getId()); // 商品id
		containerOrderDetailDO.setItemCode(itemCode); // 商品编码
		containerOrderDetailDO.setPrice(basicItemDO.getPrice()); // 价格
		containerOrderDetailDO.setItemBatchId(itemBatchId); // 商品批次
		containerOrderDetailDO.setUnit(basicItemDO.getPurchaseUnit()); // 单位
		containerOrderDetailDO.setSpec(basicItemDO.getSpecification()); // 规格
		containerOrderDetailDO.setActualPackageQuantity(packageQuantity); // 实收件数

		return getContainerOrderDetailId(packageQuantity, containerOrderDetailDO, orderId, warehouseId, warehouseCode, itemCode);
	}

	/**
	 * 事务 创建装箱单明细
	 * 
	 * @param packageQuantity
	 *            单次收货件数
	 * @param containerOrderDetailDO
	 *            装箱单明细
	 * @param containerOrderId
	 *            装箱单id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param itemCode
	 *            商品code
	 * @return
	 */
	private long getContainerOrderDetailId(final double packageQuantity, final ContainerOrderDetailDO containerOrderDetailDO, final Long containerOrderId,
			final Long warehouseId, final Long warehouseCode, final String itemCode) {
		return (long) (Long) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {

				// 获取装箱单 拿到到货通知单id
				ContainerOrderDO containerOrderDO = containerOrderDAO.queryById(containerOrderId, warehouseId, warehouseCode);
				// 获取到货通知单
				final ArrivalNoticeDetailDO arrivalNoticeDetailDO = arrivalNoticeDetailDAO.queryByIdAndItemCode(containerOrderDO.getAsnId(), itemCode,
						warehouseCode);
				try {
					Long id = 0L;
					// 创建装箱单
					if (containerOrderDetailDO.getId() == null) { // 新增的时候 id为空
						id = containerOrderDetailDAO.insertContainerOrderDetail(containerOrderDetailDO);
					} else {
						containerOrderDetailDAO.updateOrderDetail(containerOrderDetailDO); // 更新实收件数
						id = containerOrderDetailDO.getId();
					}
					int count = updateOrderDetail(arrivalNoticeDetailDO, packageQuantity);
					if (count != 0) {
						return id;
					}
					return 0L;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					e.printStackTrace();
					return 0L;
				}
			}
		});
	}

	@Override
	public int updateStatusAndAssociatCabinet(Long asnId, String containerCode, Long operatorId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		// 获取默认库位
		long cabinetId = cabinetDAO.queryDefaultCabinetId();
		return containerOrderDAO.updateStatusAndAssociatCabinet(asnId, containerCode, cabinetId, operatorId, warehouseId, warehouseCode);
	}

	@Override
	public Boolean checkStatusByAsnId(Long asnId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId); // 分表code
		List<ContainerOrderDO> containerOrderDOs = containerOrderDAO.queryByAsnId(asnId, warehouseId, warehouseCode);
		for (ContainerOrderDO containerOrderDO : containerOrderDOs) {
			if (containerOrderDO.getStatus() != 2) { // 判断装箱单状态是否为暂存(2)
				return false;
			}
		}
		return true;
	}

	@Override
	public ContainerOrderDetailDO queryByOrderIdAndItemId(Long orderId, Long itemId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return containerOrderDetailDAO.queryByOrderIdAndItemId(orderId, itemId, warehouseCode);
	}

	@Override
	public int deleteById(final Long orderDetailId, final Long warehouseId, final Long containerOrderId) {
		final Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		// 获取装箱单明细
		final ContainerOrderDetailDO containerOrderDetailDO = containerOrderDetailDAO.queryById(orderDetailId, containerOrderId, warehouseCode);
		Integer count = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {
					int count = containerOrderDetailDAO.deleteById(orderDetailId, containerOrderId, warehouseCode); // 删除装箱单明细
					if (count == 1) {// 删除成功 更新到货通知单明细
						ContainerOrderDO containerOrderDO = containerOrderDAO.queryById(containerOrderDetailDO.getContainerOrderId(), warehouseId,
								warehouseCode); // 获取装箱单id
						ArrivalNoticeDetailDO arrivalNoticeDetailDO = arrivalNoticeDetailDAO.queryByIdAndItemCode(containerOrderDO.getAsnId(),
								containerOrderDetailDO.getItemCode(), warehouseCode); // 获取到货通知单
						// 更新实收件数
						double actualPackageQuantity = BigDecimal.valueOf(arrivalNoticeDetailDO.getActualPackageQuantity())
								.subtract(BigDecimal.valueOf(containerOrderDetailDO.getActualPackageQuantity())).doubleValue();
						arrivalNoticeDetailDO.setActualPackageQuantity(actualPackageQuantity);
						arrivalNoticeDetailDO.setGmtModified(new Date());
						arrivalNoticeDetailDAO.updateArrivalNoticeDetail(arrivalNoticeDetailDO);
						return count;
					}
					return 0;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					e.printStackTrace();
					return 0;
				}
			}
		});
		return count;
	}

	@Override
	public List<ContainerOrderDetailDO> queryArrivalReceivedDetail(Long asnId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		List<ContainerOrderDetailDO> containerOrderDetailDOs = new ArrayList<ContainerOrderDetailDO>();
		List<ContainerOrderDO> containerOrderDOs = containerOrderDAO.queryByAsnId(asnId, warehouseId, warehouseCode); // 获取所有装箱
		for (ContainerOrderDO containerOrderDO : containerOrderDOs) { // 获取所有明细
			// 装箱单下所有明细
			List<ContainerOrderDetailDO> list = containerOrderDetailDAO.queryContainerOrderDetail(containerOrderDO.getId(), warehouseCode);
			for (ContainerOrderDetailDO containerOrderDetailDO : list) {
				if (containerOrderDetailDO.getActualPackageQuantity() > 0) { // 判断是否已有实际收货件数
					containerOrderDetailDOs.add(containerOrderDetailDO);
				}
			}
		}
		// 获取装箱明细
		return containerOrderDetailDOs;
	}

	@Override
	public int updateOperatorId(Long id, Long operationId, Long warehouseId) {
		return containerOrderDAO.updateOperatorId(id, operationId, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	/**
	 * 更新到货通知单实际收货数量
	 *
	 * @param arrivalNoticeDetailDO
	 * @param quantity
	 *            需要累加的数量
	 * @return
	 */
	private int updateOrderDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO, Double quantity) {
		// 更新实收件数
		double actualPackageQuantity = BigDecimal.valueOf(arrivalNoticeDetailDO.getActualPackageQuantity()).add(BigDecimal.valueOf(quantity)).doubleValue();
		arrivalNoticeDetailDO.setActualPackageQuantity(actualPackageQuantity);
		arrivalNoticeDetailDO.setGmtModified(new Date());
		return arrivalNoticeDetailDAO.updateArrivalNoticeDetail(arrivalNoticeDetailDO);
	}

	@Override
	public ContainerOrderDO queryByAsnIdAndCodeNotComplete(Long asnId, String containerCode, Long warehouseId) {
		return containerOrderDAO.queryByAsnIdAndCodeNotComplete(asnId, containerCode, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}
}
