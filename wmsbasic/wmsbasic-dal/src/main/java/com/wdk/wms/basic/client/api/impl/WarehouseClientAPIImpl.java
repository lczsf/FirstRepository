package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.WarehouseClientAPI;
import com.wdk.wms.basic.dal.dao.UserDAO;
import com.wdk.wms.basic.dal.dao.UserWarehouseAreaDAO;
import com.wdk.wms.basic.dal.dao.WarehouseAreaDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BasicUserDO;
import com.wdk.wms.basic.daoobject.BasicUserWarehouseAreaDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseAreaDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.query.parameters.UserWarehouseAreaQuery;
import com.wdk.wms.basic.query.parameters.WarehouseAreaQuery;
import com.wdk.wms.basic.query.parameters.WarehouseQuery;
import com.wdk.wms.basic.result.PageResult;

public class WarehouseClientAPIImpl implements WarehouseClientAPI {

	@Autowired
	private WarehouseDAO warehouseDAO;

	@Override
	public long insertWarehouse(BasicWarehouseDO basicWarehouseD)
			{
		// 仓库收货方式为空时，插入默认值为手动收货0
		if (basicWarehouseD.getReceivingMode() == null)
			basicWarehouseD.setReceivingMode(0);
		// 校验编码是否重复
		WarehouseQuery warehouseQuery = new WarehouseQuery();
		warehouseQuery.setCode(basicWarehouseD.getCode());
		if (warehouseDAO.queryWarehouse(warehouseQuery).size() == 1
				&& warehouseQuery.getCode() != null)
			throw new IllegalArgumentException("仓库编码已存在！请重新输入！");
        if(checkWarehouseName(basicWarehouseD))
			throw new IllegalArgumentException("仓库名称已存在！请重新输入！");
		return warehouseDAO.insertWarehouse(basicWarehouseD);
	}

	@Override
	public List<BasicWarehouseDO> queryWarehouse(WarehouseQuery warehouseQuery) {

		return warehouseDAO.queryWarehouse(warehouseQuery);
	}

	@Override
	public Integer updateWarehouse(BasicWarehouseDO basicWarehouseDO)  {
		if(checkWarehouseName(basicWarehouseDO))
			throw new IllegalArgumentException("仓库名称已存在！请重新输入！");
		
		return warehouseDAO.updateWarehouse(basicWarehouseDO);
	}

	@Override
	public PageResult<BasicWarehouseDO> queryWarehousePage(
			WarehouseQuery warehouseQuery) {
		// 返回数据
		PageResult<BasicWarehouseDO> response = new PageResult<BasicWarehouseDO>();

		List<BasicWarehouseDO> results;

		// 当前页数据
		results = warehouseDAO.queryWarehouse(warehouseQuery);
		// 总条数
		int count = warehouseDAO.queryWarehouseCount(warehouseQuery);

		response.setNum(warehouseQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(warehouseQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateWarehouseStatus(int status, String idList,
			long operatorId) {
		if (warehouseDAO.updateWarehouseStatus(status, idList, operatorId) != 0)
			return true;
		return false;
	}

	@Override
	public BasicWarehouseDO queryWarehouseById(long id) {
		return warehouseDAO.queryWarehouseById(id);
	}

	@Autowired
	private WarehouseAreaDAO warehouseAreaDAO;

	@Override
	public long insertWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaDO)
			{
		// 校验编码是否重复
		WarehouseAreaQuery warehouseAreaQuery = new WarehouseAreaQuery();
		warehouseAreaQuery.setCode(basicWarehouseAreaDO.getCode());
		if (warehouseAreaDAO.queryWarehouseArea(warehouseAreaQuery).size() == 1
				&& warehouseAreaQuery.getCode() != null)
			throw new IllegalArgumentException("库区编码已存在！请重新输入！");

		
		return warehouseAreaDAO.insertWarehouseArea(basicWarehouseAreaDO);
	}

	@Override
	public List<BasicWarehouseAreaDO> queryWarehouseArea(
			WarehouseAreaQuery warehouseAreaQuery) {

		return warehouseAreaDAO.queryWarehouseArea(warehouseAreaQuery);
	}

	@Override
	public Integer updateWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaDO) {

		return warehouseAreaDAO.updateWarehouseArea(basicWarehouseAreaDO);
	}

	@Override
	public PageResult<BasicWarehouseAreaDO> queryWarehouseAreaPage(
			WarehouseAreaQuery warehouseAreaQuery) {
		// 返回数据
		PageResult<BasicWarehouseAreaDO> response = new PageResult<BasicWarehouseAreaDO>();

		List<BasicWarehouseAreaDO> results;

		// 当前页数据
		results = warehouseAreaDAO.queryWarehouseArea(warehouseAreaQuery);
		// 总条数
		int count = warehouseAreaDAO
				.queryWarehouseAreaCount(warehouseAreaQuery);

		response.setNum(warehouseAreaQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(warehouseAreaQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateWarehouseAreaStatus(int status, String idList,
			long operatorId) {
		if (warehouseAreaDAO.updateWarehouseAreaStatus(status, idList,
				operatorId) != 0)
			return true;
		return false;
	}

	@Override
	public BasicWarehouseAreaDO queryWarehouseAreaById(long id) {
		return warehouseAreaDAO.queryWarehouseAreaById(id);
	}

	@Autowired
	private UserWarehouseAreaDAO userWarehouseAreaDAO;
	@Autowired
	private UserDAO userDAO;

	@Override
	public long insertUserWarehouseArea(
			BasicUserWarehouseAreaDO basicUserWarehouseAreaDO) {
		// 用户编号校验
		BasicUserDO basicUserDO = userDAO.queryUserByWorkNumber(basicUserWarehouseAreaDO.getWorkNumber());
		if (basicUserDO == null)
			throw new IllegalArgumentException("用户编号不存在！请检查！");
		basicUserWarehouseAreaDO.setUserId(basicUserDO.getId());

		return userWarehouseAreaDAO
				.insertUserWarehouseArea(basicUserWarehouseAreaDO);
	}

	@Override
	public PageResult<BasicUserWarehouseAreaDO> queryUserWarehouseAreaPage(
			UserWarehouseAreaQuery userWarehouseAreaQuery) {
		
		// 返回数据
		PageResult<BasicUserWarehouseAreaDO> response = new PageResult<BasicUserWarehouseAreaDO>();

		List<BasicUserWarehouseAreaDO> results;

		// 当前页数据
		results = userWarehouseAreaDAO.queryUserWarehouseArea(userWarehouseAreaQuery);
		// 总条数
		int count = userWarehouseAreaDAO
				.queryUserWarehouseAreaCount(userWarehouseAreaQuery);

		response.setNum(userWarehouseAreaQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(userWarehouseAreaQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateUserWarehouseArea(
			BasicUserWarehouseAreaDO basicUserWarehouseAreaDO) {
		if ( userWarehouseAreaDAO.updateUserWarehouseArea(basicUserWarehouseAreaDO) != 0)
			return true;
		return false;
	}

	@Override
	public BasicUserWarehouseAreaDO queryUserWarehouseAreaById(long id) {
		 
		return userWarehouseAreaDAO.queryUserWarehouseAreaById(id);
	}
   
	public boolean checkWarehouseName(BasicWarehouseDO basiWarehouseDO){
		// 校验姓名是否重复
		WarehouseQuery warehouseQuery = new WarehouseQuery();
		warehouseQuery.setName(basiWarehouseDO.getName());
		if (warehouseDAO.queryWarehouse(warehouseQuery).size() == 1) {
			BasicWarehouseDO bw = warehouseDAO.queryWarehouse(warehouseQuery).get(0);
			if (warehouseQuery.getName() != null && !bw.getId().equals(basiWarehouseDO.getId()))
			return true;
		}
				return false;
	}

	@Override
	public String queryWarehouseNameById(long id) {

		return warehouseDAO.querWarehouseNameById(id);
	}

	@Override
	public Long queryIdByWarehouseCode(Long warehouseCode) {
		return warehouseDAO.queryIdByWarehouseCode(warehouseCode);
	}

	@Override
	public Long queryWarehouseCodeById(Long wId) {
		return warehouseDAO.queryWarehouseCodeById(wId);
	}

	@Override
	public BasicWarehouseDO queryWarehouseByCode(String code) {

		return warehouseDAO.queryWarehouseByCode(code);
	}
}
