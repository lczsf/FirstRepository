package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:销售订单
 * 
 * @author 李超 Date 2015-09-28
 */
public class SalesOrderDO {

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
	 * 外部销售单号
	 */
	private String externalSalesNumber;

	/**
	 * 销售订单类型(周期购、批发、预售、普通 )
	 */
	private Integer type;

	/**
	 * 外来批次code
	 */
	private Long outBatchCode;

	/**
	 * 所属波次id
	 */
	private Long waveId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 履约类型(现场购买、配送、预约自提 )
	 */
	private Integer performanceType;

	/**
	 * 要求送达类型(实时达，定时达)
	 */
	private Integer serviceType;

	/**
	 * 出库操作类型
	 */
	private Integer outOperationMode;

	/**
	 * 收货人姓名
	 */
	private String receiverName;

	/**
	 * 收货人联系电话
	 */
	private String receiverTel;

	/**
	 * 送货详细地址
	 */
	private String postAddress;

	/**
	 * 邮费
	 */
	private Double postage;

	/**
	 * 订单总金额
	 */
	private Double totalOrderAmount;

	/**
	 * 订单优惠金额
	 */
	private Double discountAmount;

	/**
	 * 订单应付金额
	 */
	private Double payOrderAmount;

	/**
	 * 支付宝积分支付金额
	 */
	private Double alipayPaymentAmount;

	/**
	 * 支付宝红包抵扣
	 */
	private Double alipayRedEnvelope;

	/**
	 * 实付金额
	 */
	private Double paidAmount;


	/**
	 * 补差金额
	 */
	private Double compensationAmount;

	/**
	 * 发票抬头
	 */
	private String invoiceTitle;

	/**
	 * 发票类型
	 */
	private Long invoiceType;

	/**
	 * 发票金额
	 */
	private String invoiceAmount;

	/**
	 * setter for column 主键
	 */

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 订单服务商品金额
	 */
	private Double orderServiceAmount;

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
	 * setter for column 外部销售单号
	 */
	public void setExternalSalesNumber(String externalSalesNumber) {
		this.externalSalesNumber = externalSalesNumber;
	}

	/**
	 * getter for column 外部销售单号
	 */
	public String getExternalSalesNumber() {
		return this.externalSalesNumber;
	}

	/**
	 * setter for column 销售订单类型(周期购、批发、预售、普通 )
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 销售订单类型(周期购、批发、预售、普通 )
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 外来批次code
	 */
	public void setOutBatchCode(Long outBatchCode) {
		this.outBatchCode = outBatchCode;
	}

	/**
	 * getter for column 外来批次code
	 */
	public Long getOutBatchCode() {
		return this.outBatchCode;
	}

	/**
	 * setter for column 所属波次id
	 */
	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	/**
	 * getter for column 所属波次id
	 */
	public Long getWaveId() {
		return this.waveId;
	}

	/**
	 * setter for column 仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库id
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 货主id
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主id
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 履约类型(现场购买、配送、预约自提 )
	 */
	public void setPerformanceType(Integer performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * getter for column 履约类型(现场购买、配送、预约自提 )
	 */
	public Integer getPerformanceType() {
		return this.performanceType;
	}

	/**
	 * setter for column 要求送达类型(实时达，定时达)
	 */
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * getter for column 要求送达类型(实时达，定时达)
	 */
	public Integer getServiceType() {
		return this.serviceType;
	}

	/**
	 * setter for column 出库操作类型
	 */

	public Integer getOutOperationMode() {
		return outOperationMode;
	}

	public void setOutOperationMode(Integer outOperationMode) {
		this.outOperationMode = outOperationMode;
	}
	
	/**
	 * setter for column 收货人姓名
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * getter for column 收货人姓名
	 */
	public String getReceiverName() {
		return this.receiverName;
	}

	/**
	 * setter for column 收货人联系电话
	 */
	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	/**
	 * getter for column 收货人联系电话
	 */
	public String getReceiverTel() {
		return this.receiverTel;
	}

	/**
	 * setter for column 送货详细地址
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	/**
	 * getter for column 送货详细地址
	 */
	public String getPostAddress() {
		return this.postAddress;
	}

	/**
	 * setter for column 邮费
	 */
	public void setPostage(Double postage) {
		this.postage = postage;
	}

	/**
	 * getter for column 邮费
	 */
	public Double getPostage() {
		return this.postage;
	}

	/**
	 * setter for column 订单总金额
	 */
	public void setTotalOrderAmount(Double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	/**
	 * getter for column 订单总金额
	 */
	public Double getTotalOrderAmount() {
		return this.totalOrderAmount;
	}

	/**
	 * setter for column 订单优惠金额
	 */
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * getter for column 订单优惠金额
	 */
	public Double getDiscountAmount() {
		return this.discountAmount;
	}

	/**
	 * setter for column 订单应付金额
	 */
	public void setPayOrderAmount(Double payOrderAmount) {
		this.payOrderAmount = payOrderAmount;
	}

	/**
	 * getter for column 订单应付金额
	 */
	public Double getPayOrderAmount() {
		return this.payOrderAmount;
	}

	/**
	 * setter for column 支付宝积分支付金额
	 */
	public void setAlipayPaymentAmount(Double alipayPaymentAmount) {
		this.alipayPaymentAmount = alipayPaymentAmount;
	}

	/**
	 * getter for column 支付宝积分支付金额
	 */
	public Double getAlipayPaymentAmount() {
		return this.alipayPaymentAmount;
	}

	/**
	 * setter for column 支付宝红包抵扣
	 */
	public void setAlipayRedEnvelope(Double alipayRedEnvelope) {
		this.alipayRedEnvelope = alipayRedEnvelope;
	}

	/**
	 * getter for column 支付宝红包抵扣
	 */
	public Double getAlipayRedEnvelope() {
		return this.alipayRedEnvelope;
	}

	/**
	 * setter for column 实付金额
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * getter for column 实付金额
	 */
	public Double getPaidAmount() {
		return this.paidAmount;
	}



	/**
	 * setter for column 补差金额
	 */
	public void setCompensationAmount(Double compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	/**
	 * getter for column 补差金额
	 */
	public Double getCompensationAmount() {
		return this.compensationAmount;
	}

	/**
	 * setter for column 发票抬头
	 */
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	/**
	 * getter for column 发票抬头
	 */
	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}

	/**
	 * setter for column 发票类型
	 */
	public void setInvoiceType(Long invoiceType) {
		this.invoiceType = invoiceType;
	}

	/**
	 * getter for column 发票类型
	 */
	public Long getInvoiceType() {
		return this.invoiceType;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Double getOrderServiceAmount() {
		return orderServiceAmount;
	}

	public void setOrderServiceAmount(Double orderServiceAmount) {
		this.orderServiceAmount = orderServiceAmount;
	}

}