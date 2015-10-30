package com.wdk.wms.basic.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wdk.wms.basic.daoobject.BasicCabinetDO;

public class CabinetSortUtil {
	public final static int LINE_PRIORITY = 1;

	public final static int CABINET_PRIORITY = 2;

	public static List<BasicCabinetDO> cabinetSort(List<BasicCabinetDO> cabinetList, int priorityType) {
		// 动线优先级
		if (priorityType == CabinetSortUtil.LINE_PRIORITY)
			Collections.sort(cabinetList, new ComparatorLine());
		// 库位优先级
		if (priorityType == CabinetSortUtil.CABINET_PRIORITY)
			Collections.sort(cabinetList, new ComparatorCabinet());
		return cabinetList;
    }

	/**
	 * 动线排序方法
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	protected int compareLine(BasicCabinetDO o1, BasicCabinetDO o2) {
		String code1=o1.getCode();
		String code2 = o2.getCode();
		int result = firstSort(code1.substring(0, 1), code2.substring(0, 1));// 比较第一位区域
		if (result != 0) {
			return result;
		}

		result = firstSort(code1.substring(1, 2), code2.substring(1, 2));// 比较第二位通道
		if (result != 0) {
			return result;
		}

		result = secondSort(code1.substring(2, 4), code2.substring(2, 4));// 比较第三，四位货架
		if (result != 0) {
			return result;
		}

		result = secondSort(code1.substring(4), code2.substring(4));// 比较第五，六位层列
		if (result != 0) {
			return result;
		}

		return result;
	}

	/**
	 * 库位排序方法
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	protected int compareCabinet(BasicCabinetDO o1, BasicCabinetDO o2) {
		if (o1.getPickPriority() > o2.getPickPriority())
			return -1;
		else if (o1.getPickPriority().equals(o2.getPickPriority()))
			return 0;
		else
			return 1;
	}

	private int firstSort(String code1Part, String code2Part) {
		if (isInteger(code1Part) && isInteger(code2Part)) {// 都是数字
			if (Integer.parseInt(code1Part) > Integer.parseInt(code2Part))
				return -1;
			else if (Integer.parseInt(code1Part) == Integer.parseInt(code2Part))
				return 0;
			else
				return 1;
		} else if (isInteger(code1Part) && !isInteger(code2Part)) {// code1Part是数字，code2Part是字母
			return -1;
		} else if (!isInteger(code1Part) && !isInteger(code2Part)) {// 都是字母
			if (code1Part.compareTo(code2Part) < 0)
				return 1;
			else if (code1Part.compareTo(code2Part) > 0)
				return -1;
			return 0;
		} else

			return 1; // code2Part是数字，code1Part是字母
	}

	private int secondSort(String code1Part, String code2Part) {
		if (Integer.parseInt(code1Part) > Integer.parseInt(code2Part))
			return -1;
		else if (Integer.parseInt(code1Part) == Integer.parseInt(code2Part))
			return 0;
		else
			return 1;
	}

	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		List<BasicCabinetDO> cabinetList = new ArrayList<BasicCabinetDO>();
		BasicCabinetDO basicCabinetDO = new BasicCabinetDO();
		basicCabinetDO.setCode("1B4521");
		basicCabinetDO.setPickPriority(1);
		cabinetList.add(basicCabinetDO);
		BasicCabinetDO basicCabinetDO1 = new BasicCabinetDO();
		basicCabinetDO1.setCode("1B4429");
		basicCabinetDO1.setPickPriority(2);
		cabinetList.add(basicCabinetDO1);
		int priorityType = CabinetSortUtil.LINE_PRIORITY;
		cabinetList = cabinetSort(cabinetList, priorityType);
		System.out.println(cabinetList.get(0).getCode());
	}
}

class ComparatorLine extends CabinetSortUtil implements Comparator<BasicCabinetDO> {

	@Override
	public int compare(BasicCabinetDO o1, BasicCabinetDO o2) {
		return compareLine(o1, o2);
	}

}

class ComparatorCabinet extends CabinetSortUtil implements Comparator<BasicCabinetDO> {
	@Override
	public int compare(BasicCabinetDO o1, BasicCabinetDO o2) {
		return compareCabinet(o1, o2);
		}
}
	

