package com.wdk.wms.inventory.parameters;

public class OrderInventoryResult {
	
	private long salesOrderId;  //主订单id
	private long waveOrderId;   //波次id
	private boolean isSuccess;  //操作是否成功
	private long detailOrderId;//库存占用/扣减失败子订单id
	private int causeType;//异常原因 -1：缺货原因 -2：锁问题 -3：库存小数问题， -4：后端系统异常
	
	public long getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public long getWaveOrderId() {
		return waveOrderId;
	}
	public void setWaveOrderId(long waveOrderId) {
		this.waveOrderId = waveOrderId;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public long getDetailOrderId() {
		return detailOrderId;
	}
	public void setDetailOrderId(long detailOrderId) {
		this.detailOrderId = detailOrderId;
	}
	public int getCauseType() {
		return causeType;
	}
	public void setCauseType(int causeType) {
		this.causeType = causeType;
	}
}
