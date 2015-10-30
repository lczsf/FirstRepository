package com.wdk.wms.basic.client.api.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.client.api.UserClientAPI;
import com.wdk.wms.basic.common.MD5Util;
import com.wdk.wms.basic.dal.dao.UserDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BasicUserDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.CoupleData;
import com.wdk.wms.basic.query.parameters.PrivilegedUserQuery;
import com.wdk.wms.basic.query.parameters.UserQuery;
import com.wdk.wms.basic.result.PageResult;

public class UserClientAPIImpl implements UserClientAPI {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;


	@Override
	public PageResult<BasicUserDO> queryBasicUser(UserQuery queryParameter) {
		PageResult<BasicUserDO> result = new PageResult<BasicUserDO>();
		List<BasicUserDO> basicUserDOs = userDAO.queryBasicUser(queryParameter);
		// 设置可操作仓库
		for (BasicUserDO userDO : basicUserDOs) {
			if (StringUtils.isNotEmpty(userDO.getWarehouseIds())) { // 判断可操作仓库
				List<BasicWarehouseDO> basicWarehouseDOs = warehouseDAO.queryWarehouseByIds(userDO.getWarehouseIds());
				userDO.setWarehouseDOs(basicWarehouseDOs);
			}
		}
		// 查询总数
		int userCount = userDAO.queryUserCount(queryParameter);
		result.setList(basicUserDOs);
		result.setIndex(queryParameter.getIndex());
		result.setNum(queryParameter.getNum());
		result.setTotalNum(userCount);
		return result;
	}

	@Override
	public Long inserUser(BasicUserDO userDO) {

		// 检查用户名不小于4位 密码不小于5位
		if (userDO.getAccount().length() < 4 || userDO.getPassword().length() < 5) {
			throw new IllegalArgumentException("用户名或密码长度不够!");
		}

		// 校验用户名不可重复
		BasicUserDO user = userDAO.queryUserByAccount(userDO.getAccount());
		if (user != null) {
			throw new IllegalArgumentException("用户名 " + userDO.getAccount() + " 已存在,请重新输入");
		}

		// 校验 用户名 只允许数字和字母
		String pattern = "^[A-Za-z0-9]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(userDO.getAccount());
		if (m.matches()) {
			// MD5加密密码 动态加密
			userDO.setPassword(MD5Util.doubleMD5(userDO.getPassword()));
			return userDAO.insertBasicUserDO(userDO);
		}
		return 0L;
	}

	@Override
	public int updateUser(BasicUserDO userDO) {
		return userDAO.updateBasicUserDO(userDO);
	}

	@Override
	public int deleteByIds(String ids) {
		return userDAO.deleteBasicUserByIds(ids);
	}

	@Override
	public int updateUserStatus(String ids, int status, Long operatorId) {
		return userDAO.updateUserStatus(ids, status, operatorId);
	}

	@Override
	public BasicUserDO queryBasicUserById(Long id) {
		BasicUserDO userDO = userDAO.queryBasicUserById(id);
		if (StringUtils.isNotEmpty(userDO.getWarehouseIds())) {
			// 封装可操作仓库集合
			List<BasicWarehouseDO> basicWarehouseDOs = warehouseDAO.queryWarehouseByIds(userDO.getWarehouseIds());
			userDO.setWarehouseDOs(basicWarehouseDOs);
		}
		return userDO;
	}

	@Override
	public BasicUserDO checkNameAndPassword(String account, String password) {
		// 密码需要MD5 动态加密
		BasicUserDO userDO = userDAO.checkNameAndPassword(account, password);
		return userDO;
	}


	@Override
	public List<CoupleData> queryWareHouseByUserId(Long userId) {
		// 获取用户
		BasicUserDO userDO = userDAO.queryBasicUserById(userId);
		List<CoupleData> coupleDatas = Lists.newArrayList();
		List<BasicWarehouseDO> warehouseDOs = Lists.newArrayList();
		// 获取所有可操作仓库
		if (userDO != null && userDO.getWarehouseIds() != null) {
			warehouseDOs = warehouseDAO.queryWarehouseByIds(userDO.getWarehouseIds());
		}
		// 组装数据
		for (BasicWarehouseDO warehouseDO : warehouseDOs) {
			CoupleData data = new CoupleData();
			data.setId(warehouseDO.getId());
			data.setName(warehouseDO.getName());
			coupleDatas.add(data);
		}
		return coupleDatas;
	}

	@Override
	public String queryUserNameById(Long id) {
		return userDAO.queryUserNameById(id);
	}

	@Override
	public List<CoupleData> queryWareHouseByUserName(String name) {
		// 获取用户
		BasicUserDO userDO = userDAO.queryUserByAccount(name);
		List<CoupleData> coupleDatas = Lists.newArrayList();
		List<BasicWarehouseDO> warehouseDOs = null;
		// 获取所有可操作仓库
		if (userDO != null && userDO.getWarehouseIds() != null) {
			warehouseDOs = warehouseDAO.queryWarehouseByIds(userDO.getWarehouseIds());
		}
		// 组装数据
		for (BasicWarehouseDO warehouseDO : warehouseDOs) {
			CoupleData data = new CoupleData();
			data.setId(warehouseDO.getId());
			data.setName(warehouseDO.getName());
			coupleDatas.add(data);
		}
		return coupleDatas;
	}

	@Override
	public Boolean checkWareHousePurview(Long userId, Long wareHouseId) {
		// 获取用户所有可操作仓库
		BasicUserDO userDO = userDAO.queryBasicUserById(userId);
		if (userDO != null && userDO.getWarehouseIds() != null) { // 判断用户可操作仓库不为空
			List<BasicWarehouseDO> basicWarehouseDOs = warehouseDAO.queryWarehouseByIds(userDO.getWarehouseIds());
			for (BasicWarehouseDO warehouseDO : basicWarehouseDOs) {
				if (warehouseDO.getId().equals(wareHouseId)) {// 判断传入仓库id是否相等, 相等则又此仓库权限
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public BasicUserDO queryByAccount(String account) {
		return userDAO.queryUserByAccount(account);
	}

	@Override
	public PageResult<BasicUserDO> getUserList(Long userId,String account,String userName,Integer status,String userIds,int index) {
		
		PrivilegedUserQuery query = new PrivilegedUserQuery();
		query.setUserId(userId);
		query.setAccount(account);
		query.setUserName(userName);
		query.setStatus(status);
		query.setUserIds(userIds);
		query.setUserIds(userIds);
		query.setIndex(index);
		
		PageResult<BasicUserDO> res = new PageResult<BasicUserDO>();
		
		res.setIndex(index);
		res.setNum(query.getNum());
		res.setTotalNum(userDAO.queryPrivilegedUserCount(query));
		res.setList(userDAO.queryPrivilegedUser(query));
		
		return res;
	}
}
