package com.wdk.wms.basic.client.api.impl;

import java.math.BigDecimal;
import java.util.List;

import com.wdk.wms.basic.common.CommonService;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.groovy.util.Finalizable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.OnshelfClientAPI;
import com.wdk.wms.basic.dal.dao.BackContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.BackOrderDAO;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.ContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.DiffOrderDAO;
import com.wdk.wms.basic.dal.dao.DiffOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.InventoryInfoDAO;
import com.wdk.wms.basic.dal.dao.InventoryLogDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.PutawayOrderDAO;
import com.wdk.wms.basic.dal.dao.PutawayOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.daoobject.BackOrderDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.ContainerOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.basic.daoobject.InventoryLogDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDetailDO;
import com.wdk.wms.basic.enums.BackContainerOrderStatusEnum;
import com.wdk.wms.basic.enums.ContainerOrderStatusEnum;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.enums.DifferOrderStatusEnum;
import com.wdk.wms.basic.enums.PutawayOrderStatusEnum;
import com.wdk.wms.basic.enums.SourceTypeEnum;
import com.wdk.wms.basic.result.InventoryProcessResult;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;
import com.wdk.wms.inventory.parameters.OnShelfUpateParameter;
import com.wdk.wms.inventory.service.InventoryProcessService;
import com.wdk.wms.inventory.service.VirtualOnshelf;

import sun.tools.tree.FinallyStatement;

public class OnShelfClientAPIImpl implements OnshelfClientAPI {

	@Autowired
	private PutawayOrderDAO putawayOrderDAO;

	@Autowired
	private ContainerOrderDAO containerOrderDAO;
	@Autowired
	private PutawayOrderDetailDAO putawayOrderDetailDAO;
	@Autowired
	private DiffOrderDAO diffOrderDAO;
	@Autowired
	private DiffOrderDetailDAO diffOrderDetailDAO;
	@Autowired
	private ContainerDAO containerDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private CommonService commonService;
	@Autowired
	private InventoryProcessService inventoryProcessService;
	@Autowired
	private VirtualOnshelf virtualOnshelf;
	@Autowired
	private TransactionTemplate transactionTemplate;
	private final Logger log = LoggerFactory.getLogger(OnShelfClientAPIImpl.class);

	@SuppressWarnings("unchecked")
	public InventoryProcessResult<Integer> OnShelf(final PutawayOrderDetailDO putawayOrderDetailDO) {
		InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();// 返回结果
		final long warehouseCode = putawayOrderDetailDO.getWarehouseCode();// 仓库分表code
		final long warehouseId = warehouseDAO.queryIdByWarehouseCode(warehouseCode);// 根据仓库分表code获取仓库id
		PutawayOrderDO putawayOrderDO = putawayOrderDAO.queryPutawayOrderById(putawayOrderDetailDO.getPutawayOrderId(),
				warehouseId, warehouseCode);// 查到上架主记录，用于获取货主id和仓库id
		long ownerId = putawayOrderDO.getOwnerId();// 货主id
		long itemId = putawayOrderDetailDO.getItemId();// 商品id
		long itemBatchId = putawayOrderDetailDO.getItemBatchId();// 商品批次
		long cabinetId = putawayOrderDetailDO.getActualCabinetId();// 上架库位id
		final InventoryInfoQuery inventoryInfoQuery = inventoryProcessService.generateInventoryInfoQuery(warehouseId, warehouseCode, itemId,
				ownerId, itemBatchId);// 库存查询条件
		final InventoryInfoDO inventoryInfoDO = inventoryProcessService.generateInventoryInfoDO(warehouseId, warehouseCode, itemId, ownerId,
				itemBatchId, cabinetId);// 库存信息
		BigDecimal actualPackageQuantity = BigDecimal.valueOf(putawayOrderDetailDO.getActualPackageQuantity()); // 销售数量转换格式
		BigDecimal spec = BigDecimal.valueOf(putawayOrderDetailDO.getSpec()); // 规格转换格式
		double sellQuanity = actualPackageQuantity.multiply(spec).doubleValue();// 销售数量=采购数量*规格
		double quantity = commonService.quanityTransform(putawayOrderDetailDO.getItemId(), sellQuanity, warehouseId,
				true);// 转换后的库存数量
		if (quantity != (int) quantity) // 库存数量为小数
		{
			inventoryProcessResult.setStatus(-1);// 库存为小数，抛出异常
			return inventoryProcessResult;// 直接返回
		}
		final double inventoryQuantity = quantity;// 事务中需要final限制
		inventoryInfoDO.setRealInvent((long) inventoryQuantity);// 实物库存
		inventoryInfoDO.setAvailableInvent((long) inventoryQuantity);// 可用库存
		final InventoryLogDO inventoryLogDO = inventoryProcessService.generateInventoryLogDO(warehouseCode, itemId,
 putawayOrderDetailDO.getItemId(),
				SourceTypeEnum.PUTAWAY_ORDER.getIndex());
		inventoryProcessResult = (InventoryProcessResult<Integer>) transactionTemplate
				.execute(new TransactionCallback<Object>() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();
						try {
							PutawayOrderDetailDO alreadyPutawayOrderDetailDO = putawayOrderDetailDAO
									.queryByPutawayOrderIdAndItemCodeAndCabinetId(
											putawayOrderDetailDO.getPutawayOrderId(),
											putawayOrderDetailDO.getItemCode(),
											putawayOrderDetailDO.getActualCabinetId(), warehouseCode);// 查询上架单中同一个商品同一个库位已有的明细
							if (alreadyPutawayOrderDetailDO == null) {
								putawayOrderDetailDAO.insertPutawayOrderDetail(putawayOrderDetailDO);// 如果不存在，则插入上架单明细到数据库中
							} else {// 如果存在，则更新实际上架数量
								putawayOrderDetailDAO.updateActualPackageQuantityById(
										alreadyPutawayOrderDetailDO.getActualPackageQuantity()
												+ putawayOrderDetailDO.getActualPackageQuantity(),
										alreadyPutawayOrderDetailDO.getId(),
										alreadyPutawayOrderDetailDO.getPutawayOrderId(),
										alreadyPutawayOrderDetailDO.getWarehouseCode());
							}
							inventoryProcessResult = inventoryProcessService.onshelfInventoryProcess(inventoryInfoQuery, inventoryInfoDO,
									inventoryQuantity, inventoryLogDO);
							return inventoryProcessResult;
						} catch (Exception e) {
							log.error("库存插入失败180：", e);
							inventoryProcessResult.setStatus(-2);// -2库存插入失败,-1代表库存小数点的错误
							status.setRollbackOnly();
							return inventoryProcessResult;
						}
					}
				});
		return inventoryProcessResult;
	}
	
	@Override
	public Boolean updateStatus(OnShelfUpateParameter onShelfUpateParameter) {
		final Long whId = onShelfUpateParameter.getWarehouseId();// 仓库编码
		final Long whCode = warehouseDAO.queryWarehouseCodeById(whId); // 仓库分表code
		final Long containerOrderId = onShelfUpateParameter.getContainerOrderId();
		final Long putawayOrderId = onShelfUpateParameter.getPutawayOrderId();
		final DiffOrderDO diffOrderDO = onShelfUpateParameter.getDiffOrderDO();
		final List<DiffOrderDetailDO> diffOrderDetailDOs = onShelfUpateParameter.getDiffOrderDetailDOs();
		boolean isSuccess = (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {

				try {
					if (CollectionUtils.isNotEmpty(diffOrderDetailDOs)) // 如果差异单为null，则说明上层调用过程中没有生成差异单，不对差异单进行操作，直接跳过
					{
						long diffOrderId = diffOrderDAO.insertDiffOrder(diffOrderDO);// 插入差异单
						for (DiffOrderDetailDO diffOrderDetailDO : diffOrderDetailDOs) {
							diffOrderDetailDO.setDiffOrderId(diffOrderId);
							diffOrderDetailDAO.insertDiffOrderDetail(diffOrderDetailDO);// 插入差异单明细
						}
						InventoryProcessResult<Integer> inventoryProcessResult= virtualOnshelf.diffOrderOnshelf(diffOrderId, whId, whCode);//差异单处理
						if(inventoryProcessResult.getStatus()!=1){
							status.setRollbackOnly();//如果差异单 上架失败
							log.error("差异单上架失败，差异单id为："+diffOrderId);
							return false;
						}
					}
					PutawayOrderDO putawayOrderDO = putawayOrderDAO.queryPutawayOrderById(putawayOrderId, whId, whCode);
					containerOrderDAO.updateOrderStatus(containerOrderId, ContainerOrderStatusEnum.FINISH.getIndex(),
							putawayOrderDO.getPutawayerId(), whId, whCode);// 更新装箱单状态为完成,操作人
					putawayOrderDAO.updatePutawayOrderStatusById(putawayOrderId,
							PutawayOrderStatusEnum.FINISH.getIndex(), whId, whCode);// 更新上架单状态为完成，不用更改操作人
					ContainerOrderDO containerOrderDO = containerOrderDAO.queryById(containerOrderId, whId, whCode);// 获取容器code
					String containerCode = containerOrderDO.getContainerCode();
					containerDAO.updateStatusByContainerCode(containerOrderDO.getWarehouseId(), containerCode,
							ContainerStatusEnum.Free.getIndex(), putawayOrderDO.getPutawayerId());// 释放容器
					return true;// 如果成功，则返回true

				} catch (Exception e) {
					log.error("系统异常，需要回滚224", e);
					status.setRollbackOnly();// 异常，需要回滚
					return false;
				}
			}
		});
		return isSuccess;
	}

	@SuppressWarnings("unchecked")
	@Override
	public InventoryProcessResult<Integer> ContainerOnShelf(final List<PutawayOrderDetailDO> putawayOrderDetailDOs,
			final Long operationId) {

		return (InventoryProcessResult<Integer>) transactionTemplate.execute(new TransactionCallback<Object>() { // 开启事务
			@Override
			public Object doInTransaction(TransactionStatus transactionStatus) {
				InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();
				try {
					if (putawayOrderDetailDOs.size() == 0) { // 判断集合是否为空
						return inventoryProcessResult;
					}
					for (PutawayOrderDetailDO putawayOrderDetailDO : putawayOrderDetailDOs) { // 处理库存

						inventoryProcessResult = OnShelf(putawayOrderDetailDO);// 单条明细处理
						int status = inventoryProcessResult.getStatus();
						if (status == 0 || status == -1 || status == -2) {
							transactionStatus.setRollbackOnly(); // 回滚
							return inventoryProcessResult;
						}
					}
					// 更新容器状态 更新上架单状态 更新装箱单状态
					PutawayOrderDetailDO putawayOrderDetailDO = putawayOrderDetailDOs.get(0);
					Long warehouseCode = putawayOrderDetailDO.getWarehouseCode(); // 分表code
					Long whId = warehouseDAO.queryIdByWarehouseCode(warehouseCode); // 仓库id
					int updateContainerOrderStatus = 0; // 更新装箱单条数
					int updatePutawayOrderStatus = putawayOrderDAO.updatePutawayOrderStatusById(
							putawayOrderDetailDO.getPutawayOrderId(), PutawayOrderStatusEnum.FINISH.getIndex(), whId,
							warehouseCode);// 更新上架单状态
					PutawayOrderDO putawayOrderDO = putawayOrderDAO
							.queryPutawayOrderById(putawayOrderDetailDO.getPutawayOrderId(), whId, warehouseCode); // 获取上架单主表
					String containerCode = putawayOrderDO.getContainerCode();// 容器code
					ContainerOrderDO containerOrderDO = containerOrderDAO.queryByWarehouseIdAndCode(containerCode,
							ContainerOrderStatusEnum.TEMORARY.getIndex(), whId, warehouseCode);
					updateContainerOrderStatus = containerOrderDAO.updateOrderStatus(containerOrderDO.getId(),
							ContainerOrderStatusEnum.FINISH.getIndex(), operationId, whId, warehouseCode); // 更新装箱单状态
					int updateContainerStatus = containerDAO.updateStatusByContainerCode(whId,
							putawayOrderDO.getContainerCode(), ContainerStatusEnum.Free.getIndex(), operationId);

					if (updatePutawayOrderStatus != 1 && updateContainerOrderStatus != 1
							&& updateContainerStatus != 1) {
						transactionStatus.setRollbackOnly(); // 更新状态出错回滚
						inventoryProcessResult.setStatus(-3); // 更新状态出错
					}
					return inventoryProcessResult;
				} catch (Exception e) {
					transactionStatus.setRollbackOnly(); // 回滚
					log.error("容器上架异常", e);
					inventoryProcessResult.setStatus(-2);
					return inventoryProcessResult;
				}
			}
		});
	}

	@Override
	public InventoryProcessResult<Integer> backOrderOnShelf(long waveId, long warehouseId, long warehouseCode) {
		return virtualOnshelf.backOrderOnShelf(waveId, warehouseId, warehouseCode);//直接调用方法
	}
	public void setPutawayOrderDAO(PutawayOrderDAO putawayOrderDAO) {
		this.putawayOrderDAO = putawayOrderDAO;
	}

	public void setContainerOrderDAO(ContainerOrderDAO containerOrderDAO) {
		this.containerOrderDAO = containerOrderDAO;
	}

	public void setPutawayOrderDetailDAO(PutawayOrderDetailDAO putawayOrderDetailDAO) {
		this.putawayOrderDetailDAO = putawayOrderDetailDAO;
	}

	public void setDiffOrderDAO(DiffOrderDAO diffOrderDAO) {
		this.diffOrderDAO = diffOrderDAO;
	}

	public void setDiffOrderDetailDAO(DiffOrderDetailDAO diffOrderDetailDAO) {
		this.diffOrderDetailDAO = diffOrderDetailDAO;
	}

	public void setContainerDAO(ContainerDAO containerDAO) {
		this.containerDAO = containerDAO;
	}

	public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
		this.warehouseDAO = warehouseDAO;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public void setInventoryProcessService(InventoryProcessService inventoryProcessService) {
		this.inventoryProcessService = inventoryProcessService;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}


}
