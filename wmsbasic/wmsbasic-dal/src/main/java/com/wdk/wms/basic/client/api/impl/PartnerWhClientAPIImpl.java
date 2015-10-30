package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.PartnerWhClientAPI;
import com.wdk.wms.basic.dal.dao.PartnerWhDAO;
import com.wdk.wms.basic.daoobject.BasicPartnerWhDO;
import com.wdk.wms.basic.query.parameters.PartnerWhQuery;
import com.wdk.wms.basic.result.PageResult;

public class PartnerWhClientAPIImpl implements PartnerWhClientAPI {
	
	@Autowired
    private PartnerWhDAO partnerWhDAO;
	
	@Override
	public long insertPartnerWh(BasicPartnerWhDO basicPartnerWhDO)
			throws Exception {
		
		return partnerWhDAO.insertPartnerWh(basicPartnerWhDO);
	}
	
	@Override
	public Integer updatePartnerWh(BasicPartnerWhDO basicPartnerWhDO) {
		 
		return partnerWhDAO.updatePartnerWh(basicPartnerWhDO);
	}

	@Override
	public PageResult<BasicPartnerWhDO> queryPartnerWhPage(
			PartnerWhQuery partnerWhQuery) {
		        // 返回数据
				PageResult<BasicPartnerWhDO> response = new PageResult<BasicPartnerWhDO>();

				List<BasicPartnerWhDO> results;

				// 当前页数据
				results = partnerWhDAO.queryPartnerWh(partnerWhQuery);
				// 总条数
				int count = partnerWhDAO.queryPartnerWhCount(partnerWhQuery);

				response.setNum(partnerWhQuery.getNum());
				response.setTotalNum(count);
				response.setList(results);
				response.setIndex(partnerWhQuery.getIndex());
				return response;
	}

	@Override
	public boolean updatePartnerWhStatus(int status, String idList,
			long operatorId) {
		 if(partnerWhDAO.updatePartnerWhStatus(status, idList,operatorId)!=0)
			 return true;
		return false;
	}

}
