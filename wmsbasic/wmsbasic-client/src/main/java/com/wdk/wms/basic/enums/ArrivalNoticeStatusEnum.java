package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 到货通知单状态枚举
 *
 */
public enum ArrivalNoticeStatusEnum {
	NOTICE(1, "通知"), RECEIVING(2, "收货"), CANCEL(3, "取消"), FINISH(4, "完成");

	private ArrivalNoticeStatusEnum(int index, String text) {
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

	public static ArrivalNoticeStatusEnum getTextByIndex(int index) {
		for (ArrivalNoticeStatusEnum t : ArrivalNoticeStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
