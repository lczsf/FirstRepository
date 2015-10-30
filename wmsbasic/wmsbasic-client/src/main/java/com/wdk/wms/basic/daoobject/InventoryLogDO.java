package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库存变化日志表
 * 
 * @author 滴石 Date 2015-09-06
 */
public class InventoryLogDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 库存Id
	 */
	private Long inventoryId;
	
	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 商品Id
	 */
	private Long itemId;

	/**
	 * 实物库存
	 */
	private Long realInvent;

	/**
	 * 可用库存
	 */
	private Long availableInvent;

	/**
	 * 库存占用
	 */
	private Long inventoryOccupy;

	/**
	 * 变化数量
	 */
	private Long changeAccount;

	/**
	 * 变更后的实物库存
	 */
	private Long realInventUpdated;

	/**
	 * 变更后的可用库存
	 */
	private Long availableInventUpdated;

	/**
	 * 单据类型
	 */
	private Integer docType;

	/**
	 * 单据Id
	 */
	private Long docId;

	/**
	 * 来源单据Code
	 */
	private String sourceDocCode;

	/**
	 * setter for column 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * getter for column 创建时间
	 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/**
	 * setter for column 修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * getter for column 修改时间
	 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	/**
	 * setter for column 库存Id
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * getter for column 库存Id
	 */
	public Long getInventoryId() {
		return this.inventoryId;
	}

	/**
	 * setter for column 实物库存
	 */
	public void setRealInvent(Long realInvent) {
		this.realInvent = realInvent;
	}

	/**
	 * getter for column 实物库存
	 */
	public Long getRealInvent() {
		return this.realInvent;
	}

	/**
	 * setter for column 可用库存
	 */
	public void setAvailableInvent(Long availableInvent) {
		this.availableInvent = availableInvent;
	}

	/**
	 * getter for column 可用库存
	 */
	public Long getAvailableInvent() {
		return this.availableInvent;
	}

	/**
	 * setter for column 库存占用
	 */
	public void setInventoryOccupy(Long inventoryOccupy) {
		this.inventoryOccupy = inventoryOccupy;
	}

	/**
	 * getter for column 库存占用
	 */
	public Long getInventoryOccupy() {
		return this.inventoryOccupy;
	}

	/**
	 * setter for column 变化数量
	 */
	public void setChangeAccount(Long changeAccount) {
		this.changeAccount = changeAccount;
	}

	/**
	 * getter for column 变化数量
	 */
	public Long getChangeAccount() {
		return this.changeAccount;
	}

	/**
	 * setter for column 变更后的实物库存
	 */
	public void setRealInventUpdated(Long realInventUpdated) {
		this.realInventUpdated = realInventUpdated;
	}

	/**
	 * getter for column 变更后的实物库存
	 */
	public Long getRealInventUpdated() {
		return this.realInventUpdated;
	}

	/**
	 * setter for column 变更后的可用库存
	 */
	public void setAvailableInventUpdated(Long availableInventUpdated) {
		this.availableInventUpdated = availableInventUpdated;
	}

	/**
	 * getter for column 变更后的可用库存
	 */
	public Long getAvailableInventUpdated() {
		return this.availableInventUpdated;
	}

	/**
	 * setter for column 单据类型
	 */
	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	/**
	 * getter for column 单据类型
	 */
	public Integer getDocType() {
		return this.docType;
	}

	/**
	 * setter for column 单据Id
	 */
	public void setDocId(Long docId) {
		this.docId = docId;
	}

	/**
	 * getter for column 单据Id
	 */
	public Long getDocId() {
		return this.docId;
	}

	/**
	 * setter for column 来源单据Code
	 */
	public void setSourceDocCode(String sourceDocCode) {
		this.sourceDocCode = sourceDocCode;
	}

	/**
	 * getter for column 来源单据Code
	 */
	public String getSourceDocCode() {
		return this.sourceDocCode;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
	

}