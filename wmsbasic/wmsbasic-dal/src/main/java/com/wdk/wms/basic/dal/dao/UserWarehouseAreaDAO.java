package com.wdk.wms.basic.dal.dao;

import java.util.List;
import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicUserWarehouseAreaDO;
import com.wdk.wms.basic.query.parameters.UserWarehouseAreaQuery;

@Dao("basic_user_warehouse_area")
public interface UserWarehouseAreaDAO {
	/**
	 * 
	 */
	@Select
	public List<BasicUserWarehouseAreaDO> queryUserWarehouseArea(UserWarehouseAreaQuery userwarehouseAreaQuery);
	
	/**
	 * 插入basicUserWarehousearea 
	 */
	@Insert
	public long insertUserWarehouseArea(BasicUserWarehouseAreaDO basicUserWarehouseAreaDO);
	
	@Update
	public Integer updateUserWarehouseArea(BasicUserWarehouseAreaDO basicUserWarehouseAreaDO);
	
	@Select 
	public int queryUserWarehouseAreaCount(UserWarehouseAreaQuery userWarehouseAreaQuery);
	
	@Select
	public BasicUserWarehouseAreaDO queryUserWarehouseAreaById(long id);
    
}
