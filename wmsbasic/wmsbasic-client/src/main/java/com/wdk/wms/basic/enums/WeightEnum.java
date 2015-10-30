package com.wdk.wms.basic.enums;

import org.apache.commons.lang.StringUtils;

public enum WeightEnum {

	jin("斤"), liang("量"), t("吨"), kg("kg"), g("g");

	private WeightEnum(String text) {
		this.value = text;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static WeightEnum getWeightEnum(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		value = value.trim().toLowerCase();
		WeightEnum weightEnum = null;
		try {
			weightEnum = WeightEnum.valueOf(value);
		} catch (Exception e) {
			weightEnum=null; 
		}

		if (weightEnum != null) {
			return weightEnum;
		}
		for (WeightEnum t : WeightEnum.values()) {
			if (t.getValue().equals(value)) {
				return t;
			}
		}
		return null;
	}
}
