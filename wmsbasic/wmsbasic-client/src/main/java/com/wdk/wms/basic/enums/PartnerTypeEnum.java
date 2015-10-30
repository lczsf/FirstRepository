package com.wdk.wms.basic.enums;

public enum PartnerTypeEnum {
	SUPPLIER(1, "供应商"), OWNER(2, "货主");

	private PartnerTypeEnum(int index, String text) {
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

	public static PartnerTypeEnum getTextByIndex(int index) {
		for (PartnerTypeEnum t : PartnerTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
