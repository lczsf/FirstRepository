/** 
 * 版权 @Copyright: 2015 www.xxx.com Inc. All rights reserved.      
 * 项目名称：wmsbasic-dal 
 * 文件名称：ItemStoreRule.java   
 * 包名：com.wdk.wms.basic.dal.dao       
 * 创建人：@author wjy@gmail.com   
 * 创建时间：Sep 1, 2015/11:08:30 AM 
 * 修改人：wjy@gmail.com 
 * 修改时间：Sep 1, 2015/11:08:30 AM
 * 修改备注：
 */
package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Delete;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicItemStoreRuleDO;
import com.wdk.wms.basic.query.parameters.ItemStoreRuleQuery;

/**
 * 包名称：com.wdk.wms.basic.dal.dao 类名称：ItemStoreRule 类描述：
 * 
 * @version TODO
 */
@Dao("basic_item_store_rule")
public interface ItemStoreRuleDAO {

	@Insert
	public long insert(BasicItemStoreRuleDO basicItemStoreRuleDO);

	@Update
	public void update(BasicItemStoreRuleDO basicItemStoreRuleDO);

	@Update
	void updateStatusByIds(@Param("ids") String ids, @Param("status") int status, @Param("userId") long userId);

	@Delete
	public void deleteById(Long id);

	@Delete
	public void deleteByIds(String ids);

	@Select
	public BasicItemStoreRuleDO queryById(Long id);


	@Select
	int countByDO(ItemStoreRuleQuery query);

	@Select
	List<BasicItemStoreRuleDO> queryListByDO(ItemStoreRuleQuery query);

	@Select
	public BasicItemStoreRuleDO queryByItemCodeAndStatus(@Param("warehouseId") long warehouseId, @Param("itemCode") String itemCode, @Param("status") int status);

}
