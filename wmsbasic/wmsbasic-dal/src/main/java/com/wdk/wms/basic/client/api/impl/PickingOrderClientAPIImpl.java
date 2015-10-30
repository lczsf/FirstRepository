package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.PickingOrderClientAPI;
import com.wdk.wms.basic.common.CabinetSortUtil;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDAO;
import com.wdk.wms.basic.dal.dao.PickingOrderDetailDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.daoobject.PickingOrderDO;
import com.wdk.wms.basic.daoobject.PickingOrderDetailDO;
import com.wdk.wms.basic.enums.PickingOrderDetailStatusEnum;
import com.wdk.wms.basic.enums.PickingOrderStatusEnum;
import com.wdk.wms.basic.query.parameters.PickingOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.PickingOrderQuery;
import com.wdk.wms.basic.result.PageResult;

public class PickingOrderClientAPIImpl implements PickingOrderClientAPI {

	@Autowired
	private PickingOrderDAO pickingOrderDAO;

	@Autowired
	private PickingOrderDetailDAO pickingOrderDetailDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Autowired
	private SortingGoodsPartitionDAO sortingGoodsPartitionDAO;

	@Autowired
	private PickingContainerDAO pickingContainerDAO;

	@Autowired
	private CabinetDAO cabinetDAO;

	@Override
	public PageResult<PickingOrderDO> queryPickingOrderPage(PickingOrderQuery pickingOrderQuery) {
		pickingOrderQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(pickingOrderQuery.getWarehouseId())); // 设置分表code
		// 返回数据
		PageResult<PickingOrderDO> response = new PageResult<PickingOrderDO>();

		List<PickingOrderDO> results;

		// 当前页数据
		results = pickingOrderDAO.queryPickingOrder(pickingOrderQuery);
		// 总条数
		int count = pickingOrderDAO.queryPickingOrderCount(pickingOrderQuery);

		response.setNum(pickingOrderQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(pickingOrderQuery.getIndex());
		return response;
	}

	@Override
	public long insertPickingOrder(PickingOrderDO pickingOrderDO) {

		pickingOrderDO.setStatus(PickingOrderStatusEnum.CREATE.getIndex());
		return pickingOrderDAO.insertPickingOrder(pickingOrderDO);
	}

	@Override
	public int updatePickingOrder(PickingOrderDO pickingOrderDO) {

		return pickingOrderDAO.updatePickingOrder(pickingOrderDO);
	}

	@Override
	public PageResult<PickingOrderDetailDO> queryPickingOrderDetailPage(PickingOrderDetailQuery pickingOrderDetailQuery) {
		pickingOrderDetailQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(pickingOrderDetailQuery.getWarehouseId())); // 设置分表code
		// 返回数据
		PageResult<PickingOrderDetailDO> response = new PageResult<PickingOrderDetailDO>();

		List<PickingOrderDetailDO> results;

		// 当前页数据
		results = pickingOrderDetailDAO.queryPickingOrderDetail(pickingOrderDetailQuery);
		// 总条数
		int count = pickingOrderDetailDAO.queryPickingOrderDetailCount(pickingOrderDetailQuery);

		response.setNum(pickingOrderDetailQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(pickingOrderDetailQuery.getIndex());
		return response;
	}

	@Override
	public long insertPickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO) {
		pickingOrderDetailDO.setStatus(PickingOrderStatusEnum.CREATE.getIndex());
		return pickingOrderDetailDAO.insertPickingOrderDetail(pickingOrderDetailDO);
	}

	@Override
	public int updatePickingOrderDetail(PickingOrderDetailDO pickingOrderDetailDO) {

		return pickingOrderDetailDAO.updatePickingOrderDetail(pickingOrderDetailDO);
	}

	@Override
	public int queryCountByCodeAndWarehouseId(List<String> sortingGoodsPartitioncode, long warehouseId) {
		// 组装拣货分区id为 逗号分隔的字符串
		Map<String, List<String>> List = new HashMap<String, List<String>>();
		List.put("codeList", sortingGoodsPartitioncode);// 组装分区code结婚查询
		List<Long> idList = sortingGoodsPartitionDAO.queryIdByCodeList(List);// 根据拣货分区code查询id集合
		if (idList == null)
			return 0;// 不存在此拣货分区信息，返回null；
		StringBuffer ids = new StringBuffer();
		for (Long id : idList) {
			ids.append(",").append(id);
		}
		ids = ids.deleteCharAt(0);
		// 组装拣货分区id为 逗号分隔的字符串
		PickingOrderQuery pickingOrderQuery = new PickingOrderQuery();// 声明查询Query
		pickingOrderQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(warehouseId)); // 设置分表code
		pickingOrderQuery.setStatus(PickingOrderStatusEnum.CREATE.getIndex());// 设置拣货单状态为创建状态
		pickingOrderQuery.setSortingGoodsPartitionIds(ids + "");// 设置拣货分区id集合
		pickingOrderQuery.setWarehouseId(warehouseId);// 设置仓库id
		List<PickingOrderDO> list = pickingOrderDAO.queryPickingOrder(pickingOrderQuery);// 查询拣货单list
		return list.size();
	}

	@Override
	public String queryHaveCodeByArguments(List<String> sortingGoodsPartitioncode, long userId, long warehouseId) {

		// 组装拣货分区id为 逗号分隔的字符串
		Map<String, List<String>> List = new HashMap<String, List<String>>();
		List.put("codeList", sortingGoodsPartitioncode);// 组装分区code结婚查询
		List<Long> idList = sortingGoodsPartitionDAO.queryIdByCodeList(List);// 根据拣货分区code查询id集合
		StringBuffer ids = new StringBuffer();
		if (idList.size() == 0)
			return null;// 不存在此拣货分区信息，返回null；
		for (Long id : idList) {
			ids.append(",").append(id);
		}
		ids = ids.deleteCharAt(0);
		// 组装拣货分区id为 逗号分隔的字符串

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);// 仓库分表code
		
		PickingOrderQuery pickingOrderQuery = new PickingOrderQuery();// 声明查询Query
		pickingOrderQuery.setWarehouseCode(warehouseCode); // 设置分表code
		pickingOrderQuery.setStatus(PickingOrderStatusEnum.UNDERWAY.getIndex());// 设置拣货单状态为拣货中状态
		pickingOrderQuery.setSortingGoodsPartitionIds(ids + "");// 设置拣货分区id集合
		pickingOrderQuery.setResponsibleId(userId);// 设置操作人id
		pickingOrderQuery.setWarehouseId(warehouseId);// 设置仓库id
		List<PickingOrderDO> list = pickingOrderDAO.queryPickingOrder(pickingOrderQuery);// 查询拣货单list
		if (list.size() > 0)
			return list.get(0).getCode();
		return null;
	}

	@Override
	public String queryPriorityCodeByArguments(List<String> sortingGoodsPartitioncode, long userId, long warehouseId) {
		
		// 组装拣货分区id为 逗号分隔的字符串
		Map<String, List<String>> List = new HashMap<String, List<String>>();
		List.put("codeList", sortingGoodsPartitioncode);// 组装分区code结婚查询
		List<Long> idList = sortingGoodsPartitionDAO.queryIdByCodeList(List);// 根据拣货分区code查询id集合
		if (idList == null)
			return null;// 不存在此拣货分区信息，返回null；
		StringBuffer ids = new StringBuffer();
				for (Long id : idList) {
					ids.append(",").append(id);
				}
				ids = ids.deleteCharAt(0);
		// 组装拣货分区id为 逗号分隔的字符串

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);// 仓库分表code

		PickingOrderQuery pickingOrderQuery = new PickingOrderQuery();// 声明查询Query
		pickingOrderQuery.setStatus(PickingOrderStatusEnum.CREATE.getIndex());// 设置拣货单状态为创建状态
		pickingOrderQuery.setSortingGoodsPartitionIds(ids + "");// 设置拣货分区id
		pickingOrderQuery.setWarehouseId(warehouseId);// 设置仓库id
		pickingOrderQuery.setResponsibleId(userId);// 设置操作人id
		pickingOrderQuery.setWarehouseCode(warehouseCode); // 设置分表code

		PickingOrderDO pickingOrderDO = pickingOrderDAO.queryPriorityPickingOrder(pickingOrderQuery);// 查询优先级最高拣货单
		if (pickingOrderDO == null)
			return null;// 不存在此类拣货单，返回null；
		pickingOrderDO.setStatus(PickingOrderStatusEnum.UNDERWAY.getIndex());
		pickingOrderDO.setResponsibleId(userId);// 设置拣货人id
		// 尝试更新三次
		for (int i = 0; i < 3; i++) {
			long updateCount = pickingOrderDAO.updatePriorityPickingOrder(pickingOrderDO);// 修改优先级最高拣货单的操作人
			if (updateCount != 0)
				return pickingOrderDO.getCode();
		}
		 
		return null;
	}

	@Override
	public PickingOrderDO queryPickingOrderByCode(String code, long warehouseId) {
		long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return pickingOrderDAO.queryPickingOrderByCode(code, warehouseId, warehouseCode);
	}

	@Override
	public List<PickingOrderDetailDO> queryByPickingOrderCodeAndWarehouseId(String pickingOrderCode, Long waveId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		PickingOrderDO pickingOrderDO = pickingOrderDAO.queryPickingOrderByCode(pickingOrderCode, warehouseId, warehouseCode);

		return pickingOrderDetailDAO.queryByPickingOrderIdAndWarehouseCode(pickingOrderDO.getId(), waveId, warehouseCode);
	}

	@Override
	public PickingOrderDetailDO queryByPickingOrderDetailId(Long pickingOrderId, Long waveId, Long pickingOrderDetailId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return pickingOrderDetailDAO.queryByPickingOrderDetailId(pickingOrderId, waveId, pickingOrderDetailId, warehouseCode);
	}

	@Override
	public List<PickingOrderDetailDO> queryCreateBypickingOrderCode(String pickingOrderCode, Long warehouseId) {

		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		PickingOrderDetailQuery pickingOrderDetailQuery = new PickingOrderDetailQuery();
		PickingOrderDO pickingOrderDO = pickingOrderDAO.queryPickingOrderByCode(pickingOrderCode, warehouseId, warehouseCode);// 查询拣货单do
		pickingOrderDetailQuery.setPickingOrderId(pickingOrderDO.getId());// 设置拣货单id
		pickingOrderDetailQuery.setStatus(PickingOrderDetailStatusEnum.CREATE.getIndex());// 设置拣货单详情状态
		pickingOrderDetailQuery.setWarehouseCode(warehouseCode);// 设置warehouse分表code
		return pickingOrderDetailDAO.queryPickingOrderDetail(pickingOrderDetailQuery);
	}

	@Override
	public List<PickingOrderDetailDO> sortPickingOrderDetailDOs(List<PickingOrderDetailDO> pickingOrderDetailDOs) {
		List<PickingOrderDetailDO> okpickingOrderDetailDOs = new ArrayList<PickingOrderDetailDO>();// 排好顺序的拣货单详情集合；
		// 整理拣货单id集合
		List<Long> pickingOrderList = new ArrayList<Long>();
		Long warehouseCode = pickingOrderDetailDOs.get(0).getWarehouseCode();// 设置仓库分表code
		Long warehouseId = warehouseDAO.queryIdByWarehouseCode(warehouseCode);// 设置仓库分表code
		for (PickingOrderDetailDO pickingOrderDetailDO : pickingOrderDetailDOs) {
			pickingOrderList.add(pickingOrderDetailDO.getPickingOrderId());// 销售主订单id集合

		}
		Map<String, List<Long>> pickingOrderIdMap = new HashMap<String, List<Long>>();// 排序入参

		pickingOrderIdMap.put("pickingOrderList", pickingOrderList);
		// 整理拣货单id集合

		List<Long> pickingOrderIdList = pickingOrderDAO.sortPickingOrderDOs(pickingOrderList, warehouseId, warehouseCode);

		// 遍历拣货单id集合，拣货单详情list按照库位进行排序
		List<PickingOrderDetailDO> partPickingOrderDetailDOs = new ArrayList<PickingOrderDetailDO>();
		for (Long pickingOrderId : pickingOrderIdList) {
			partPickingOrderDetailDOs.clear();// 情况集合
			for (PickingOrderDetailDO pickingOrderDetailDO : pickingOrderDetailDOs) {
				if (pickingOrderId.equals(pickingOrderDetailDO.getPickingOrderId())) {// 如果拣货单id相等，则对其中的拣货单详情list进行排序
					partPickingOrderDetailDOs.add(pickingOrderDetailDO);
				}
			}
			Collections.sort(partPickingOrderDetailDOs, new ComparatorPickingOrderDetail());
			okpickingOrderDetailDOs.addAll(partPickingOrderDetailDOs);// 增加排好序的拣货单详情
		}
		// 遍历拣货单id集合，拣货单详情list按照库位进行排序
		return okpickingOrderDetailDOs;
	}

	@Override
	public List<PickingOrderDO> queryByWaveId(Long waveId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return pickingOrderDAO.queryByWaveId(waveId, warehouseId, warehouseCode);
	}

	class ComparatorPickingOrderDetail extends CabinetSortUtil implements Comparator<PickingOrderDetailDO> {

		@Override
		public int compare(PickingOrderDetailDO o1, PickingOrderDetailDO o2) {
			if (!o1.getCabinetId().equals(o2.getCabinetId())) {// 库位不相同时排序
			BasicCabinetDO BasicCabinetDO1 = cabinetDAO.queryCabinetById(o1.getCabinetId());
			BasicCabinetDO BasicCabinetDO2 = cabinetDAO.queryCabinetById(o2.getCabinetId());
			return compareLine(BasicCabinetDO1, BasicCabinetDO2);
			} else// 库位相同时按照商品id排序
			{
				if (o1.getItemId() > o2.getItemId()) {
					return -1;
				} else if (o1.getItemId() < o2.getItemId()) {
					return 1;
				} else
					return 0;

			}
		}

	}

	@Override
	public int updateNotifyStatus(long id, int notifyStatus, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return pickingOrderDAO.updateNotifyStatus(id, notifyStatus, warehouseId, warehouseCode);
	}

}

