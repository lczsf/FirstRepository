package com.wdk.wms.basic.client.api.impl;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.daoobject.DictDO;
import com.wdk.wms.basic.query.parameters.MetaQuery;
import com.wdk.wms.basic.result.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdk.wms.basic.client.api.MetaClientAPI;
import com.wdk.wms.basic.dal.dao.MetaDAO;
import com.wdk.wms.basic.daoobject.BasicMetaDO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaClientAPIImpl implements MetaClientAPI {

	@Autowired
	private MetaDAO metaDAO;

	@Override
	public long insertMeta(BasicMetaDO metaDO) {
		// 校验code
		BasicMetaDO basicMetaDO = metaDAO.queryMetaByCode(metaDO.getCode());
		if (basicMetaDO != null) {
			throw new IllegalArgumentException("编码 " + metaDO.getCode() + " 已存在,请重新输入");
		}
		// 校验 value 格式 xx:xx;
		String pattern = "^(([^:;]+):([^:;]+);[ ]{0,1}){1,}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(metaDO.getValue());
		if (m.matches()) { // value 校验成功
			return metaDAO.insertMeta(metaDO);
		} else {
			throw new IllegalArgumentException("字典项值格式不对,例如：3:恒温; 2:冷冻; 1:常温;");
		}
	}

	@Override
	public BasicMetaDO queryMetaById(Long id) {
		return metaDAO.queryMetaById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		return metaDAO.deleteMetaByIds(ids);
	}

	@Override
	public int updateMeta(BasicMetaDO metaDO) {
		return metaDAO.updateMeta(metaDO);
	}

	@Override
	public PageResult<BasicMetaDO> queryMeta(MetaQuery queryParameter) {
		PageResult<BasicMetaDO> pageResult = new PageResult<BasicMetaDO>();

		List<BasicMetaDO> metaDOList = metaDAO.queryMeta(queryParameter);
		int count = metaDAO.queryMetaCount(queryParameter);

		// 封装 分页信息
		pageResult.setList(metaDOList);
		pageResult.setTotalNum(count);
		pageResult.setNum(queryParameter.getNum());
		pageResult.setIndex(queryParameter.getIndex());

		return pageResult;
	}

	@Override
	public List<DictDO> queryDictsByCode(String code) {
		// 返回key value 集合
		List<DictDO> dictDOs = Lists.newArrayList();
		BasicMetaDO basicMetaDO = metaDAO.queryMetaByCode(code);
		if (basicMetaDO != null && StringUtils.isNotBlank(basicMetaDO.getValue())) { // 查询数据不为空
			// 截取每组key value
			String[] couples = basicMetaDO.getValue().split(";");
			for (int i = 0; i < couples.length; i++) {
				// 分割 key value
				String[] couple = couples[i].split(":");
				// 组装数据
				DictDO dictDO = new DictDO();
				if (couple.length == 2) { // 数据是否正常 正常数据长度必定等于2
					dictDO.setKey(couple[0].trim());
					dictDO.setValue(couple[1].trim());
					dictDOs.add(dictDO);
				}
			}
		}
		return dictDOs;
	}
}
