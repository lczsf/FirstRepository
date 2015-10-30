package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 拣货单属性枚举
 *
 */
public enum PickingOrderPropertyEnum {

	INSTANT(1, "即时达"), TIMETOTIME(2, "定时达");

	private PickingOrderPropertyEnum(int index, String text) {
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

	public static PickingOrderPropertyEnum getTextByIndex(int index) {
		for (PickingOrderPropertyEnum t : PickingOrderPropertyEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
