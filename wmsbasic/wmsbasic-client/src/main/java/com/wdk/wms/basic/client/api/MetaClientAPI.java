package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.BasicMetaDO;
import com.wdk.wms.basic.daoobject.DictDO;
import com.wdk.wms.basic.query.parameters.MetaQuery;
import com.wdk.wms.basic.result.PageResult;

import java.util.List;

/**
 * 数据字典管理接口
 * 
 * @author 刘勇
 */
public interface MetaClientAPI {

	/**
	 * 插入 basic_meta
	 * 
	 * @param baseMetaDO
	 * @return
	 */
	public long insertMeta(BasicMetaDO baseMetaDO);


	/**
	 * 通过id查询
	 * @param id
	 */
	public BasicMetaDO queryMetaById(Long id);

	/**
	 * 通过ids批量删除  连带删除字表数据 例如：xx,xx,xx
	 * @param ids
	 * @return
	 */
	int deleteByIds(String ids);

	/**
	 * 更新
	 * @param metaDO
	 * @return
	 */
	int updateMeta(BasicMetaDO metaDO);


	/**
	 * 分页查询 begin 第几条开始 num 每页多少条
	 * 
	 * @param queryParameter
	 * @return
	 */
	PageResult<BasicMetaDO> queryMeta(MetaQuery queryParameter);

	/**
	 * 查询code对应value
	 * 
	 * @param code
	 * @return key-value
	 */
	List<DictDO> queryDictsByCode(String code);

}
