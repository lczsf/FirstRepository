package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionUserDO;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionUserQuery;

@Dao("sorting_goods_partition_user")
public interface SortingGoodsPartitionUserDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<SortingGoodsPartitionUserDO> querySortingGoodsPartitionUser(SortingGoodsPartitionUserQuery sortingGoodsPartitionUserQuery);

	
	/**
	 * 插入SortingGoodsPartitionDO
	 */
	@Insert
	public long insertSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO);
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@Delete
	public int deleteSortingGoodsPartitioUsernById(long id);

	/**
	 * 计算总数
	 * 
	 * @param id
	 * @return
	 */
	@Select
	public int querySortingGoodsPartitionUserCount(SortingGoodsPartitionUserQuery sortingGoodsPartitionUserQuery);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@Select
	public SortingGoodsPartitionUserDO querySortingGoodsPartitionUserById(long id);

	/**
	 * 根据用户id，仓库id查询
	 * 
	 * @param userId
	 *            用户id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	@Select
	public List<SortingGoodsPartitionUserDO> queryByUserIdAndWarehouseId(@Param("userId") long userId, @Param("warehouseId") long warehouseId);


	@Update
	public int updateSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO);
}
