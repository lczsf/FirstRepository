package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 来源类型枚举
 *
 */
public enum SourceTypeEnum {
	CONTAINER_ORDER(1, "装箱单"), PUTAWAY_ORDER(2, "上架单"), SALES_ORDER_DETAIL(3, "销售子订单"), PICKING_ORDER_DETAIL(4, "拣货单明细"), DIFF_ORDER_DETAIL(5, "差异单明细"), BACK_ORDER(
6, "归位单"), WAVE_ORDER(7, "波次单"), PICKING_ORDER(8, "拣货单"), INVENTORY_OCCUPY(9, "库存占用表");

	private SourceTypeEnum(int index, String text) {
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

	public static SourceTypeEnum getByIndex(int index) {
		for (SourceTypeEnum t : SourceTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
}
