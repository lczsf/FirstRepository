package com.wdk.wms.basic.enums;

public enum ServiceTypeEnum {
	
	SET_TIME(1, "定时达"),IN_TIME(2, "及时达"), WHOLESALE(3, "批发");

	private ServiceTypeEnum(int index, String text) {
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

	public static ServiceTypeEnum getTextByIndex(int index) {
		for (ServiceTypeEnum t : ServiceTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
    

}
