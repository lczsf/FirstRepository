package com.wdk.wms.basic.enums;

import org.apache.commons.lang.StringUtils;

public enum StorageTypeEnum {

	HOT(1, "热温"), NORMAL(2, "常温"), COLD(3, "冷藏"), FREEZING(3, "冷冻");

	private StorageTypeEnum(int index, String text) {
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

	public static StorageTypeEnum getTextByIndex(int index) {
		for (StorageTypeEnum t : StorageTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

	public static StorageTypeEnum getStorageTypeEnumByText(String text) {
		if (StringUtils.isBlank(text)) {
			return null;
		}
		text = text.trim();
		for (StorageTypeEnum t : StorageTypeEnum.values()) {
			if (t.getText().equals(text)) {
				return t;
			}
		}
		return null;
	}

}
