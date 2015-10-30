package com.wdk.wms.basic.client.api.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.OrderClientAPI;
import com.wdk.wms.basic.common.Constants;
import com.wdk.wms.basic.common.WdkWmsSerialNumberUtil;
import com.wdk.wms.basic.dal.dao.ArrivalNoticeDAO;
import com.wdk.wms.basic.dal.dao.ArrivalNoticeDetailDAO;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.ContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.ContainerOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.InventoryBatchDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.PutawayOrderDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDetailDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDetailDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDO;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.enums.PutawayTypeEnum;
import com.wdk.wms.basic.enums.SourceTypeEnum;

public class OrderClientAPIImpl implements OrderClientAPI {

	@Autowired
	private ContainerOrderDAO containerOrderDAO;
	@Autowired
	private ContainerDAO containerDAO;
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
	private PutawayOrderDAO putawayOrderDAO;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private WdkWmsSerialNumberUtil wdkWmsSerialNumberUtil;

	@Override
	public Integer doSubmitItem(final boolean isRf, final Long orderId, final String containerCode, final Long uid, final Long wid, final String itemCode,
			final double numeric, final int containerStatus, final Long batchId) {
		return (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {
					Long warehouseCode = warehouseDAO.queryWarehouseCodeById(wid);// step22
					ContainerOrderDO containerOrder = containerOrderDAO.queryByAsnIdAndCode(orderId, containerCode, wid, warehouseCode);

					long containerOrderId;
					if (containerOrder == null) {
						containerOrderId = generateContainerOrder(orderId, isRf, containerCode, uid, wid);
					} else {
						containerOrderId = containerOrder.getId();
					}

					generateContainerOrderData(containerOrderId, itemCode, batchId, numeric, uid, wid);// step24

					if (containerStatus == ContainerStatusEnum.Free.getIndex()) {// step 25
						updateStatusByContainerCode(wid, containerCode, ContainerStatusEnum.Occupy.getIndex(), uid);
					}
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					return Constants.TRANSACTION_FAIL;
				}
				return Constants.TRANSACTION_SUCC;
			}
		});
	}

	private boolean updateStatusByContainerCode(long warehouseId, String containerCode, int status, long operatorId) {
		if (containerDAO.updateStatusByContainerCode(warehouseId, containerCode, status, operatorId) != 0)
			return true;
		return false;
	}

	/**
	 * 创建装箱单
	 */
	private Long generateContainerOrder(Long asnId, Boolean isRF, String containerCode, Long operatorId, Long warehouseId) {
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
		return containerOrderDAO.insertContainerOrder(containerOrderDO);
	}

	/**
	 * 创建装箱单明细 并更新 到货通知单 实收数量和实收件数
	 */
	private Long generateContainerOrderData(Long containerOrderId, String itemCode, Long itemBatchId, double packageQuantity, Long operatorId, Long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId); // 分表code
		containerOrderDAO.updateOperatorId(containerOrderId, operatorId, warehouseId, warehouseCode);// 更新操作人
		ContainerOrderDetailDO containerOrderDetailDO = new ContainerOrderDetailDO();

		ContainerOrderDetailDO orderDetailDO = containerOrderDetailDAO.queryByOrderIdAndItemCode(containerOrderId, itemCode, warehouseCode);
		if (orderDetailDO != null) { // 判断是否已有该装箱单和商品的记录 有责累加实收件数
			orderDetailDO.setActualPackageQuantity(orderDetailDO.getActualPackageQuantity() + packageQuantity); // 累加收货
			return getContainerOrderDetailId(packageQuantity, orderDetailDO, containerOrderId, warehouseId, warehouseCode, itemCode);
		}

		BasicItemDO basicItemDO = itemDAO.queryByCode(itemCode);// 通过商品code 获取
		if (basicItemDO == null) {
			return 0L;
		}

		containerOrderDetailDO.setWarehouseCode(warehouseCode); // 分表code
		containerOrderDetailDO.setContainerOrderId(containerOrderId); // 装箱单id
		containerOrderDetailDO.setItemId(basicItemDO.getId()); // 商品id
		containerOrderDetailDO.setItemCode(itemCode); // 商品编码
		containerOrderDetailDO.setPrice(basicItemDO.getPrice()); // 价格
		containerOrderDetailDO.setItemBatchId(itemBatchId); // 商品批次
		containerOrderDetailDO.setUnit(basicItemDO.getPurchaseUnit()); // 单位
		containerOrderDetailDO.setSpec(basicItemDO.getSpecification()); // 规格
		containerOrderDetailDO.setActualPackageQuantity(packageQuantity); // 实收件数

		return getContainerOrderDetailId(packageQuantity, containerOrderDetailDO, containerOrderId, warehouseId, warehouseCode, itemCode);
	}

	/**
	 * 事务 创建装箱单明细
	 */
	private long getContainerOrderDetailId(final double packageQuantity, final ContainerOrderDetailDO containerOrderDetailDO, final Long containerOrderId,
			final Long warehouseId, final Long warehouseCode, final String itemCode) {
		return (long) (Long) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {

				ContainerOrderDO containerOrderDO = containerOrderDAO.queryById(containerOrderId, warehouseId, warehouseCode);// 获取装箱单 拿到到货通知单id
				ArrivalNoticeDetailDO arrivalNoticeDetailDO = arrivalNoticeDetailDAO.queryByIdAndItemCode(containerOrderDO.getAsnId(), itemCode, warehouseCode);// 获取到货通知单
				try {
					Long id = 0L;

					if (containerOrderDetailDO.getId() == null) { // 创建装箱单 & 新增的时候 id为空
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

	/**
	 * 更新到货通知单实际收货数量
	 */
	private int updateOrderDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO, Double quantity) {

		arrivalNoticeDetailDO.setActualPackageQuantity(arrivalNoticeDetailDO.getActualPackageQuantity() + quantity);// 更新实收件数
		arrivalNoticeDetailDO.setGmtModified(new Date());
		return arrivalNoticeDetailDAO.updateArrivalNoticeDetail(arrivalNoticeDetailDO);
	}

	@Override
	public Integer doChangeContainer(final String token, final String containerCode, final Long orderId, final long uid, final long wid) {

		return (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try {
					updateStatusAndAssociatCabinet(orderId, containerCode, uid, wid);// step 9

					insertPutawayOrderByArguments(SourceTypeEnum.CONTAINER_ORDER.getIndex(), orderId, containerCode, 1, uid,
							PutawayTypeEnum.RECEIVE.getIndex(), wid);
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					return Constants.TRANSACTION_FAIL;
				}
				return Constants.TRANSACTION_SUCC;
			}
		});
	}

	/**
	 * 通过 通知单id和容器编码 将装箱单状态改为 ”暂存“ 并关联默认库位
	 */
	private int updateStatusAndAssociatCabinet(Long asnId, String containerCode, Long operatorId, Long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		long cabinetId = cabinetDAO.queryDefaultCabinetId();// 获取默认库位

		return containerOrderDAO.updateStatusAndAssociatCabinet(asnId, containerCode, cabinetId, operatorId, warehouseId, warehouseCode);
	}

	private long insertPutawayOrderByArguments(int sourceType, long orderId, String containerCode, int isRf, Long operatorId, int type, Long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		ArrivalNoticeDO arrivalNoticeDO = arrivalNoticeDAO.queryById(orderId, warehouseId);// 查询到货通知单信息
		PutawayOrderDO putawayOrderDO = new PutawayOrderDO();// 设置上架单信息

		putawayOrderDO.setCode(wdkWmsSerialNumberUtil.createCode(warehouseId, "SJ", "SJD"));// 上架单code
		putawayOrderDO.setWarehouseCode(warehouseCode); // 分表code
		putawayOrderDO.setSourceType(sourceType);// 来源类型
		putawayOrderDO.setSourceOrderId(orderId);// 来源单据id
		putawayOrderDO.setWarehouseId(arrivalNoticeDO.getWarehouseId());// 仓库id
		putawayOrderDO.setOwnerId(arrivalNoticeDO.getOwnerId());// 货主id
		putawayOrderDO.setPutawayerId(null);// 上架人id
		putawayOrderDO.setOperatorId(operatorId);
		putawayOrderDO.setContainerCode(containerCode);// 容器code
		putawayOrderDO.setType(type);// 上架类型
		putawayOrderDO.setSourceOrderCode(arrivalNoticeDO.getAsnCode());// 来源单据code

		return putawayOrderDAO.insertPutawayOrder(putawayOrderDO);

	}
}
