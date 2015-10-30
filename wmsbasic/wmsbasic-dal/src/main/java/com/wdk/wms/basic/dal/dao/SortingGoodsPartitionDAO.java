package com.wdk.wms.basic.dal.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionDO;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionQuery;

@Dao("sorting_goods_partition")
public interface SortingGoodsPartitionDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<SortingGoodsPartitionDO> querySortingGoodsPartition(SortingGoodsPartitionQuery sortingGoodsPartitionQuery);
	
	/**
	 * 插入SortingGoodsPartitionDO
	 */
	@Insert
	public long insertSortingGoodsPartition(SortingGoodsPartitionDO sortingGoodsPartitionDO);
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@Delete
	public int deleteSortingGoodsPartitionById(long id);

	/**
	 * 计算总数
	 * 
	 * @param sortingGoodsPartitionQuery
	 * @return
	 */
	@Select
	public int querySortingGoodsPartitionCount(SortingGoodsPartitionQuery sortingGoodsPartitionQuery);

	/**
	 * 根据id查询拣货区
	 * 
	 * @param id
	 * @return
	 */
	@Select
	public SortingGoodsPartitionDO querySortingGoodsPartitionById(long id);

	/**
	 * 修改拣货区信息
	 * 
	 * @param sortingGoodsPartitionDO
	 * @return
	 */
	@Update
	public int updateSortingGoodsPartition(SortingGoodsPartitionDO sortingGoodsPartitionDO);

	@Select
	public List<Long> queryIdByCodeList(Map<String, List<String>> codeList);

	@Select
	public List<SortingGoodsPartitionDO> queryByCodes(@Param("codes") List<String> codes, @Param("warehouseId") long warehouseId);

	@Select
	public SortingGoodsPartitionDO querySortingGoodsPartitionByCode(@Param("pickingAreaCode") String pickingAreaCode, @Param("warehouseId") long warehouseId);
}
