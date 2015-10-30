package com.wdk.wms.basic.enums;

/*
 * 子订单状态，1正常，0取消
 */
public enum WcsMsgStatusEnum {

	DEFAULT(0, "待发送"), SUCCESS(1, "发送成功");

	private WcsMsgStatusEnum(int index, String text) {
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

	public static WcsMsgStatusEnum getTextByIndex(int index) {
		for (WcsMsgStatusEnum t : WcsMsgStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
}
