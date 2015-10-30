package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.ParceClientAPI;
import com.wdk.wms.basic.dal.dao.ParceDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.ParcelDO;
import com.wdk.wms.basic.query.parameters.ParcelQuery;
import com.wdk.wms.basic.result.PageResult;

/****
 * 
 * @author wb-cengxi 创建人：曾曦 创建时间：2015.9.28 修改时间：2015.9.28
 * 
 */
public class ParceClientAPIImpl implements ParceClientAPI {

	@Autowired
	private ParceDAO basicParceDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public long insertBasicParcel(ParcelDO ParcelDO) {
		return basicParceDAO.insertBasicParcel(ParcelDO);
	}

	@Override
	public int updateBasicParcel(ParcelDO ParcelDO) {
		return basicParceDAO.updateBasicParcel(ParcelDO);
	}

	@Override
	public List<ParcelDO> queryBasicParce(ParcelQuery basicParcelQuery) {
		return basicParceDAO.queryBasicParce(basicParcelQuery);
	}

	@Override
	public PageResult<ParcelDO> queryPageBasicParcel(ParcelQuery basicParcelQuery) {
		PageResult<ParcelDO> response = new PageResult<ParcelDO>();
		List<ParcelDO> results = new ArrayList<ParcelDO>();
		results = basicParceDAO.queryBasicParce(basicParcelQuery);
		response.setList(results);

		// 总条数
		int count = basicParceDAO.queryCountBasicParcel(basicParcelQuery);

		response.setNum(basicParcelQuery.getNum());
		response.setTotalNum(count);
		response.setIndex(basicParcelQuery.getIndex());
		return response;
	}

	@Override
	public List<ParcelDO> queryById(long Id, long warehouseId) {

		return basicParceDAO.queryById(Id, warehouseDAO.queryWarehouseCodeById(warehouseId));
	}

	@Override
	public ParcelDO queryByWaveId(long waveId, long warehouseId) {
		Long warehouseCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		return basicParceDAO.queryByWaveId(waveId, warehouseCode);
	}

}
