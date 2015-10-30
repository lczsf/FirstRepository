package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.WcsWaveCompleteDO;

@Dao("wcs_wave_complete")
public interface WcsWaveCompleteDAO {

	/**
	 * 插入
	 * 
	 * @param db
	 * @return
	 */
	@Insert
	Long insertWcsWaveComplete(WcsWaveCompleteDO db);

	/**
	 * 根据id更新状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@Update
	int updateStatus(@Param("id") Long id, @Param("status") Integer status);

	@Update
	int updateFailureTimes(@Param("id") Long id);

	/**
	 * 查询第一条待发送状态的记录
	 * 
	 * @return
	 */
	@Select
	WcsWaveCompleteDO queryFirstUnsentRecord();

	@Select
	List<WcsWaveCompleteDO> queryUnsentRecord();
}
