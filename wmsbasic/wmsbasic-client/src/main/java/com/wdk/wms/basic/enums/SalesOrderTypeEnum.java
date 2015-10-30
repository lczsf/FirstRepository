package com.wdk.wms.basic.enums;

public enum SalesOrderTypeEnum {
	
	PERIOD(1, "周期购"), WHOLESALE(2, "批发"), PRE_SALE(3, "预售"), COMMON(4, "普通");

	private SalesOrderTypeEnum(int index, String text) {
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

	public static SalesOrderTypeEnum getTextByIndex(int index) {
		for (SalesOrderTypeEnum t : SalesOrderTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
