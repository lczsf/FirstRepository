package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.ArtificialTaskDO;
import com.wdk.wms.basic.query.parameters.ArtificialTaskQuery;

@Dao("artificial_task")
public interface ArtificialTaskDAO {

	@Insert
	public long insertArtificialTask(ArtificialTaskDO artificialTaskDO);

	@Select
	public List<ArtificialTaskDO> queryArtificialTask(ArtificialTaskQuery artificialTaskQuery);

	@Select
	public int queryArtificialTaskCount(ArtificialTaskQuery artificialTaskQuery);
	
	@Select
	public ArtificialTaskDO queryArtificialTaskById(@Param("id") Long id, @Param("warehouseCode") Long warehouseCode);

	@Update
	public int updateStatus(@Param("id") Long id, @Param("warehouseCode") Long warehouseCode, @Param("preStatus") Integer preStatus,
			@Param("nowStatus") Integer nowStatus);
}
