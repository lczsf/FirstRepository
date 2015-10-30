package com.wdk.wms.basic.client.api.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wdk.wms.basic.client.api.ItemClientAPI;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.ItemBarcodeDAO;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.dal.dao.ItemStoreRuleDAO;
import com.wdk.wms.basic.dal.dao.ItemTypeDAO;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.daoobject.BasicItemBarcodeDO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.daoobject.BasicItemStoreRuleDO;
import com.wdk.wms.basic.query.parameters.ItemQuery;
import com.wdk.wms.basic.query.parameters.ItemStoreRuleQuery;
import com.wdk.wms.basic.result.PageResult;

public class ItemClientAPIImpl implements ItemClientAPI {

	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private CabinetDAO cabinetDAO;
	@Autowired
	private ItemTypeDAO itemTypeDAO;
	@Autowired
	private ItemBarcodeDAO itemBarcodeDAO;
	@Autowired
	ItemStoreRuleDAO itemStoreRuleDAO;

	@Override
	public PageResult<BasicItemDO> listItem(ItemQuery query) {

		PageResult<BasicItemDO> result = new PageResult<BasicItemDO>();

		result.setList(itemDAO.queryListByDO(query));
		result.setTotalNum(itemDAO.countByDO(query));

		return result;
	}

	@Override
	public boolean updateItemStatus(String ids, int status, long userId) {

		if (StringUtils.isBlank(ids)) {
			return false;
		}
		itemDAO.updateStatusByIds(ids, status, userId);

		return true;
	}

	@Override
	public BasicItemDO queryById(long id) {

		return itemDAO.queryById(id);
	}

	@Override
	public BasicItemDO queryByCode(String code) {

		return itemDAO.queryByCode(code);
	}

	@Override
	public List<BasicItemBarcodeDO> queryItemBarcode(long itemId) {

		return itemBarcodeDAO.queryListByItemID(itemId);
	}

	@Override
	public boolean updateItem(BasicItemDO item) {

		itemDAO.update(item);

		return true;
	}

	@Override
	public PageResult<BasicItemStoreRuleDO> queryItemStoreRule(ItemStoreRuleQuery query) {

		PageResult<BasicItemStoreRuleDO> result = new PageResult<BasicItemStoreRuleDO>();

		List<BasicItemStoreRuleDO> list = itemStoreRuleDAO.queryListByDO(query);
		List<BasicItemStoreRuleDO> resList = Lists.newArrayList();

		for (BasicItemStoreRuleDO db : list) {
			db.setItemName(itemDAO.queryById(db.getItemId()).getName());
			resList.add(db);
		}

		result.setList(resList);
		result.setTotalNum(itemStoreRuleDAO.countByDO(query));

		return result;
	}

	@Override
	public boolean updateItemStoreRuleStatus(String ids, int status, long userId) {

		if (StringUtils.isBlank(ids)) {
			return false;
		}

		itemStoreRuleDAO.updateStatusByIds(ids, status, userId);

		return true;
	}

	@Override
	public BasicItemStoreRuleDO queryItemStoreRuleById(long itemStoreRuleId) {

		return itemStoreRuleDAO.queryById(itemStoreRuleId);
	}

	@Override
	public boolean updateItemStoreRule(BasicItemStoreRuleDO itemSoreRule) {

		itemStoreRuleDAO.update(itemSoreRule);

		return true;
	}

	@Override
	public boolean insertItemStoreRule(BasicItemStoreRuleDO itemSoreRule) throws Exception {

		BasicItemDO db = itemDAO.queryByCode(itemSoreRule.getItemCode());

		if (db == null) {
			throw new Exception("商品编码不存在");
		}

		ItemStoreRuleQuery query = new ItemStoreRuleQuery();
		query.setItemCode(itemSoreRule.getItemCode());
		query.setWarehouseId(itemSoreRule.getWarehouseId());

		if (itemStoreRuleDAO.queryListByDO(query).size() != 0) {
			throw new Exception("一个商品只能有一条商品规则");
		}

		itemSoreRule.setItemId(db.getId());
		itemStoreRuleDAO.insert(itemSoreRule);

		return true;
	}

	@Override
	public Map<Long, String> queryItemByIds(String ids) {
		List<BasicItemDO> lists = itemDAO.queryItemByIds(ids);
		Map<Long, String> map = Maps.newHashMap();
		for (BasicItemDO item : lists) {
			map.put(item.getId(), item.getName());
		}
		return map;
	}

	@Override
	public long queryItemIdByBarcode(String barcode) {

		return itemBarcodeDAO.queryItemIdByBarcode(barcode);
	}

	@Override
	public String getDefaultCabinetCode(BasicItemDO item, long warehouseId, int status) {
		BasicItemStoreRuleDO basicItemStoreRuleDO = itemStoreRuleDAO.queryByItemCodeAndStatus(warehouseId, item.getCode(), status);// 获取商品库位关系
		if (basicItemStoreRuleDO != null) {
			Long cabinetId = basicItemStoreRuleDO.getCabinetId();// 获取库位id
			if (cabinetId != null) {
				BasicCabinetDO basicCabinetDO = cabinetDAO.queryCabinetById(cabinetId);
				if (basicCabinetDO != null) {

					return basicCabinetDO.getCode();
				}
			}
		}
		return null;// 如果不存在，则返回null
	}

	@Override
	public BasicItemDO queryItemByBarcode(String itemBarcode) {

		return itemDAO.queryById(itemBarcodeDAO.queryItemIdByBarcode(itemBarcode));
	}

	@Override
	public String queryItemCodeById(Long id) {

		return itemDAO.queryItemCodeById(id);
	}

	@Override
	public long insertItem(BasicItemDO basicItemDO) {
		return itemDAO.insert(basicItemDO);

	}

	@Override
	public Long queryItemIdByCode(String code) {

		return itemDAO.queryItemIdByCode(code);
	}

	@Override
	public BasicItemDO queryItemById(Long id) {

		return itemDAO.queryItemById(id);

	}

	@Override
	public List<BasicItemDO> queryItemsByCodes(List<String> codes) {

		return itemDAO.queryItemsByCodes(codes);
	}

	@Override
	public String queryItemNameById(Long id) {

		return itemDAO.queryItemNameById(id);
	}

	@Override
	public List<BasicItemDO> queryItemesByIds(List<Long> ids) {

		return itemDAO.queryItemesByIds(ids);
	}

}
