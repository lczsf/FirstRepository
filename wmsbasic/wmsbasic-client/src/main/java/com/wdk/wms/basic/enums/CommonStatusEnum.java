package com.wdk.wms.basic.enums;

public enum CommonStatusEnum {
	
	STOP(0, "停用"), USING(1, "启用");

	private CommonStatusEnum(int index, String text) {
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

	public static CommonStatusEnum getTextByIndex(int index) {
		for (CommonStatusEnum t : CommonStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
