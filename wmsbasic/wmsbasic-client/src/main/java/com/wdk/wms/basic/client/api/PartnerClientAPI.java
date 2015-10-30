package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BasicPartnerDO;
import com.wdk.wms.basic.query.parameters.PartnerQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description: 货主，供应商，承运商等
 * 
 * @author 李超 Date 2015-09-07
 */
public interface PartnerClientAPI {

	/**
	 * 插入basePartner(货主，供应商，承运商等)
	 */
	public long insertPartner(BasicPartnerDO basicPartnerDO);

	/**
	 * 更新(货主，供应商，承运商等)
	 */
	public int updateBasicPartnerDO(BasicPartnerDO basicPartnerDO);

	/**
	 * 根据id批量删除
	 */
	public int deleteBasicPartnerByIds(String ids);

	/**
	 * 查询列表
	 */
	public PageResult<BasicPartnerDO> queryBasicPartnerPage(PartnerQuery queryParameter);

	/**
	 * 批量更新状态(启用=1；停用=-1)
	 */
	public int updateParnerStatus(String ids, int status, long operaterId);

	/**
	 * 根据id查找记录
	 */
	public BasicPartnerDO queryBasicPartnerById(long id);

	/**
	 * 根据code.货主类别，查询货主
	 * 
	 * @param code
	 *            编码
	 * @param partnerType
	 *            伙伴类型
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public BasicPartnerDO queryBasicPartnerByCode(String code, Integer partnerType, Long warehouseId);
}
