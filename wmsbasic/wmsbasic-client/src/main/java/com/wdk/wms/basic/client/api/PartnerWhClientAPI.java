package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.BasicPartnerWhDO;
import com.wdk.wms.basic.query.parameters.PartnerWhQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:商业合作伙伴库区库位关联关系
 * 
 * @author 李超 Date 2015-09-07
 */
public interface PartnerWhClientAPI {
	/**
	 * 默认状态status为1新增货主库区关系
	 * 
	 * @param basicPartnerWhDO
	 *            容器库区关系DO
	 * @return
	 * @throws Exception
	 */
		public long insertPartnerWh(BasicPartnerWhDO basicPartnerWhDO) throws Exception;
		
	/**
	 * 根据Id修改数据
	 * 
	 * @param basicPartnerWhDO
	 *            容器库区关系DO
	 * @return
	 */
		public Integer updatePartnerWh(BasicPartnerWhDO basicPartnerWhDO);
		
	/**
	 * 分页查询数据
	 * 
	 * @param partnerWhQuery
	 *            容器库区关系Query
	 * @return
	 */
		public PageResult<BasicPartnerWhDO> queryPartnerWhPage(PartnerWhQuery partnerWhQuery);
		
	/**
	 * 启用停用接口
	 * 
	 * @param status
	 *            状态status
	 * @param idList
	 *            id串，用","分隔
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
		public boolean updatePartnerWhStatus(int status ,String idList,long operatorId);
}
