package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BasicContainerDO;
import com.wdk.wms.basic.daoobject.BasicContainerTypeDO;
import com.wdk.wms.basic.query.parameters.ContainerQuery;
import com.wdk.wms.basic.query.parameters.ContainerTypeQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:容器接口，容器类型接口
 * 
 * @author 李超 Date 2015-09-07
 */
public interface ContainerClientAPI {

	/**
	 * 新增容器默认状态status为1
	 * 
	 * @param basicContainerDO
	 *            容器DO
	 * @return
	 * @throws Exception
	 */
	public long insertContainer(BasicContainerDO basicContainerDO) throws Exception;

	/**
	 * 查询容器
	 * 
	 * @param containerQuery
	 *            容器Query
	 * @return
	 */
	public List<BasicContainerDO> queryContainer(ContainerQuery containerQuery);

	/**
	 * 根据容器id修改容器
	 * 
	 * @param basicContainerDO
	 *            容器DO
	 * @return
	 */
	public Integer updateContainer(BasicContainerDO basicContainerDO);

	/**
	 * 分页查询容器信息
	 * 
	 * @param containerQuery
	 *            容器Query
	 * @return
	 */
	public PageResult<BasicContainerDO> queryContainerPage(ContainerQuery containerQuery);

	/**
	 * 启用停用接口
	 * 
	 * @param status
	 *            状态status
	 * @param idList
	 *            id串,用“,”分隔
	 * @param operatorId
	 * @return
	 */
	public boolean updateContainerStatus(int status, String idList, long operatorId);

	/**
	 * 根据id查询容器
	 * 
	 * @param id
	 *            容器id
	 * @return
	 */
	public BasicContainerDO queryContainerById(long id);

	/**
	 * 根据仓库id，容器条码查询容器对象
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param containerBarcode
	 *            容器条码
	 * @return
	 */
	public BasicContainerDO queryContainerByCode(long warehouseId, String containerBarcode);

	/**
	 * 根据仓库id，容器code修改容器状态status
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param containerCode
	 *            容器code
	 * @param status
	 *            状态status
	 * @param operatorId
	 *            操作人Id
	 * @return
	 *
	 */
	public boolean updateStatusByContainerCode(long warehouseId, String containerCode, int status, long operatorId);

	/**
	 * 容器类型接口
	 */

	/**
	 * 默认状态status为1新增容器类型数据
	 * 
	 * @param basicContainerTypeDO
	 *            容器类型DO
	 * @return
	 */
	public long insertContainerType(BasicContainerTypeDO basicContainerTypeDO);

	/**
	 * 查询容器类型
	 * 
	 * @param containerTypeQuery
	 *            容器类型Query
	 * @return
	 */
	public List<BasicContainerTypeDO> queryContainerType(ContainerTypeQuery containerTypeQuery);

	/**
	 * 根据Id修改数据
	 * 
	 * @param basicContainerTypeDO
	 *            容器类型DO
	 * @return
	 */
	public Integer updateContainerType(BasicContainerTypeDO basicContainerTypeDO);

	/**
	 * 分页查询容器类型信息
	 * 
	 * @param containerQueryType容器类型Query
	 * @return
	 */
	public PageResult<BasicContainerTypeDO> queryContainerTypePage(ContainerTypeQuery containerQueryType);

	/**
	 * 启用停用接口
	 * 
	 * @param status
	 *            状态status
	 * @param idList
	 *            id串，用","分隔
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
	public boolean updateContainerTypeStatus(int status, String idList, long operatorId);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 *            容器类型id
	 * @return
	 */
	public BasicContainerTypeDO queryContainerTypeById(long id);

	/**
	 * 批量插入容器列表
	 * 
	 * @param containerList
	 * @return
	 */
	public long insertContainerList(List<BasicContainerDO> containerList);
	/**
	 * 根据容器code更新状态
	 * @param status
	 * @param containerCodes
	 * containerCode 串，用","分隔
	 * @param operatorId
	 * @return
	 */
	public boolean  updateContainerStatusByCodes(int status, List<String> containerCodes, long operatorId);
}
