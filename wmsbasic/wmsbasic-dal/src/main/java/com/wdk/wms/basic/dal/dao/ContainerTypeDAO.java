package com.wdk.wms.basic.dal.dao;

import java.util.List;
import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicContainerTypeDO;
import com.wdk.wms.basic.query.parameters.ContainerTypeQuery;

@Dao("basic_container_type")
public interface ContainerTypeDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<BasicContainerTypeDO> queryContainerType(ContainerTypeQuery containerTypeQuery);
	
	/**
	 * 插入basicContainerDO 
	 */
	@Insert
	public long insertContainerType(BasicContainerTypeDO basicContainerTypeDO);
	
	@Update
	public Integer updateContainerType(BasicContainerTypeDO basicContainerTypeDO);
	
	@Select 
	public int queryContainerTypeCount(ContainerTypeQuery containerTypeQuery);
    
	@Update
	public Integer updateContainerTypeStatus(@Param("status") int status,@Param("idList") String idList,@Param("operatorId") long operatorId);
	
	@Select
	public BasicContainerTypeDO queryContainerTypeById(long id);
}
