package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:销售订单详情表
 * 
 * @author 李超 Date 2015-09-28
 */
public class SalesOrderDetailDO {

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
	 * 销售订单id
	 */
	private Long salesOrderId;

	/**
	 * 子订单ID(单品单个订单，子订单)
	 */
	private Long subOrderId;

	/**
	 * 子订单状态
	 */
	private Integer orderStatus;

	/**
	 * 商品ID
	 */
	private Long itemId;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 商品单价
	 */
	private Double itemUnitPrice = 0.00;

	/**
	 * 金额
	 */
	private Double amount = 0.00;

	/**
	 * 主计价单位
	 */
	private String mainUnit;

	/**
	 * 主计价单位购买数量
	 */
	private Double mainBuyNumber = 0.00;

	/**
	 * 主计价单位拣货数量
	 */
	private Double mainSortNumber = 0.00;

	/**
	 * 销售单位
	 */
	private String marketingUnit;

	/**
	 * 销售单位购买数量
	 */
	private Double marketingBuyNumber = 0.00;

	/**
	 * 销售单位拣货数量
	 */
	private Double marketingSortNumber = 0.00;

	/**
	 * 附加服务
	 */
	private String accessorialService;

	/**
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 出库操作方式
	 */
	private Integer outOperationMode;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 拣货单位
	 */
	private String pickingUnit;

	/**
	 * 拣货单位购买数量
	 */
	private Double pickingBuyNumber = 0.00;

	/**
	 * 拣货单位拣货数量
	 */
	private Double pickingSortNumber = 0.00;

	/**
	 * 优惠金额
	 */
	private Double preferentialAmount = 0.00;

	/**
	 * 退款金额
	 */
	private Double refundAmount = 0.00;

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
	 * setter for column 销售订单id
	 */
	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	/**
	 * getter for column 销售订单id
	 */
	public Long getSalesOrderId() {
		return this.salesOrderId;
	}

	/**
	 * setter for column 子订单ID(单品单个订单，子订单)
	 */
	public void setSubOrderId(Long subOrderId) {
		this.subOrderId = subOrderId;
	}

	/**
	 * getter for column 子订单ID(单品单个订单，子订单)
	 */
	public Long getSubOrderId() {
		return this.subOrderId;
	}

	/**
	 * setter for column 子订单状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * getter for column 子订单状态
	 */
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * setter for column 商品ID
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品ID
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 商品名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * getter for column 商品名称
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * setter for column 商品单价
	 */
	public void setItemUnitPrice(Double itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	/**
	 * getter for column 商品单价
	 */
	public Double getItemUnitPrice() {
		return this.itemUnitPrice;
	}

	/**
	 * setter for column 金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * getter for column 金额
	 */
	public Double getAmount() {
		return this.amount;
	}

	/**
	 * setter for column 主计价单位
	 */
	public void setMainUnit(String mainUnit) {
		this.mainUnit = mainUnit;
	}

	/**
	 * getter for column 主计价单位
	 */
	public String getMainUnit() {
		return this.mainUnit;
	}

	/**
	 * setter for column 主计价单位购买数量
	 */
	public void setMainBuyNumber(Double mainBuyNumber) {
		this.mainBuyNumber = mainBuyNumber;
	}

	/**
	 * getter for column 主计价单位购买数量
	 */
	public Double getMainBuyNumber() {
		return this.mainBuyNumber;
	}

	/**
	 * setter for column 主计价单位拣货数量
	 */
	public void setMainSortNumber(Double mainSortNumber) {
		this.mainSortNumber = mainSortNumber;
	}

	/**
	 * getter for column 主计价单位拣货数量
	 */
	public Double getMainSortNumber() {
		return this.mainSortNumber;
	}

	/**
	 * setter for column 销售单位
	 */
	public void setMarketingUnit(String marketingUnit) {
		this.marketingUnit = marketingUnit;
	}

	/**
	 * getter for column 销售单位
	 */
	public String getMarketingUnit() {
		return this.marketingUnit;
	}

	/**
	 * setter for column 销售单位购买数量
	 */
	public void setMarketingBuyNumber(Double marketingBuyNumber) {
		this.marketingBuyNumber = marketingBuyNumber;
	}

	/**
	 * getter for column 销售单位购买数量
	 */
	public Double getMarketingBuyNumber() {
		return this.marketingBuyNumber;
	}

	/**
	 * setter for column 销售单位拣货数量
	 */
	public void setMarketingSortNumber(Double marketingSortNumber) {
		this.marketingSortNumber = marketingSortNumber;
	}

	/**
	 * getter for column 销售单位拣货数量
	 */
	public Double getMarketingSortNumber() {
		return this.marketingSortNumber;
	}

	/**
	 * setter for column 附加服务
	 */
	public void setAccessorialService(String accessorialService) {
		this.accessorialService = accessorialService;
	}

	/**
	 * getter for column 附加服务
	 */
	public String getAccessorialService() {
		return this.accessorialService;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	public Integer getOutOperationMode() {
		return outOperationMode;
	}

	public void setOutOperationMode(Integer outOperationMode) {
		this.outOperationMode = outOperationMode;
	}

	public String getPickingUnit() {
		return pickingUnit;
	}

	public void setPickingUnit(String pickingUnit) {
		this.pickingUnit = pickingUnit;
	}

	public Double getPickingBuyNumber() {
		return pickingBuyNumber;
	}

	public void setPickingBuyNumber(Double pickingBuyNumber) {
		this.pickingBuyNumber = pickingBuyNumber;
	}

	public Double getPickingSortNumber() {
		return pickingSortNumber;
	}

	public void setPickingSortNumber(Double pickingSortNumber) {
		this.pickingSortNumber = pickingSortNumber;
	}

	public Double getPreferentialAmount() {
		return preferentialAmount;
	}

	public void setPreferentialAmount(Double preferentialAmount) {
		this.preferentialAmount = preferentialAmount;
	}

	public Double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}

}