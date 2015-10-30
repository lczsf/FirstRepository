package com.wdk.wms.basic.client.api;


import java.util.List;
import java.util.Map;

import com.wdk.wms.basic.daoobject.BasicItemBarcodeDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.BasicItemStoreRuleDO;
import com.wdk.wms.basic.query.parameters.ItemQuery;
import com.wdk.wms.basic.query.parameters.ItemStoreRuleQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:商品，商品存放规则列表，商品条码信息
 * 
 * @author 李超 Date 2015-09-07
 */
public interface ItemClientAPI {

	/**
	 * 商品列表
	 * 
	 * @author xiaobo.yxb
	 * @param query
	 * @return
	 */
	PageResult<BasicItemDO> listItem(ItemQuery query);

	/**
	 * 插入商品
	 * 
	 * @param basicitemDO
	 *            商品DO
	 * @return
	 */
	public long insertItem(BasicItemDO basicItemDO);

	/**
	 * 启用或停用
	 * 
	 * @param ids
	 *            需要更新的ids 例如：xx,xx,xx[
	 * @param status
	 *            更新的状态 1 启用 0 停用
	 * @return
	 */
	boolean updateItemStatus(String ids, int status, long userId);

	/**
	 * 根据id获取商品详情
	 * 
	 * @author xiaobo.yxb
	 * @au
	 * @param id
	 * @return
	 */
	BasicItemDO queryById(long itemId);

	/**
	 * 根据code获取商品详情
	 * 
	 * @author wb.liyuan.j
	 * @au
	 * @param id
	 * @return
	 */
	BasicItemDO queryByCode(String code);

	/**
	 * 根据id更新商品详情
	 * 
	 * @author xiaobo.yxb
	 * @param itemId
	 * @return
	 */
	boolean updateItem(BasicItemDO item);

	/**
	 * 商品条码信息列表
	 * 
	 * @author xiaobo.yxb
	 * @param itemId
	 */
	List<BasicItemBarcodeDO> queryItemBarcode(long itemId);

	/**
	 * 商品存放规则列表
	 * 
	 * @author wb-liyuan.j
	 * @param query
	 * @return
	 */
	PageResult<BasicItemStoreRuleDO> queryItemStoreRule(ItemStoreRuleQuery query);

	/**
	 * 启用或停用
	 * 
	 * @param ids
	 *            需要更新的ids 例如：xx,xx,xx[
	 * @param status
	 *            更新的状态 1 启用 0 停用
	 * @return
	 */
	boolean updateItemStoreRuleStatus(String ids, int status, long userId);

	/**
	 * 根据id获取商品存放规则
	 * 
	 * @author wb-liyuan.j
	 * @param itemStoreRuleId
	 * @return
	 */
	BasicItemStoreRuleDO queryItemStoreRuleById(long itemStoreRuleId);

	/**
	 * 根据id更新商品详情
	 * 
	 * @author wb-liyuan.j
	 * @param itemSoreRule
	 * @return
	 */
	boolean updateItemStoreRule(BasicItemStoreRuleDO itemSoreRule);

	/**
	 * 插入商品存放规则
	 * 
	 * @author wb-liyuan.j
	 * @param itemSoreRule
	 * @return
	 * @throws Exception
	 */
	boolean insertItemStoreRule(BasicItemStoreRuleDO itemSoreRule) throws Exception;

	/**
	 * 根据ids查询记录
	 * 
	 * @param ids
	 *            商品id串 ，用","分隔
	 * @return Map<Long 商品id,String 商品名称name>
	 */
	public Map<Long, String> queryItemByIds(String ids);

	/**
	 * 根据barcode查询itemid
	 * 
	 * @param itemBarcode
	 *            商品条码/编码
	 * @return
	 */
	public long queryItemIdByBarcode(String barcode);

	/**
	 * 获取商品的默认库位code
	 * 
	 * @param item
	 * @param warehouseId
	 * @param status
	 * @return
	 */
	public String getDefaultCabinetCode(BasicItemDO item, long warehouseId, int status);

	/**
	 * 根据barcode查询itembarcode对象
	 * 
	 * @param itemBarcode
	 * @return
	 */
	public BasicItemDO queryItemByBarcode(String itemBarcode);

	/**
	 * 根据商品id查询商品code
	 * 
	 * @param id
	 * @return
	 */
	public String queryItemCodeById(Long id);
	
	/**
	 * 根据商品id查询商品Name
	 * 
	 * @param id
	 * @return
	 */
	public String queryItemNameById(Long id);

	/**
	 * 根据商品code查询商品id
	 * 
	 * @return
	 */
	public Long queryItemIdByCode(String code);

	/**
	 * 根据商品id获取商品
	 * 
	 * @param id
	 * @return
	 */
	public BasicItemDO queryItemById(Long id);

	/**
	 * 根据商品codes查询商品列表
	 * 
	 * @param codes
	 * @return
	 */
	public List<BasicItemDO> queryItemsByCodes(List<String> codes);

	/**
	 * 根据商品ids查找商品列表
	 * 
	 * @param ids
	 * @return
	 */
	public List<BasicItemDO> queryItemesByIds(List<Long> ids);
}
