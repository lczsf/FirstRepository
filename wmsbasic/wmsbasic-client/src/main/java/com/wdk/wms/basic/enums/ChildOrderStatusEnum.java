package com.wdk.wms.basic.enums;
/*
 * 子订单状态，1正常，0取消
 */
public enum ChildOrderStatusEnum {

	DEDUCTION_STOCKOUT(2,"扣减缺货"),Normal(1, "正常"),CANCEL(0, "取消");

	private ChildOrderStatusEnum(int index, String text) {
		this.index = index;
		this.text = text;
	}

	private int index;

	private String text;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setStatus(String text) {
		this.text = text;
	}

	public static ChildOrderStatusEnum getTextByIndex(int index) {
		for (ChildOrderStatusEnum t : ChildOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
}
