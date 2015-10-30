package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BasicUserWarehouseAreaDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseAreaDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.query.parameters.UserWarehouseAreaQuery;
import com.wdk.wms.basic.query.parameters.WarehouseAreaQuery;
import com.wdk.wms.basic.query.parameters.WarehouseQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:仓库，库区，用户库区关系
 * 
 * @author 李超 Date 2015-09-07
 */
public interface WarehouseClientAPI {
	/**
	 * 仓库接口列表
	 */

	/**
	 * 新增仓库 ， 默认状态status为1
	 * 
	 * @param basicWarehouseDO
	 *            仓库DO
	 * @return
	 */
	public long insertWarehouse(BasicWarehouseDO basicWarehouseDO);

	/**
	 * 查询仓库
	 * 
	 * @param warehouseQuery
	 *            仓库Query
	 * @return
	 */
	public List<BasicWarehouseDO> queryWarehouse(WarehouseQuery warehouseQuery);
	

	/**
	 * 根据Id修改数据
	 * 
	 * @param basicWarehouseDO
	 *            仓库DO
	 * @return
	 */
	public Integer updateWarehouse(BasicWarehouseDO basicWarehouseDO);

	/**
	 * 分页查询仓库信息
	 * 
	 * @param warehouseQuery
	 *            仓库Query
	 * @return
	 */
	public PageResult<BasicWarehouseDO> queryWarehousePage(
			WarehouseQuery warehouseQuery);

	/**
	 * 启用停用仓库接口
	 * 
	 * @param status
	 *            状态status
	 * @param idList
	 *            id串，用","分隔
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
	public boolean updateWarehouseStatus(int status, String idList,
			long operatorId);

	/**
	 * 根据Id查询仓库
	 * 
	 * @param id
	 *            仓库id
	 * @return
	 */
	public BasicWarehouseDO queryWarehouseById(long id);

	/**
	 * 根据id查询仓库名字
	 * 
	 * @param id
	 *            仓库id
	 * @return
	 */
	public String queryWarehouseNameById(long id);

	/**
	 * 将区域接口放在此API中
	 */
	/**
	 * 默认状态status为1
	 * 
	 * @param basicWarehouseAreaDO
	 *            库区DO
	 * @return
	 */
	public long insertWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaDO);

	/**
	 * 查询库区
	 * 
	 * @param warehouseAreaQuery
	 *            库区Query
	 * @return
	 */
	public List<BasicWarehouseAreaDO> queryWarehouseArea(
			WarehouseAreaQuery warehouseAreaQuery);

	/**
	 * 根据Id修改数据
	 * 
	 * @param basicWarehouseAreaDO
	 *            库区DO
	 * @return
	 */
	public Integer updateWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaDO);

	/**
	 * 分页查询库区
	 * 
	 * @param warehouseAreaQuery
	 *            库区Query
	 * @return
	 */
	public PageResult<BasicWarehouseAreaDO> queryWarehouseAreaPage(
			WarehouseAreaQuery warehouseAreaQuery);

	/**
	 * 启用停用库区接口
	 * 
	 * @param status
	 *            状态status
	 * @param idList
	 *            库区id串，用","分隔
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
	public boolean updateWarehouseAreaStatus(int status, String idList,
			long operatorId);

	/**
	 * 根据id查询数据
	 * 
	 * @param id
	 *            库区id
	 * @return
	 */

	public BasicWarehouseAreaDO queryWarehouseAreaById(long id);

	/**
	 * 用户库区关系接口
	 */
	/**
	 * 新增用户库区关系数据
	 * 
	 * @param basicUserWarehouseAreaDO
	 *            用户库区关系DO
	 * @return
	 */
	public long insertUserWarehouseArea(
			BasicUserWarehouseAreaDO basicUserWarehouseAreaDO);

	/**
	 * 分页查询用户库区信息
	 * 
	 * @param userWarehouseAreaQuery
	 *            用户库区关系Query
	 * @return
	 */
	public PageResult<BasicUserWarehouseAreaDO> queryUserWarehouseAreaPage(
			UserWarehouseAreaQuery userWarehouseAreaQuery);

	/**
	 * 根据id修改用户库区关系
	 * 
	 * @param basicUserWarehouseAreaDO
	 *            用户库区关系DO
	 * @return
	 */
	public boolean updateUserWarehouseArea(
			BasicUserWarehouseAreaDO basicUserWarehouseAreaDO);

	/**
	 * 根据id查询数据
	 * 
	 * @param id
	 *            用户库区关系id
	 * @return
	 */
	public BasicUserWarehouseAreaDO queryUserWarehouseAreaById(long id);

	/**
	 * 通过 分表code 查询id
	 * 
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	public Long queryIdByWarehouseCode(Long warehouseCode);

	/**
	 * 通过仓库id 获取 分表code
	 * 
	 * @param wId
	 * @return
	 */
	public Long queryWarehouseCodeById(Long wId);

	/**
	 * 根据仓库code查询仓库
	 * 
	 * @param Code
	 *            仓库code
	 * @return
	 */
	public BasicWarehouseDO queryWarehouseByCode(String code);
}
