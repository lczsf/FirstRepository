package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.CabinetClientAPI;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.query.parameters.CabinetQuery;
import com.wdk.wms.basic.result.PageResult;

public class CabinetClientAPIImpl implements CabinetClientAPI {
	
	@Autowired
	private CabinetDAO cabinetDao;
	@Override
	public long insertCabinet(BasicCabinetDO basicCabinetDO) throws Exception {
		// 校验编码是否重复
		CabinetQuery cabinetQuery =new CabinetQuery();
		cabinetQuery.setCode(basicCabinetDO.getCode());
		if(cabinetDao.queryCabinet(cabinetQuery).size()==1&&cabinetQuery.getCode()!=null)
			throw new Exception("库位编码已存在！请重新输入！");
		
		return cabinetDao.insertCabinet(basicCabinetDO);
	}

	@Override
	public List<BasicCabinetDO> queryCabinet(CabinetQuery cabinetQuery) {
		
		return cabinetDao.queryCabinet(cabinetQuery);
	}

	@Override
	public Integer updateCabinet(BasicCabinetDO basicCabinetDO) {
		
		return cabinetDao.updateCabinet(basicCabinetDO);
	}

	@Override
	public PageResult<BasicCabinetDO> queryCabinetPage(
			CabinetQuery cabinetQuery) {
		PageResult<BasicCabinetDO> response=new PageResult<BasicCabinetDO>();
		List<BasicCabinetDO> results;
		
		// 当前页数据
		results= cabinetDao.queryCabinet(cabinetQuery);
		// 总条数
		int count = cabinetDao.queryCabinetCount(cabinetQuery);
		response.setNum(cabinetQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(cabinetQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateCabinetStatus(int status, String idList,long operatorId) {
		if(cabinetDao.updateCabinetStatus(status, idList,operatorId)!=0)
			return true;
		return false;
	}

	@Override
	public BasicCabinetDO queryCabinetById(long id) {
			return cabinetDao.queryCabinetById(id);
	}

	@Override
	public BasicCabinetDO queryBycabinetCode(Long warehouseId, String cabinetCode) {

		return cabinetDao.queryBycabinetCode(warehouseId, cabinetCode);
	}

	@Override
	public List<BasicCabinetDO> queryCabinetByIds(List<Long> ids) {

		return cabinetDao.queryCabinetByIds(ids);
	}

	@Override
	public List<BasicCabinetDO> unAllocatedCabinet(Integer sortingType, long warehouseId) {

		return cabinetDao.unAllocatedCabinet(sortingType, warehouseId);
	}

	@Override
	public long insertCabinetList(List<BasicCabinetDO> cabinetList) {

		return cabinetDao.insertCabinetList(cabinetList);
	}

	@Override
	public long queryDefaultCabinetId() {
		return cabinetDao.queryDefaultCabinetId();
	}

}
