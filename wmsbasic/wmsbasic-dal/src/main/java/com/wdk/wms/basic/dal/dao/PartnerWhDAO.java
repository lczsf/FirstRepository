package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicPartnerWhDO;
import com.wdk.wms.basic.query.parameters.PartnerWhQuery;

@Dao("basic_partner_wh")
public interface PartnerWhDAO {
   
	@Insert
	public long insertPartnerWh(BasicPartnerWhDO basicPartnerWhDO);

	/**
	 * 查询库区类
	 * 
	 * @param partnerWhQuery
	 * @return
	 */
	@Select
	public List<BasicPartnerWhDO> querPartnerWarehouseArea(PartnerWhQuery partnerWhQuery);

	/**
	 * 
	 * 查询库位类
	 */
	@Select
	public List<BasicPartnerWhDO> querPartnerCabinet(PartnerWhQuery partnerWhQuery);

	@Update
	public Integer updatePartnerWh(BasicPartnerWhDO basicPartnerWhDO);
    
	@Select
	public List<BasicPartnerWhDO> queryPartnerWh(PartnerWhQuery partnerWhQuery);
    
	@Select
	public int queryPartnerWhCount(PartnerWhQuery partnerWhQuery);

	@Update
	public int updatePartnerWhStatus(@Param("status")int status, @Param("idList")String idList,
			@Param("idList")long operatorId);
}
