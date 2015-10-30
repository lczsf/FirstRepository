package com.wdk.wms.basic.enums;

/**
 * 
 * 库存单位转换系数
 *
 */
public enum ParamTypeCodeEnum {
	UNIT_TRANSFORM("UNIT_TRANSFORM", "库存单位转换系数Code");

	private ParamTypeCodeEnum(String index, String text) {
		this.index = index;
		this.text = text;
	}

	private String index;

	private String text;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setStatus(String text) {
		this.text = text;
	}

	public static ParamTypeCodeEnum getTextByIndex(String index) {
		for (ParamTypeCodeEnum t : ParamTypeCodeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
