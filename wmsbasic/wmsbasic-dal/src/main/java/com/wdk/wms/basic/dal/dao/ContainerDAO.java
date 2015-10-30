package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicContainerDO;
import com.wdk.wms.basic.query.parameters.ContainerQuery;

@Dao("basic_container")
public interface ContainerDAO {
	/**
	 * 根据模糊条件（）
	 */
	@Select
	public List<BasicContainerDO> queryContainer(ContainerQuery containerQuery);
	
	/**
	 * 插入basicContainerDO
	 */
	@Insert
	public long insertContainer(BasicContainerDO basicContainerDO);
	
	@Update
	public Integer updateContainer(BasicContainerDO basicContainerDO);
	
	@Select 
	public int queryContainerCount(ContainerQuery containerQuery);
    
	@Update
	public Integer updateContainerStatus(@Param("status") int status,@Param("idList") String idList,@Param("operatorId") long operatorId);
	
	@Select
	public BasicContainerDO queryContainerById(long id);
	
	@Select 
	public BasicContainerDO queryContainerByCode(@Param("warehouseId") long warehouseId, @Param("code") String code);

	@Update
	public int updateStatusByContainerCode(@Param("warehouseId") long warehouseId, @Param("containerCode") String containerCode, @Param("status") int status,
			@Param("operatorId") long operatorId);

	@Insert
	public long insertContainerList(@Param("containerList") List<BasicContainerDO> containerList);
	
	@Update
	public int updateContainerByCodes(@Param("status") int status, @Param("containerCodes") List<String> containerCodes,@Param("warehouseId") long  warehouseId,@Param("operatorId") long operatorId);
	
}
