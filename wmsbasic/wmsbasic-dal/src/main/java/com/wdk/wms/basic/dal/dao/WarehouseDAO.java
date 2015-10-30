package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.query.parameters.WarehouseQuery;

@Dao("basic_warehouse")
public interface WarehouseDAO {
	/**
	 * 根据模糊条件（）查询meta，当其为空时，返回所有meta
	 */
	@Select
	public List<BasicWarehouseDO> queryWarehouse(WarehouseQuery warehouseQuery);
	
	/**
	 * 插入basicWarehouse
	 */
	@Insert
	public long insertWarehouse(BasicWarehouseDO basicWarehouseD);
	
	@Update
	public Integer updateWarehouse(BasicWarehouseDO basicWarehouseD);
	
	@Select 
	public int queryWarehouseCount(WarehouseQuery warehouseQuery);
    
	@Update
	public Integer updateWarehouseStatus(@Param("status") int status,@Param("idList") String idList,@Param("operatorId") long operatorId);
	
	@Select
	public BasicWarehouseDO queryWarehouseById(long id);
	
	@Select
	public List<BasicWarehouseDO> queryWarehouseByIds(String idList);

	@Select
	public String querWarehouseNameById(long id);

	@Select
	public Long queryIdByWarehouseCode(Long warehouseCode);

	@Select
	public Long queryWarehouseCodeById(Long id);

	@Select
	public BasicWarehouseDO queryWarehouseByCode(String code);
}
