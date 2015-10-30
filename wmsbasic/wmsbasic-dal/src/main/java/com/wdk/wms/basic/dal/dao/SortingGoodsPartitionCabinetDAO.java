package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionCabinetDO;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionCabinetQuery;

@Dao("sorting_goods_partition_cabinet")
public interface SortingGoodsPartitionCabinetDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<SortingGoodsPartitionCabinetDO> querySortingGoodsPartitionCabinet(SortingGoodsPartitionCabinetQuery sortingGoodsPartitionCabinetQuery);

	/**
	 * 根据sortingGoodsPartitionId条件（）
	 */
	@Select
	public List<SortingGoodsPartitionCabinetDO> queryByWarehouseIdAndPartitionCode(@Param("warehouseId") Long warehouseId,
			@Param("sortingGoodsPartitionCode") String sortingGoodsPartitionCode);
	
	/**
	 * 插入SortingGoodsPartitionDO
	 */
	@Insert
	public long insertSortingGoodsPartitionCabinet(SortingGoodsPartitionCabinetDO sortingGoodsPartitionCabinetDO);
	
	/**
	 * 删除
	 * 
	 * @param sortingGoodsPartitionCode
	 * @return
	 */
	@Delete
	public int deleteByWarehouseIdAndPartitionCode(@Param("warehouseId") Long warehouseId, @Param("sortingGoodsPartitionCode") String sortingGoodsPartitionCode);

	/**
	 * 计算总数
	 * 
	 * @param id
	 * @return
	 */
	@Select
	public int querySortingGoodsPartitionCabinetCount(SortingGoodsPartitionCabinetQuery sortingGoodsPartitionCabinetQuery);

	/**
	 * 修改拣货区信息
	 * 
	 * @param sortingGoodsPartitionCabinetDO
	 * @return
	 */
	@Update
	public int updateSortingGoodsPartitionCabinet(SortingGoodsPartitionCabinetDO sortingGoodsPartitionCabinetDO);

	/**
	 * 查询拣货分区code
	 * 
	 * @param cabinetId
	 * @param areaType
	 * @param warehouseId
	 * @return
	 */
	@Select
	public String queryByCabinetIdAndType(@Param("cabinetId") long cabinetId, @Param("areaType") int areaType, @Param("warehouseId") long warehouseId);
}
