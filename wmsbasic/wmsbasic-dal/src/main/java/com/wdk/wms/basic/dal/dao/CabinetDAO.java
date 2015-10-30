package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.query.parameters.CabinetQuery;

@Dao("basic_cabinet")
public interface CabinetDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<BasicCabinetDO> queryCabinet(CabinetQuery cabinetQueryParameter);
	
	/**
	 * 插入basicCabinetDO
	 */
	@Insert
	public long insertCabinet(BasicCabinetDO basicCabinetDO);
	
	@Update
	public Integer updateCabinet(BasicCabinetDO basicCabinetDO);
	
	@Select 
	public int queryCabinetCount(CabinetQuery cabinetQueryParameter);
    
	@Update
	public Integer updateCabinetStatus(@Param("status") int status,@Param("idList") String idList,@Param("operatorId") long operaterId);
	
	@Select
	public BasicCabinetDO queryCabinetById(long id);

	@Select
	public BasicCabinetDO queryBycabinetCode(@Param("warehouseId") Long warehouseId, @Param("cabinetCode") String cabinetCode);

	@Select
	public long queryDefaultCabinetId();

	@Select
	public List<BasicCabinetDO> queryCabinetByIds(@Param("ids") List<Long> ids);
	
	@Select
	public List<BasicCabinetDO> unAllocatedCabinet(@Param("sortingType") int sortingType, @Param("warehouseId") long warehouseId);

	@Insert
	public long insertCabinetList(@Param("cabinetList") List<BasicCabinetDO> cabinetList);

	@Select
	public List<Long> queryIdsByTypeAndIsActive(@Param("cabinetType") int[] cabinetType, @Param("isActive") int isActive, @Param("warehouseId") long warehouseId);
}
