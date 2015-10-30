package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.ParcelDO;
import com.wdk.wms.basic.query.parameters.ParcelQuery;
import com.wdk.wms.basic.result.PageResult;

/****
 * 
 * @author wb-cengxi 创建人：曾曦 创建时间：2015.9.29 修改时间：2015.9.29
 * 
 */
public interface ParceClientAPI {
	// 增加
	public long insertBasicParcel(ParcelDO parcelDO);

	// 修改
	public int updateBasicParcel(ParcelDO parcelDO);

	// 查找
	public List<ParcelDO> queryBasicParce(ParcelQuery parcelQuery);
	
	
	// 查询分页
	public PageResult<ParcelDO> queryPageBasicParcel(ParcelQuery parcelQuery);
	
	// 通过ID查询
	public List<ParcelDO> queryById(long Id,long warehouseId);

	/**
	 * 通过波次id，仓库id查询打包单列表
	 * 
	 * @param waveId
	 * @param warehouseId
	 * @return
	 */
	public ParcelDO queryByWaveId(long waveId, long warehouseId);
}
