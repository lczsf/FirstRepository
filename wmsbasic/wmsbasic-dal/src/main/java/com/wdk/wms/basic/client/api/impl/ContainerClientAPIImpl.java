package com.wdk.wms.basic.client.api.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.ContainerClientAPI;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.ContainerTypeDAO;
import com.wdk.wms.basic.daoobject.BasicContainerDO;
import com.wdk.wms.basic.daoobject.BasicContainerTypeDO;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.query.parameters.ContainerQuery;
import com.wdk.wms.basic.query.parameters.ContainerTypeQuery;
import com.wdk.wms.basic.result.PageResult;

public class ContainerClientAPIImpl implements ContainerClientAPI {
	@Autowired
	private ContainerDAO containerDAO;
	@Autowired
	private ContainerTypeDAO containerTypeDAO;

	@Override
	public long insertContainer(BasicContainerDO basicContainerDO) throws Exception {

		// 校验编码是否重复
		ContainerQuery containerQuery1 = new ContainerQuery();
		containerQuery1.setCode(basicContainerDO.getCode());
		if (containerDAO.queryContainer(containerQuery1).size() == 1 && containerQuery1.getCode() != null)
			throw new Exception("容器编码已存在！请重新输入！");
		basicContainerDO.setStatus(ContainerStatusEnum.Free.getIndex());
		return containerDAO.insertContainer(basicContainerDO);
	}

	@Override
	public List<BasicContainerDO> queryContainer(ContainerQuery containerQuery) {

		return containerDAO.queryContainer(containerQuery);
	}

	@Override
	public Integer updateContainer(BasicContainerDO basicContainerDO) {

		return containerDAO.updateContainer(basicContainerDO);
	}

	@Override
	public PageResult<BasicContainerDO> queryContainerPage(
			ContainerQuery containerQuery) {
		PageResult<BasicContainerDO> response = new PageResult<BasicContainerDO>();
		List<BasicContainerDO> results;
		 
		// 当前页数据
		results = containerDAO.queryContainer(containerQuery);
		// 总条数
		int count = containerDAO.queryContainerCount(containerQuery);
		
		response.setNum(containerQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(containerQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateContainerStatus(int status, String idList,long operatorId) {
		if (containerDAO.updateContainerStatus(status, idList,operatorId) != 0)
			return true;
		return false;
	}

	@Override
	public BasicContainerDO queryContainerById(long id) {

		return containerDAO.queryContainerById(id);
	}

	@Override
	public long insertContainerType(BasicContainerTypeDO basicContainerTypeDO) {
		// 校验编码是否重复
		ContainerTypeQuery containerTypeQuery = new ContainerTypeQuery();
		containerTypeQuery.setCode(basicContainerTypeDO.getCode());
		if (containerTypeDAO.queryContainerType(containerTypeQuery).size() == 1 && containerTypeQuery.getCode() != null)
			throw new IllegalArgumentException("容器类型编码已存在！请重新输入！");

		// 校验长宽高全数字
		if (!checkContainerType(basicContainerTypeDO))
			throw new IllegalArgumentException("容器类型的长，宽，高必须全数字，请重新输入！");

		return containerTypeDAO.insertContainerType(basicContainerTypeDO);
	}

	@Override
	public List<BasicContainerTypeDO> queryContainerType(
			ContainerTypeQuery containerTypeQuery) {

		return containerTypeDAO.queryContainerType(containerTypeQuery);
	}

	@Override
	public Integer updateContainerType(BasicContainerTypeDO basicContainerTypeDO) {
		// 校验长宽高全数字
		if (!checkContainerType(basicContainerTypeDO))
			throw new IllegalArgumentException("容器类型的长，宽，高必须全数字，请重新输入！");

		return containerTypeDAO.updateContainerType(basicContainerTypeDO);
	}

	@Override
	public PageResult<BasicContainerTypeDO> queryContainerTypePage(
			ContainerTypeQuery containerTypeQuery) {
		PageResult<BasicContainerTypeDO> response = new PageResult<BasicContainerTypeDO>();
		List<BasicContainerTypeDO> results;
		 
		// 当前页数据
		results = containerTypeDAO.queryContainerType(containerTypeQuery);
		// 总条数
		int count = containerTypeDAO
				.queryContainerTypeCount(containerTypeQuery);
		 
		response.setNum(containerTypeQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(containerTypeQuery.getIndex());
		return response;
	}

	@Override
	public boolean updateContainerTypeStatus(int status, String idList,long operatorId) {
		 if(containerTypeDAO.updateContainerTypeStatus(status, idList,operatorId)!=0)
			 return true;
		return  false;
	}

	@Override
	public BasicContainerTypeDO queryContainerTypeById(long id) {
		 
		return containerTypeDAO.queryContainerTypeById(id);
	}

	@Override
	public BasicContainerDO queryContainerByCode(long warehouseId, String containerCode) {
		
		return containerDAO.queryContainerByCode(warehouseId, containerCode);
	}

	@Override
	public boolean updateStatusByContainerCode(long warehouseId, String containerCode, int status, long operatorId) {
		if (containerDAO.updateStatusByContainerCode(warehouseId, containerCode, status, operatorId) != 0)
			return true;
		return false;
	}

	/**
	 * 校验长，宽，高 全数字
	 * 
	 * @param basicContainerTypeDO
	 * @return
	 */
	public boolean checkContainerType(BasicContainerTypeDO basicContainerTypeDO) {
		String pattern = "^[0-9]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m;

		if (basicContainerTypeDO.getLength() != null) {
			m = r.matcher(basicContainerTypeDO.getLength().toString());
		if (!m.matches())
			return false;
		}

		if (basicContainerTypeDO.getWidth() != null) {
		m = r.matcher(basicContainerTypeDO.getWidth().toString());
		if (!m.matches())
			return false;
		}

		if (basicContainerTypeDO.getHeight() != null) {
		m = r.matcher(basicContainerTypeDO.getHeight().toString());
		if (!m.matches())
			return false;
		}
		return true;
	}

	@Override
	public long insertContainerList(List<BasicContainerDO> containerList) {

		return containerDAO.insertContainerList(containerList);
	}

	@Override
	public boolean updateContainerStatusByCodes(int status, List<String> containerCodes, long operatorId) {
		// TODO Auto-generated method stub
		return false;
	}
}
