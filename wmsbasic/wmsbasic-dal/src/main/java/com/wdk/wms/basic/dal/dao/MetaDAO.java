package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.BasicMetaDO;
import com.wdk.wms.basic.query.parameters.MetaQuery;

@Dao("basic_meta")
public interface MetaDAO {

	/**
	 * 根据模糊条件（code，name，modifer）查询meta，当其为空时，返回所有meta
	 */
	@Select
	public List<BasicMetaDO> queryMeta(MetaQuery queryParameter);

	/**
	 * 根据id查询meta
	 */
	@Select
	public BasicMetaDO queryMetaById(long id);

	/**
	 * 插入baseMeta
	 */
	@Insert
	public long insertMeta(BasicMetaDO baseMetaD);

	/**
	 * 根据id删除baseMeta
	 */
	@Delete
	public int deleteMetaById(long id);

	/**
	 * 更新baseMeta
	 */
	@Update
	public int updateMeta(BasicMetaDO baseMetaDO);


	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@Delete
	public int deleteMetaByIds(String ids);

	/**
	 * 通过code 查询
	 * 
	 * @param code
	 * @return
	 */
	@Select
	public BasicMetaDO queryMetaByCode(String code);

	@Select
	public int queryMetaCount(MetaQuery query);

}
