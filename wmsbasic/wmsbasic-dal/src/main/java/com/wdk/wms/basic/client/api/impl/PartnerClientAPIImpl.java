package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.PartnerClientAPI;
import com.wdk.wms.basic.dal.dao.PartnerDAO;
import com.wdk.wms.basic.daoobject.BasicPartnerDO;
import com.wdk.wms.basic.query.parameters.PartnerQuery;
import com.wdk.wms.basic.result.PageResult;

public class PartnerClientAPIImpl implements PartnerClientAPI {

	@Autowired
	private PartnerDAO partnerDAO;

	@Override
	public long insertPartner(BasicPartnerDO basicPartnerDO) {
		return partnerDAO.insertPartner(basicPartnerDO);
	}

	@Override
	public int deleteBasicPartnerByIds(String ids) {
		return partnerDAO.deleteBasicPartnerByIds(ids);
	}

	@Override
	public int updateBasicPartnerDO(BasicPartnerDO basicPartnerDO) {
		return partnerDAO.updateBasicPartnerDO(basicPartnerDO);
	}

	@Override
	public PageResult<BasicPartnerDO> queryBasicPartnerPage(PartnerQuery queryParameter) {

		PageResult<BasicPartnerDO> response = new PageResult<BasicPartnerDO>();
		List<BasicPartnerDO> results = new ArrayList<BasicPartnerDO>();
		results = partnerDAO.queryBasicPartner(queryParameter);
		response.setList(results);

		int begin = queryParameter.getIndex() * queryParameter.getNum();
		queryParameter.setBegin(begin);

		// 总条数
		int count = partnerDAO.queryBasicPartnerCount(queryParameter);

		response.setNum(queryParameter.getNum());
		response.setTotalNum(count);
		response.setIndex(queryParameter.getIndex());
		return response;
	}

	@Override
	public int updateParnerStatus(String ids, int status, long operaterId) {
		return partnerDAO.updateParnerStatus(ids, status, operaterId);
	}

	@Override
	public BasicPartnerDO queryBasicPartnerById(long id) {
		return partnerDAO.queryBasicPartnerById(id);
	}

	@Override
	public BasicPartnerDO queryBasicPartnerByCode(String code, Integer partnerType, Long warehouseId) {

		return partnerDAO.queryBasicPartnerByCode(code, partnerType, warehouseId);
	}

}
