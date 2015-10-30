package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.PutawayOrderClientAPI;
import com.wdk.wms.basic.common.WdkWmsSerialNumberUtil;
import com.wdk.wms.basic.dal.dao.ArrivalNoticeDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.PutawayOrderDAO;
import com.wdk.wms.basic.dal.dao.PutawayOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDO;
import com.wdk.wms.basic.daoobject.PutawayOrderDetailDO;
import com.wdk.wms.basic.enums.PutawayOrderStatusEnum;
import com.wdk.wms.basic.query.parameters.PutawayOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.PutawayOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class PutawayOrderClientAPIImpl implements PutawayOrderClientAPI {
	@Autowired
	private PutawayOrderDAO putawayOrderDAO;

	@Autowired
	private PutawayOrderDetailDAO putawayOrderDetailDAO;

	@Autowired
	private ArrivalNoticeDAO arrivalNoticeDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private WdkWmsSerialNumberUtil wdkWmsSerialNumberUtil;

	@Override
	public PutawayOrderDO queryByContainerCode(String containerCode, int status, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.queryByContainerCode(containerCode, status, warehouseId, warehouseCode);
	}

	@Override
	public int updateByContainerCodeAndPutawayerId(Long putawayOrderId, Long putawayerId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.updateByContainerCodeAndPutawayerId(putawayOrderId, putawayerId, warehouseId, warehouseCode);
	}

	@Override
	public List<PutawayOrderDO> queryPutawayOrderByStatusIsOne(Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.queryPutawayOrderByStatusIsOne(warehouseId, warehouseCode);
	}

	@Override
	public PutawayOrderDO queryByContainerOrderId(Long containerOrderId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.queryByContainerOrderId(containerOrderId, warehouseId, warehouseCode);
	}

	@Override
	public double queryCountByPutawayOrderIdAndItemCode(Long putawayOrderId, String itemCode, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		List<PutawayOrderDetailDO> lists = putawayOrderDetailDAO.queryByPutawayOrderIdAndItemCode(putawayOrderId, itemCode, warehouseCode);
		double count = 0;
		for (PutawayOrderDetailDO item : lists) {
			if (item.getActualPackageQuantity() != null)
				count += item.getActualPackageQuantity();
		}
		return count;
	}

	@Override
	public PutawayOrderDO queryPutawayOrderById(long putawayOrderId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.queryPutawayOrderById(putawayOrderId, warehouseId, warehouseCode);
	}

	@Override
	public List<PutawayOrderDetailDO> queryPutawayOrderDetailByPutawayOrderId(long putawayOrderId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDetailDAO.queryPutawayOrderDetailByPutawayOrderId(putawayOrderId, warehouseCode);
	}

	@Override
	public PageResult<PutawayOrderDO> queryPutawayOrderPage(PutawayOrderQuery putawayOrderQuery) {

		putawayOrderQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(putawayOrderQuery.getWarehouseId())); // 设置分表code
		// 返回数据
		PageResult<PutawayOrderDO> response = new PageResult<PutawayOrderDO>();

		List<PutawayOrderDO> results;
		// 当前页数据
		results = putawayOrderDAO.queryPutawayOrder(putawayOrderQuery);
		// 总条数
		int count = putawayOrderDAO.queryPutawayOrderCount(putawayOrderQuery);

		response.setNum(putawayOrderQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(putawayOrderQuery.getIndex());
		return response;
	}

	@Override
	public boolean updatePutawayOrderStatusById(long putawayOrderId, int status, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		if (putawayOrderDAO.updatePutawayOrderStatusById(putawayOrderId, status, warehouseId, warehouseCode) != 0)
			return false;
		return true;
	}

	@Override
	public long insertPutawayOrder(PutawayOrderDO putawayOrderDO) {
		putawayOrderDO.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(putawayOrderDO.getWarehouseId())); // 分表code
		putawayOrderDO.setCode(wdkWmsSerialNumberUtil.createCode(putawayOrderDO.getWarehouseId(), "SJ", "SJD"));// 上架单code
		return putawayOrderDAO.insertPutawayOrder(putawayOrderDO);
	}

	@Override
	public long insertPutawayOrderByArguments(int sourceType, long orderId, String containerCode, int isRf, Long putawayerId, int type, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		// 查询到货通知单信息
		ArrivalNoticeDO arrivalNoticeDO = arrivalNoticeDAO.queryById(orderId, warehouseId);// ??????????
		// 设置上架单信息
		PutawayOrderDO putawayOrderDO = new PutawayOrderDO();

		putawayOrderDO.setCode(wdkWmsSerialNumberUtil.createCode(warehouseId, "SJ", "SJD"));// 上架单code
		putawayOrderDO.setWarehouseCode(warehouseCode); // 分表code
		putawayOrderDO.setSourceType(sourceType);// 来源类型
		putawayOrderDO.setSourceOrderId(orderId);// 来源单据id
		putawayOrderDO.setWarehouseId(arrivalNoticeDO.getWarehouseId());// 仓库id
		putawayOrderDO.setOwnerId(arrivalNoticeDO.getOwnerId());// 货主id
		putawayOrderDO.setPutawayerId(putawayerId);// 上架人id
		putawayOrderDO.setOperatorId(putawayerId);
		putawayOrderDO.setContainerCode(containerCode);// 容器code
		putawayOrderDO.setType(type);// 上架类型
		putawayOrderDO.setSourceOrderCode(arrivalNoticeDO.getAsnCode());// 来源单据code

		return putawayOrderDAO.insertPutawayOrder(putawayOrderDO);

	}

	@Override
	public PageResult<PutawayOrderDetailDO> queryPutawayOrderDetailPage(PutawayOrderDetailQuery putawayOrderDetailQuery) {

		putawayOrderDetailQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(putawayOrderDetailQuery.getWarehouseId()));
		// 返回数据
		PageResult<PutawayOrderDetailDO> response = new PageResult<PutawayOrderDetailDO>();

		List<PutawayOrderDetailDO> results;

		// 当前页数据
		results = putawayOrderDetailDAO.queryPutawayOrderDetail(putawayOrderDetailQuery);
		// 总条数
		int count = putawayOrderDetailDAO.queryPutawayOrderDetailCount(putawayOrderDetailQuery);

		response.setNum(putawayOrderDetailQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(putawayOrderDetailQuery.getIndex());
		return response;
	}

	@Override
	public PutawayOrderDO queryByOrderIdAndContainerCode(long orderId, String containerCode, long warehouseId) {
		long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);

		return putawayOrderDAO.queryByOrderIdAndContainerCode(orderId, containerCode, warehouseId, warehouseCode, PutawayOrderStatusEnum.CREATE.getIndex());
	}

	@Override
	public List<PutawayOrderDO> queryByItemIdAndStatus(long itemId, int status, long warehouseId) {
		long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return putawayOrderDAO.queryByItemIdAndStatus(itemId, status, warehouseId, warehouseCode);
	}
}
