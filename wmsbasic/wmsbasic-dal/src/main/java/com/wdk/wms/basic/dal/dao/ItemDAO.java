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
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.query.parameters.ItemQuery;

/**
 * 包名称：com.wdk.wms.basic.dal.dao 类名称：ItemStoreRule 类描述：
 * 
 * @version
 */
@Dao("basic_item")
public interface ItemDAO {

	@Insert
	long insert(BasicItemDO basicItemDO);

	@Update
	int update(BasicItemDO basicItemDO);

	@Update
	void updateStatusByIds(@Param("ids") String ids, @Param("status") int status, @Param("userId") long userId);

	@Select
	BasicItemDO queryById(Long id);

	@Select
	BasicItemDO queryByCode(String code);


	@Select
	int countByDO(ItemQuery query);

	@Select
	List<BasicItemDO> queryListByDO(ItemQuery query);

	/**
	 * 根据ids查找记录
	 */
	@Select
	public List<BasicItemDO> queryItemByIds(String ids);
	
	@Select
	public String queryItemCodeById(Long id);

	@Select
	public Long queryItemIdByCode(String code);

	@Select
	public BasicItemDO queryItemById(Long id);

	@Select
	public List<BasicItemDO> queryItemsByCodes(@Param("codes") List<String> codes);

	@Select
	public List<String> queryCodesByBarCodes(@Param("barCodes") List<String> barCodes);

	@Select
	public String queryItemNameById(Long id);

	@Select
	public List<BasicItemDO> queryItemesByIds(@Param("ids") List<Long> ids);
}
