package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.BasicParamTypeDO;
import com.wdk.wms.basic.daoobject.BasicParamValueDO;
import com.wdk.wms.basic.query.parameters.ParamTypeQuery;
import com.wdk.wms.basic.query.parameters.ParamValueQuery;

/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/9/14
 */
@Dao("basic_param_value")
public interface ParamValueDAO {

	@Select
	List<BasicParamValueDO> queryParamValue(ParamValueQuery paramValueQuery);

	@Select
	BasicParamValueDO queryParamValueById(Long id);

	@Insert
	Long insertParamValue(BasicParamValueDO basicParamValueDO);

	@Update
	int updateParamValue(BasicParamValueDO basicParamValueDO);

	@Delete
	int deleteParamValue(String ids);

	/**
	 * 查询仓库参数
	 * 
	 * @param paramTypeId
	 *            参数类型id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Select
	List<BasicParamValueDO> queryParamValueByTypeIdAndWarehouseId(@Param("paramTypeId") Long paramTypeId, @Param("warehouseId") Long warehouseId);

	/**
	 * 查询仓库参数和公共参数
	 * 
	 * @param paramTypeId
	 *            仓库类型id
	 * @param warehouseId
	 *            餐卡id
	 * @return
	 */
	@Select
	List<BasicParamValueDO> queryByTypeIdWarehouseIdOrIsNull(@Param("paramTypeId") Long paramTypeId, @Param("warehouseId") Long warehouseId);

	/**
	 * 查询公共参数
	 * 
	 * @param paramTypeId
	 *            参数类型id
	 * @return
	 */
	@Select
	List<BasicParamValueDO> queryByTypeIdAndWarehouseIdIsNull(Long paramTypeId);

	/**
	 * 删除所有
	 * 
	 * @param paramTypeIds
	 *            参数类型id
	 * @return
	 */
	@Delete
	int deleteParamValueByParamTypeIds(String paramTypeIds);

	/**
	 * 删除某仓库的参数
	 * 
	 * @param paramTypeIds
	 *            参数类型id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Delete
	int deleteByTypeIdsAndWarehouseId(@Param("paramTypeIds") String paramTypeIds, @Param("warehouseId") Long warehouseId);

	/**
	 * 通过仓库id和参数类型编码 查询所有参数值
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param typeCode
	 *            参数类型编码
	 * @return
	 */
	@Select
	List<BasicParamValueDO> queryValueByParamCode(@Param("warehouseId") Long warehouseId, @Param("typeCode") String typeCode);
}
