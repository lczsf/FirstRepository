package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicPartnerDO;
import com.wdk.wms.basic.query.parameters.PartnerQuery;

@Dao("basic_partner")
public interface PartnerDAO {

	/**
	 * 插入basePartner
	 */
	@Insert
	public long insertPartner(BasicPartnerDO basicPartnerDO);

	/**
	 * 查找货主列表
	 */
	@Select
	public List<BasicPartnerDO> queryActivityOwner(long warehouseID);

	/**
	 * 更新
	 */
	@Update
	public int updateBasicPartnerDO(BasicPartnerDO basicPartnerDO);

	/**
	 * 根据id批量删除
	 */
	@Delete
	public int deleteBasicPartnerByIds(String ids);

	/**
	 * 查询列表
	 */
	@Select
	public List<BasicPartnerDO> queryBasicPartner(PartnerQuery queryParameter);

	/**
	 * 批量更新状态
	 */
	@Update
	public int updateParnerStatus(@Param("ids") String ids, @Param("status") int status,
			@Param("operaterId") long operaterId);

	/**
	 * 查询总的数量
	 */
	@Select
	public int queryBasicPartnerCount(PartnerQuery queryParameter);

	/**
	 * 根据id查找记录
	 */
	@Select
	public BasicPartnerDO queryBasicPartnerById(long id);

	/**
	 * 根据code和仓库id查询
	 * 
	 * @param code
	 * @param warehouseId
	 */
	@Select
	public BasicPartnerDO queryBasicPartnerByCode(@Param("code") String code, @Param("partnerType") Integer partnerType, @Param("warehouseId") Long warehouseId);
}
