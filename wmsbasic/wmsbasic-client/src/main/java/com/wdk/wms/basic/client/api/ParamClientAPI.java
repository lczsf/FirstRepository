package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.BasicParamTypeDO;
import com.wdk.wms.basic.query.parameters.ParamTypeQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:参数管理接口
 *
 * @author 刘勇
 * @Date 15/9/14
 */
public interface ParamClientAPI {

	/**
	 * 插入
	 * 
	 * @param paramTypeDO
	 *            参数类型 注意 参数值封装在参数类型 private List<BasicParamValueDO> paramValueDOs; 参数值需要注入仓库Id 对于全局，与仓无关的参数warehouseId为空
	 *
	 *            参数值实体 paramValue , 必填项（paramName, paramValue） 必填（warehouseId）
	 * @return
	 */
	Long inserParam(BasicParamTypeDO paramTypeDO);

	/**
	 * 更新
	 * 
	 * @param paramTypeDO
	 *            参数类型 需要更新的 参数值 封装进 List<BasicParamValueDO> paramValueDOs; 参数值实体仓库Id 对于全局，与仓无关的参数warehouseId设置为空
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	int updateParam(BasicParamTypeDO paramTypeDO, Long warehouseId);

	/**
	 * 分页查询
	 * 
	 * @param query
	 * @return
	 */
	PageResult<BasicParamTypeDO> queryParam(ParamTypeQuery query);

	/**
	 * 查询单独记录
	 * 
	 * @param id
	 *            typeId
	 * @param warehouseId
	 *            仓库id 为空只查询公共参数
	 * @return
	 */
	BasicParamTypeDO queryParamByTypeId(Long id, Long warehouseId);

	/**
	 * 删除参数类型 同事删除参数值
	 * 
	 * @param ids
	 *            id 例如：xx,xx,xx
	 * @return
	 */
	int deleteParam(String ids);

	/**
	 * 通过仓库id 参数类型编码 key 获取对应值
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param typeCode
	 *            类型编码
	 * @param paramName
	 *            键 key
	 * @return
	 */
	String queryValueByWhidAndCodeAndKey(Long warehouseId, String typeCode, String paramName);

	/**
	 * 通过流水号类型获取流水号
	 * 
	 * @param whId
	 *            仓库id
	 * @param orderType
	 *            单据类型
	 * @param serialType
	 *            流水号类型
	 * @return
	 */
	String querySerialNumber(Long whId, String orderType, String serialType);

	/**
	 * 校验是否可以包含小数和是否超过包含小数3为 并校验不可以为负数
	 * 
	 * @param quanity
	 *            数量
	 * @param unit
	 *            单位
	 * @see com.wdk.wms.basic.common.StaticConstants 可有小数单位集合
	 * @return true 通过 false 失败
	 */
	Boolean checkDecimal(Double quanity, String unit);

	/**
	 * 库存数量 转换 或 反转换 1.标品 -> 库存数量: 数量与库存数量对等 2.非标品 -> 库存数量: 销售数量 * 库存系数 3.库存数量 -> 非标品销售数量: 库存数量 / 库存系数
	 *
	 * @param itemId
	 *            商品id
	 * @param sellQuanity
	 *            需要转换的数量
	 * @param whId
	 *            仓库id
	 * @param isInventory
	 *            是否库存数量 是：true 乘 否：false 除 销售数量
	 *
	 * @return
	 */
	Double quanityTransform(long itemId, double sellQuanity, long whId, boolean isInventory);
}
