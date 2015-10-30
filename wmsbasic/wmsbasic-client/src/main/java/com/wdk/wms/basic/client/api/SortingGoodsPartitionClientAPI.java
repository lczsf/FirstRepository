package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.SortingGoodsPartitionCabinetDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionUserDO;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionCabinetQuery;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionQuery;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionUserQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:拣货分区，拣货分区用户关系，拣货分区库位关系
 * 
 * @author 李超 Date 2015-09-07
 */
public interface SortingGoodsPartitionClientAPI {
	/**
	 * 拣货区接口
	 */

	/**
	 * 查询拣货区
	 * 
	 * @param sortingGoodsPartition
	 * @return
	 */
	public PageResult<SortingGoodsPartitionDO> querySortingGoodsPartition(SortingGoodsPartitionQuery sortingGoodsPartitionQuery);

	/**
	 * 根据id查询拣货区
	 * 
	 * @param id
	 * @return
	 */
	public SortingGoodsPartitionDO querySortingGoodsPartitionById(long id);

	/**
	 * 插入拣货区
	 * 
	 * @param sortingGoodsPartitionDO
	 * @return
	 */
	public long insertSortingGoodsPartition(SortingGoodsPartitionDO sortingGoodsPartitionDO);

	/**
	 * 删除拣货区
	 * 
	 * @param id
	 * @return
	 */
	public int deleteSortingGoodsPartitionById(long id);

	/**
	 * 修改拣货区信息
	 * 
	 * @param sortingGoodsPartitionDO
	 * @return
	 */
	public int updateSortingGoodsPartition(SortingGoodsPartitionDO sortingGoodsPartitionDO);
	
	/**
	 * 库位拣货区关联表接口
	 */

	/**
	 * 根据拣货区id获取关联信息列表（分页）
	 * 
	 * @param sortingGoodsPartitionId
	 *            拣货区id
	 * @return
	 */
	public List<SortingGoodsPartitionCabinetDO> queryBySortingGoodsPartitionId(long sortingGoodsPartitionId);
	
	/**
	 * 查询库位拣货区关联信息列表
	 * 
	 * @param sortingGoodsPartitionCabinetQuery
	 * @return
	 */
	public PageResult<SortingGoodsPartitionCabinetDO> querySortingGoodsPartitionCabinet(SortingGoodsPartitionCabinetQuery sortingGoodsPartitionCabinetQuery);


	/**
	 * 用户拣货区关联表接口
	 */

	/**
	 * 查询用户拣货区关联表信息列表（分页）
	 * 
	 * @param sortingGoodsPartitionUserQuery
	 * @return
	 */
	public PageResult<SortingGoodsPartitionUserDO> querySortingGoodsPartitionUser(SortingGoodsPartitionUserQuery sortingGoodsPartitionUserQuery);

	/**
	 * 插入用户拣货区关联表信息
	 * 
	 * @param sortingGoodsPartitionUserDO
	 * @return
	 */
	public long insertSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO);

	/**
	 * 用户拣货分区修改
	 * 
	 * @param sortingGoodsPartitionUserDO
	 * @return
	 */
	public int updateSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO);

	/**
	 * 删除用户拣货区关联表信息
	 * 
	 * @param id
	 *            主键id
	 * @return
	 */
	public int deleteSortingGoodsPartitionUserById(long id);

	/**
	 * 根据id查询用户拣货区关联信息
	 * 
	 * @param id
	 *            用户拣货区关联表主键id
	 * @return
	 */
	public SortingGoodsPartitionUserDO querySortingGoodsPartitionUserDOById(long id);

	/**
	 * 根据用户id和仓库id查询拣货分区code集合
	 * 
	 * @param userId
	 *            用户id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<String> queryCodeByUserIdAndWarehouseId(long userId, long warehouseId);

	/**
	 * 根据code集合和仓库id查询拣货分区集合
	 * 
	 * @param codes
	 * @param warehouseId
	 * @return
	 */
	public List<SortingGoodsPartitionDO> queryByCodes(List<String> codes, long warehouseId);
	
	/**
	 * 查询拣货分区编码
	 * 
	 * @param cabinetId
	 *            库位id
	 * @param areaType
	 *            区域类型
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public String queryByCabinetIdAndType(long cabinetId, int areaType, long warehouseId);

}
