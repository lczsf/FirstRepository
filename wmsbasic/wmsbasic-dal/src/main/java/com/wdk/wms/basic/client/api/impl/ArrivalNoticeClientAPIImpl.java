package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.dal.dao.*;
import com.wdk.wms.basic.daoobject.ArrivalDetailDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.ArrivalNoticeClientAPI;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDO;
import com.wdk.wms.basic.daoobject.ArrivalNoticeDetailDO;
import com.wdk.wms.basic.query.parameters.ArrivalNoticeQuery;
import com.wdk.wms.basic.result.PageResult;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ArrivalNoticeClientAPIImpl implements ArrivalNoticeClientAPI {

	@Autowired
	private ArrivalNoticeDAO arrivalNoticeDAO;
	@Autowired
	private ArrivalNoticeDetailDAO arrivalNoticeDetailDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

	@Override
	public long insertArrivalNotice(ArrivalNoticeDO arrivalNoticeDO) {
		return arrivalNoticeDAO.insertArrivalNotice(arrivalNoticeDO);
	}

	@Override
	public PageResult<ArrivalNoticeDO> queryArrivalNotice(ArrivalNoticeQuery arrivalNoticeQuery) {

		PageResult<ArrivalNoticeDO> response = new PageResult<ArrivalNoticeDO>();
		List<ArrivalNoticeDO> results = Lists.newArrayList();
		arrivalNoticeQuery.setWarehouseCode(warehouseDAO.queryWarehouseCodeById(arrivalNoticeQuery.getWarehouseId())); // 设置分表code
		results = arrivalNoticeDAO.queryArrivalNotice(arrivalNoticeQuery);
		response.setList(results);

		// 总条数
		int count = arrivalNoticeDAO.queryArrivalNoticeCount(arrivalNoticeQuery);

		response.setNum(arrivalNoticeQuery.getNum());
		response.setTotalNum(count);
		response.setIndex(arrivalNoticeQuery.getIndex());
		return response;
	}

	@Override
	public long insertArrivalNoticeDetail(ArrivalNoticeDetailDO arrivalNoticeDetailDO) {
		return arrivalNoticeDetailDAO.insertArrivalNoticeDetail(arrivalNoticeDetailDO);
	}

	@Override
	public List<ArrivalNoticeDetailDO> queryArrivalNoticeDetail(long arrivalNoticeId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return arrivalNoticeDetailDAO.queryArrivalNoticeDetail(arrivalNoticeId, warehouseCode);
	}

	@Override
	public ArrivalNoticeDO queryByCode(String bizCode, Long warehouseId) {
		ArrivalNoticeDO arrivalNoticeDO = arrivalNoticeDAO.queryArrivalNoticeByCode(bizCode, warehouseId);
		/*
		 * //判断是否又到货通知单 通知单状态为 创建:1 收货中:2 if(arrivalNoticeDO != null && (arrivalNoticeDO.getStatus() == 1 || arrivalNoticeDO.getStatus() == 2)){ BasicUserDO userDO =
		 * userDAO.queryBasicUserById(userId); if(userDO != null){ //判断用户是否存在 if(userDO.getWarehouseId() == wareHouseId){//判断用户所属仓库和通知单仓库是否一致 if(new Date().getTime() <
		 * arrivalNoticeDO.getInvalidDate().getTime()){//判断是否超过失效日期 return arrivalNoticeDO; } } } }
		 */
		return arrivalNoticeDO;
	}

	@Override
	public ArrivalNoticeDetailDO queryByIdAndItemCode(Long asnId, String itemCode, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return arrivalNoticeDetailDAO.queryByIdAndItemCode(asnId, itemCode, warehouseCode);
	}

	@Override
	public ArrivalNoticeDO queryById(Long id, Long warehouseId) {
		return arrivalNoticeDAO.queryById(id, warehouseId);
	}

	@Override
	public int updateArrivaNoticeStatus(Long id, int status, Long operatorId, Long warehouseId) {
		return arrivalNoticeDAO.updateStatusById(id, status, operatorId, warehouseId);
	}

	/*
	 * @Override public Boolean updateActualQuantity(Long asnId, String itemCode, Double packageQuantity, Long operatorId) { // 获取数据版本 int version = arrivalNoticeDetailDAO.queryVersion(asnId,
	 * itemCode); // 更新到货通知单操作人 arrivalNoticeDAO.updateOperatorId(asnId, operatorId); // 获取商品 BasicItemDO basicItemDO = itemDAO.queryByCode(itemCode); Double quantity = basicItemDO.getSpecification()
	 * * packageQuantity; // 计算实收数量 int count = arrivalNoticeDetailDAO.updateActualQuantity(asnId, itemCode, version, packageQuantity); return count > 0 ? true : false; }
	 */

	@Override
	public List<ArrivalNoticeDetailDO> queryArrivalIncomeDetail(Long asnId, Long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return arrivalNoticeDetailDAO.queryArrivalIncomeDetail(asnId, warehouseCode);
	}

	@Override
	public ArrivalNoticeDO queryByIdAndWarehouseId(Long id, Long whId) {
		return arrivalNoticeDAO.queryByIdAndWarehouseId(id, whId);
	}

	@Override
	public void insertListArrivalNoticeDetailDO(List<ArrivalNoticeDetailDO> list) {
		arrivalNoticeDetailDAO.insertListData(list);
	}

    @Override
    public boolean insertArrivalNoticeAndArrivalNoticeDetail(final ArrivalNoticeDO arrivalNoticeDO, final List<ArrivalNoticeDetailDO> arrivalNoticeDetailDOList) {
        return (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    long arrivalNoticeId = arrivalNoticeDAO.insertArrivalNotice(arrivalNoticeDO);    //插入到货通知单
                    for (ArrivalNoticeDetailDO arrivalNoticeDetailDO : arrivalNoticeDetailDOList) {
                        arrivalNoticeDetailDO.setAsnId(arrivalNoticeId);      //设置到货通知单主表id
                    }
                    arrivalNoticeDetailDAO.insertListData(arrivalNoticeDetailDOList);    //批量插入到货通知单明细
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    status.setRollbackOnly();   //回滚
                    return false;
                }
            }
        });
    }
}
