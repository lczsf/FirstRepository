package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicWarehouseAreaDO;
import com.wdk.wms.basic.query.parameters.WarehouseAreaQuery;

@Dao("basic_warehouse_area")
public interface WarehouseAreaDAO {
	/**
	 * 
	 */
	@Select
	public List<BasicWarehouseAreaDO> queryWarehouseArea(WarehouseAreaQuery warehouseAreaQueryParameter);
	
	/**
	 * 插入basicWarehouseArea 
	 */
	@Insert
	public long insertWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaD);
	
	@Update
	public Integer updateWarehouseArea(BasicWarehouseAreaDO basicWarehouseAreaD);
	
	@Select 
	public int queryWarehouseAreaCount(WarehouseAreaQuery warehouseAreaQueryParameter);
    
	@Update
	public Integer updateWarehouseAreaStatus(@Param("status") int status,@Param("idList") String idList,@Param("operatorId") long operatorId);
	
	@Select
	public BasicWarehouseAreaDO queryWarehouseAreaById(long id);
}
