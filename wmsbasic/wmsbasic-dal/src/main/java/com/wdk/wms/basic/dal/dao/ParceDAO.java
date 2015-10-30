package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.ParcelDO;
import com.wdk.wms.basic.query.parameters.ParcelQuery;

/****
 * 
 * @author wb-cengxi 创建人：曾曦 创建时间：2015.9.30 修改时间：2015.9.30
 * 
 */
@Dao("parcel")
public interface ParceDAO {
	
	// 增加
	@Insert
	public long  insertBasicParcel(ParcelDO parcelDO);
	
	// 修改
	@Update
	public int updateBasicParcel(ParcelDO parcelDO);
	
	// 查找
	@Select
	public List<ParcelDO> queryBasicParce(ParcelQuery parcelQuery);
	
	// 分页(查询总行数)
	@Select
	public int queryCountBasicParcel (ParcelQuery parcelQuery);
	
	// //通过ID查询
	@Select
	public List<ParcelDO> queryById(@Param("batchId")long batchId,@Param("warehouseCode")long warehouseCode);
	
	@Select
	public ParcelDO queryByWaveId(@Param("waveId") long waveId, @Param("warehouseCode") long warehouseCode);
	
}
