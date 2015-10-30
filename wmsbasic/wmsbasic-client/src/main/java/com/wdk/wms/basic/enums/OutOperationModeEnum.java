package com.wdk.wms.basic.enums;

/*
 * 出库操作方式枚举
 * @author 滴石
 */
public enum OutOperationModeEnum {
	SCENE(1, "现场"), WHOLESALE(2, "批发"), ONLINE(3, "线上");

	private OutOperationModeEnum(int index, String text) {
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

	public static OutOperationModeEnum getTextByIndex(int index) {
		for (OutOperationModeEnum t : OutOperationModeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
