package com.wdk.wms.inventory.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.dal.dao.BackContainerOrderDAO;
import com.wdk.wms.basic.dal.dao.BackOrderDAO;
import com.wdk.wms.basic.dal.dao.DiffOrderDAO;
import com.wdk.wms.basic.dal.dao.DiffOrderDetailDAO;
import com.wdk.wms.basic.daoobject.BackContainerOrderDO;
import com.wdk.wms.basic.daoobject.BackOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;
import com.wdk.wms.basic.daoobject.InventoryInfoDO;
import com.wdk.wms.basic.daoobject.InventoryLogDO;
import com.wdk.wms.basic.enums.BackContainerOrderStatusEnum;
import com.wdk.wms.basic.enums.DifferOrderStatusEnum;
import com.wdk.wms.basic.enums.SourceTypeEnum;
import com.wdk.wms.basic.result.InventoryProcessResult;
import com.wdk.wms.inventory.parameters.InventoryInfoQuery;

/*
 * 差异单，归位装箱单执行上架，修改库存过程等
 */
public class VirtualOnshelf {
	@Autowired
	private DiffOrderDAO diffOrderDAO;
	@Autowired
	private DiffOrderDetailDAO diffOrderDetailDAO;
	@Autowired
	private BackContainerOrderDAO backContainerOrderDAO;
	@Autowired
	private BackOrderDAO backOrderDAO;
	@Autowired
	private CommonService commonService;
	@Autowired
	private InventoryProcessService inventoryProcessService;
	@Autowired
	private TransactionTemplate transactionTemplate;
	private final Logger log = LoggerFactory.getLogger(VirtualOnshelf.class);

	@SuppressWarnings("unchecked")
	public InventoryProcessResult<Integer> backOrderOnShelf(final long waveId,final long warehouseId,final long warehouseCode) {

		InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();// 返回结果
		inventoryProcessResult = (InventoryProcessResult<Integer>) transactionTemplate
				.execute(new TransactionCallback<Object>() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						List<BackContainerOrderDO>backContainerOrderDOs=backContainerOrderDAO.queryByWaveId(waveId, warehouseId, warehouseCode);
						InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();// 返回结果
						if(CollectionUtils.isEmpty(backContainerOrderDOs)){
							inventoryProcessResult.setStatus(1);
							return inventoryProcessResult;
						}
						try {
						for (BackContainerOrderDO backContainerOrderDO : backContainerOrderDOs) {
								if(backContainerOrderDO.getStatus()==BackContainerOrderStatusEnum.FINISH.getIndex()){ //如果状态为完成，不处理
									continue;
								}
								long itemId = backContainerOrderDO.getItemId();// 商品id
								long itemBatchId = backContainerOrderDO.getItemBatchId();// 商品批次
								long cabinetId = 8888L;// TODO 先写死，虚拟库位id
								long ownerId = backContainerOrderDO.getOwnerId();
								long waveId=backContainerOrderDO.getWaveId();
								BackOrderDO backOrderDO=new BackOrderDO();//归位单
								backOrderDO.setWaveId(waveId);
								backOrderDO.setBackContainerOrderId(backContainerOrderDO.getId());
								backOrderDO.setWarehouseId(warehouseId);
								backOrderDO.setWarehouseCode(warehouseCode);
								backOrderDO.setOwnerId(ownerId);
								backOrderDO.setItemId(itemId);
								backOrderDO.setBackCabinetId(cabinetId);//归位库位
								backOrderDO.setShouldBackNumber(backContainerOrderDO.getItemNumber());
								backOrderDO.setActualBackNumber(backContainerOrderDO.getItemNumber());
								long backOrderId=backOrderDAO.insertBackOrder(backOrderDO);//插入归位单
								backContainerOrderDAO.updateStatus(backContainerOrderDO.getId(), waveId, BackContainerOrderStatusEnum.FINISH.getIndex(), warehouseId, warehouseCode);//更新归位装箱单状态
								
								InventoryInfoQuery inventoryInfoQuery = inventoryProcessService.generateInventoryInfoQuery(warehouseId,
										warehouseCode, itemId, ownerId, itemBatchId);// 库存查询条件
								InventoryInfoDO inventoryInfoDO = inventoryProcessService.generateInventoryInfoDO(warehouseId, warehouseCode,
										itemId, ownerId, itemBatchId, cabinetId);

								double quantity = commonService.quanityTransform(itemId,
										backContainerOrderDO.getItemNumber(), warehouseId, true);// 转换后的库存数量
								if (quantity != (int) quantity) // 库存数量为小数
								{
									inventoryProcessResult.setStatus(-1);// 库存为小数，抛出异常
									status.setRollbackOnly();
									log.error("归位，库存数量为小数，波次id为："+waveId);
									return inventoryProcessResult;
								}
								final double inventoryQuantity = quantity;// 事务中需要final限制
								inventoryInfoDO.setRealInvent((long) inventoryQuantity);// 实物库存
								inventoryInfoDO.setAvailableInvent((long) inventoryQuantity);// 可用库存
								final InventoryLogDO inventoryLogDO = inventoryProcessService.generateInventoryLogDO(warehouseCode,
										backContainerOrderDO.getItemId(), backOrderId,
										SourceTypeEnum.BACK_ORDER.getIndex());

								inventoryProcessResult = inventoryProcessService.onshelfInventoryProcess(inventoryInfoQuery, inventoryInfoDO,
										inventoryQuantity, inventoryLogDO);
							} 
						}catch (Exception e) {
							status.setRollbackOnly();
							log.error("归位单库存更新失败，波次id：" +waveId, e);
							inventoryProcessResult.setStatus(-2);// -2库存插入失败,-1代表库存小数点的错误
							return inventoryProcessResult;
						}
						inventoryProcessResult.setStatus(1);
						return inventoryProcessResult;
					}
				});
		return inventoryProcessResult;

	}
	@SuppressWarnings("unchecked")
	public InventoryProcessResult<Integer> diffOrderOnshelf(final Long diffOrderId, final long warehouseId,
			final long warehouseCode) {
		InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();// 返回结果
		inventoryProcessResult = (InventoryProcessResult<Integer>) transactionTemplate
				.execute(new TransactionCallback<Object>() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						InventoryProcessResult<Integer> inventoryProcessResult = new InventoryProcessResult<Integer>();// 返回结果
						try {
							List<DiffOrderDetailDO> diffOrderDetailDOs = diffOrderDetailDAO
									.queryByDiffOrderId(diffOrderId, warehouseCode);
							DiffOrderDO diffOrderDO = diffOrderDAO.queryDiffOrderById(diffOrderId, warehouseId,
									warehouseCode);// 查询差异单
							diffOrderDAO.updateStatus(diffOrderId, DifferOrderStatusEnum.PROCCED.getIndex(),
									warehouseId, warehouseCode);// 更新差异单状态为已处理
							long ownerId = diffOrderDO.getOwnerId();// 货主id
							for (DiffOrderDetailDO diffOrderDetailDO : diffOrderDetailDOs) {
								long itemId = diffOrderDetailDO.getItemId();// 商品id
								long itemBatchId = diffOrderDetailDO.getItemBatchId();// 商品批次
								long cabinetId = 9999L;// TODO 先写死
								InventoryInfoQuery inventoryInfoQuery = inventoryProcessService.generateInventoryInfoQuery(warehouseId,
										warehouseCode, itemId, ownerId, itemBatchId);// 库存查询条件
								InventoryInfoDO inventoryInfoDO = inventoryProcessService.generateInventoryInfoDO(warehouseId, warehouseCode,
										itemId, ownerId, itemBatchId, cabinetId);
								BigDecimal actualPackageQuantity = BigDecimal
										.valueOf(diffOrderDetailDO.getDiffPackageQuantity()); // 差异件数
								BigDecimal spec = BigDecimal.valueOf(diffOrderDetailDO.getSpec()); // 规格转换格式
								double sellQuanity = actualPackageQuantity.multiply(spec).doubleValue();// 销售数量=采购数量*规格
								double quantity = commonService.quanityTransform(diffOrderDetailDO.getItemId(),
										sellQuanity, warehouseId, true);// 转换后的库存数量
								if (quantity != (int) quantity) // 库存数量为小数
								{
									inventoryProcessResult.setStatus(-1);// 库存为小数，抛出异常
									return inventoryProcessResult;// 直接返回
								}
								final double inventoryQuantity = quantity;// 事务中需要final限制
								inventoryInfoDO.setRealInvent((long) inventoryQuantity);// 实物库存
								inventoryInfoDO.setAvailableInvent((long) inventoryQuantity);// 可用库存
								final InventoryLogDO inventoryLogDO = inventoryProcessService.generateInventoryLogDO(warehouseCode,
										diffOrderDetailDO.getId(), diffOrderDetailDO.getId(),
										SourceTypeEnum.DIFF_ORDER_DETAIL.getIndex());

								inventoryProcessResult = inventoryProcessService.onshelfInventoryProcess(inventoryInfoQuery, inventoryInfoDO,
										inventoryQuantity, inventoryLogDO);
							}
						} catch (Exception e) {
							log.error("差异单库存更新失败，差异单id：" + diffOrderId, e);
							inventoryProcessResult.setStatus(-2);// -2库存插入失败,-1代表库存小数点的错误
							status.setRollbackOnly();
							return inventoryProcessResult;
						}
						return inventoryProcessResult;
					}
				});
		return inventoryProcessResult;
	}
}
