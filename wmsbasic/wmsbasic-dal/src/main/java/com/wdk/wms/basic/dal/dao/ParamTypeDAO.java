package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.BasicParamTypeDO;
import com.wdk.wms.basic.query.parameters.ParamTypeQuery;

import java.util.List;

/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/9/14
 */
@Dao("basic_param_type")
public interface ParamTypeDAO {

	@Select
	List<BasicParamTypeDO> queryParamType(ParamTypeQuery paramTypeQuery);

	@Select
	int queryParamTypeCount();

	@Select
	BasicParamTypeDO queryParamTypeById(Long id);

	@Insert
	Long insertParamType(BasicParamTypeDO basicParamTypeDO);

	@Update
	int updateParamType(BasicParamTypeDO basicParamTypeDO);

	@Delete
	int deleteParamType(String ids);

	/**
	 * 通过code 查询参数类型
	 * 
	 * @param typeCode
	 * @return
	 */
	@Select
	BasicParamTypeDO queryByCode(String typeCode);
}
