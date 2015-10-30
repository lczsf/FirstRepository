package com.wdk.wms.basic.enums;

public enum CabinetTypeEnum {
	TEMPORARY_RECEIPT(1, "TEMPORARY_RECEIPT", "收货暂存位"), TEMPORARY_PICK(2, "TEMPORARY_PICK", "拣货暂存位"), STORAGE(3,
			"STORAGE", "存储位"), PICK(4, "PICK", "拣货位"), WHOLESALE(5, "WHOLESALE", "批发位"), PROCESSING(6, "PROCESSING",
					"加工位"), RETURN(7, "RETURN", "退货位"), QUALITY(8, "QUALITY", "残品位"), DIFFER(9, "DIFFER",
							"差异位"), MATERIAL(10, "MATERIAL", "原料位"),END_PRODUCT(11, "END_PRODUCT", "成品位");

	private CabinetTypeEnum(int index, String code, String text) {
		this.index = index;
		this.code = code;
		this.text = text;
	}

	private int index;

	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static CabinetTypeEnum getByIndex(int index) {
		for (CabinetTypeEnum t : CabinetTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

	public static CabinetTypeEnum getByCode(String code) {
		for (CabinetTypeEnum t : CabinetTypeEnum.values()) {
			if (t.getCode().equals(code)) {
				return t;
			}
		}
		return null;
	}

}
