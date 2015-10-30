package com.wdk.wms.basic.enums;

public enum PutawayTypeEnum {
	RECEIVE(1, "收货上架"), TESTRECEIVE(2, "测试上架");

	private PutawayTypeEnum(int index, String text) {
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

	public static PutawayTypeEnum getTextByIndex(int index) {
		for (PutawayTypeEnum t : PutawayTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
