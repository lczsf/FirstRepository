package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import com.wdk.wms.basic.common.CommonService;
import com.wdk.wms.basic.common.WdkWmsSerialNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.ParamClientAPI;
import com.wdk.wms.basic.dal.dao.ParamTypeDAO;
import com.wdk.wms.basic.dal.dao.ParamValueDAO;
import com.wdk.wms.basic.daoobject.BasicParamTypeDO;
import com.wdk.wms.basic.daoobject.BasicParamValueDO;
import com.wdk.wms.basic.query.parameters.ParamTypeQuery;
import com.wdk.wms.basic.result.PageResult;
import org.springframework.jdbc.UncategorizedSQLException;

/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/9/14
 */
public class ParamClientAPIImpl implements ParamClientAPI {

	@Autowired
	private ParamTypeDAO paramTypeDAO;

	@Autowired
	private ParamValueDAO paramValueDAO;

	@Autowired
	private WdkWmsSerialNumberUtil wdkWmsSerialNumberUtil;

	@Autowired
	private CommonService commonService;

	@Override
	public Long inserParam(BasicParamTypeDO paramTypeDO) {
		// 校验code 唯一
		BasicParamTypeDO basicParamTypeDO = paramTypeDAO.queryByCode(paramTypeDO.getTypeCode());
		if (basicParamTypeDO != null) {
			throw new IllegalArgumentException("编码 " + paramTypeDO.getTypeCode() + " 已存在,请重新输入");
		}
		// 保存参数类型
		Long paramTypeId = paramTypeDAO.insertParamType(paramTypeDO);
		if (paramTypeDO.getParamValueDOs() != null && paramTypeDO.getParamValueDOs().size() != 0) {// 判断是否又参数值
			// 插入参数值
			for (BasicParamValueDO paramValueDO : paramTypeDO.getParamValueDOs()) {
				paramValueDO.setParamTypeId(paramTypeId); // 设置paramTypeId
				try {
					paramValueDAO.insertParamValue(paramValueDO);
				} catch (Exception e) {
					if (e instanceof UncategorizedSQLException && ((UncategorizedSQLException) e).getSQLException().getMessage().contains("Duplicate entry")) {
						throw new IllegalArgumentException("参数 " + paramValueDO.getParamName() + " 参数值不能重复!");
					}
				}
			}
		}
		return paramTypeId;
	}

	@Override
	public int updateParam(BasicParamTypeDO paramTypeDO, Long warehouseId) {
		int count;
		count = paramTypeDAO.updateParamType(paramTypeDO);
		if (paramTypeDO.getParamValueDOs() != null && paramTypeDO.getParamValueDOs().size() != 0) {// 判断是否又参数值
			// 删除仓库原先的参数
			paramValueDAO.deleteByTypeIdsAndWarehouseId(paramTypeDO.getId() + "", warehouseId);

			for (BasicParamValueDO paramValueDO : paramTypeDO.getParamValueDOs()) { // 插入新的参数值
				paramValueDO.setParamTypeId(paramTypeDO.getId());
				paramValueDAO.insertParamValue(paramValueDO);
				count++;
			}
		}
		return count;
	}

	@Override
	public PageResult<BasicParamTypeDO> queryParam(ParamTypeQuery query) {
		PageResult<BasicParamTypeDO> pageResult = new PageResult<BasicParamTypeDO>();
		List<BasicParamTypeDO> basicParamTypeDOs = paramTypeDAO.queryParamType(query);
		int count = paramTypeDAO.queryParamTypeCount();

		// 设置分页
		pageResult.setTotalNum(count);
		pageResult.setList(basicParamTypeDOs);
		pageResult.setIndex(query.getIndex());
		return pageResult;
	}

	@Override
	public BasicParamTypeDO queryParamByTypeId(Long id, Long warehouseId) {
		BasicParamTypeDO paramTypeDO = paramTypeDAO.queryParamTypeById(id);

		List<BasicParamValueDO> basicParamValueDOs;
		if (warehouseId == null) { // 查询公共参数
			basicParamValueDOs = paramValueDAO.queryByTypeIdAndWarehouseIdIsNull(id);
		} else { // 查询公共参数和仓库参数
			basicParamValueDOs = paramValueDAO.queryByTypeIdWarehouseIdOrIsNull(id, warehouseId);
		}

		paramTypeDO.setParamValueDOs(basicParamValueDOs);
		return paramTypeDO;
	}

	@Override
	public int deleteParam(String ids) {
		int count;
		// 删除参数值
		count = paramValueDAO.deleteParamValueByParamTypeIds(ids);

		// 删除参数类型
		count += paramTypeDAO.deleteParamType(ids);
		return count;
	}

	@Override
	public String queryValueByWhidAndCodeAndKey(Long warehouseId, String typeCode, String paramName) {
		// 查询所有参数值
		List<BasicParamValueDO> basicParamValueDOs = paramValueDAO.queryValueByParamCode(warehouseId, typeCode);
		if (basicParamValueDOs.isEmpty()) { // 查不到参数直接返回
			return null;
		}
		for (BasicParamValueDO paramValueDO : basicParamValueDOs) {
			if (paramValueDO.getParamName().equalsIgnoreCase(paramName)) { // 判断paramName 是否相等 不区分大小写
				return paramValueDO.getParamValue();
			}
		}
		return null;
	}

	@Override
	public String querySerialNumber(Long whId, String orderType, String serialType) {
		return wdkWmsSerialNumberUtil.createCode(whId, orderType, serialType);
	}

	@Override
	public Boolean checkDecimal(Double quanity, String unit) {
		return commonService.checkDecimal(quanity, unit);
	}

	@Override
	public Double quanityTransform(long itemId, double sellQuanity, long whId, boolean isInventory) {
		return commonService.quanityTransform(itemId, sellQuanity, whId, isInventory);
	}
}
