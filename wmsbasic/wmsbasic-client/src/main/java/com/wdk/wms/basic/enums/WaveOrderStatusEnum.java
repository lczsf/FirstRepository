package com.wdk.wms.basic.enums;
/*
 * 波次状态枚举@dishi
 */
public enum WaveOrderStatusEnum {
	
	CREATE(1, "创建"), RFINISH(2, "准备完成"), PICKING(3, "拣货中"), PICKED(4, "拣货完成"), PACKAGED(5, "打包完成"), FINISH(6, "波次终结"), CANCEL(7, "波次取消"), ASSIGNMENTED(8,
			"分配完成");

	private WaveOrderStatusEnum(int index, String text) {
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

	public static WaveOrderStatusEnum getTextByIndex(int index) {
		for (WaveOrderStatusEnum t : WaveOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}


}
