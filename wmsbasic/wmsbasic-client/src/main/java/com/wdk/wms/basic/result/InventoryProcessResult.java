package com.wdk.wms.basic.result;

import java.util.List;

public class InventoryProcessResult<T> {
	/**
	 * 返回状态值，1代表处理成功，0代表需要重试，-1代表库存操作失败
	 */
	private int status;
	private List<T> result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
