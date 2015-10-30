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
import com.wdk.wms.basic.daoobject.BasicItemBarcodeDO;

/**
 * 包名称：com.wdk.wms.basic.dal.dao 类名称：ItemStoreRule 类描述：
 * 
 * @version TODO
 */
@Dao("basic_item_barcode")
public interface ItemBarcodeDAO {

	@Insert
	public long insert(BasicItemBarcodeDO basicItemBarcodeDO);

	@Delete
	public void deleteById(Long id);

	@Select
	public List<BasicItemBarcodeDO> queryListByItemID(long itemID);

	@Select
	public Long queryItemIdByBarcode(@Param("barcode") String barcode);
}
