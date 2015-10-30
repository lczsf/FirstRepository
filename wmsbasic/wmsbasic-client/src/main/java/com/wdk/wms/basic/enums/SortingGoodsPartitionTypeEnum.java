package com.wdk.wms.basic.enums;

public enum SortingGoodsPartitionTypeEnum {
	LOGIC(1, "逻辑分区"), PICKING(2, "拣货分区");

	private SortingGoodsPartitionTypeEnum(int index, String text) {
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

	public static SortingGoodsPartitionTypeEnum getTextByIndex(int index) {
		for (SortingGoodsPartitionTypeEnum t : SortingGoodsPartitionTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
