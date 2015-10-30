package com.wdk.wms.basic.common;

import com.wdk.wms.basic.dal.dao.SerialNumberDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.daoobject.BasicSerialNumberDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description: 工具类
 *
 * @author 刘勇
 * @Date 15/9/28
 */
@Component
public class WdkWmsSerialNumberUtil {

	@Autowired
	private SerialNumberDAO serialNumberDAO;

	@Autowired
	private WarehouseDAO warehouseDAO;

	/**
	 * 装箱编号生成 仓库编码（2位）+单据类型(2位) +年2位+月(2位)+日期(2位)+6位流水
	 *
	 * @param whId
	 *            仓库id
	 * @param orderType
	 *            单据类型
	 * @param serialType
	 *            流水号类型
	 * @return
	 */
	public String createCode(Long whId, String orderType, String serialType) {
		StringBuffer code = new StringBuffer();
		// 获取仓库编号
		BasicWarehouseDO basicWarehouseDO = warehouseDAO.queryWarehouseById(whId);
		code.append(basicWarehouseDO.getCode());
		// 单据类型
		code.append(orderType);
		// 年月日
		code.append(DateFormatUtils.format(new Date(), "yyMMdd"));
		// 6位流水号
		// WdkWmsSerialNumberUtil util = new WdkWmsSerialNumberUtil();
		code.append(this.creatSerialNumber(serialType));
		return code.toString();
	}

	/**
	 * 通过时间和类型生成流水号
	 * 
	 * @param serialType
	 *            流水号类型 自定义
	 * @return
	 */
	public String creatSerialNumber(String serialType) {
		int serialNumber = 1; // 流水号 初始化
		Date date = new Date(); // 初始化流水号时间
		BasicSerialNumberDO serialNumberDO = serialNumberDAO.queryByDateAndType(DateFormatUtils.format(date, "yyyy-MM-dd"), serialType); // 查询流水号
		if (serialNumberDO == null) { // 如果今天还没有生成流水号 则生成流水号并返回
			BasicSerialNumberDO basicSerialNumberDO = new BasicSerialNumberDO();
			basicSerialNumberDO.setSerialNumber(serialNumber); // 流水号
			basicSerialNumberDO.setSerialType(serialType); // 流水号类型
			basicSerialNumberDO.setDate(date); // 流水号时间
			serialNumberDAO.insertSerialNumber(basicSerialNumberDO); // 插入数据
			String format = String.format("%06d", serialNumber);
			return format.substring(format.length() - 6); // 返回流水号
		} else { // 更新流水号 可能存在并发
			String format = String.format("%06d", updateSerialNumber(serialNumberDO, 0));
			return format.substring(format.length() - 6);
		}
	}

	/**
	 * 更新
	 * 
	 * @param serialNumberDO
	 * @param number
	 *            直接传递0
	 * @return 流水号
	 */
	private int updateSerialNumber(BasicSerialNumberDO serialNumberDO, int number) {
		int serialNumber = serialNumberDO.getSerialNumber() + 1; //
		serialNumberDO.setSerialNumber(serialNumber); // 更新流水号
		if (number > 10) { // 判断重试次数
			throw new RuntimeException("更新流水号失败!");
		}
		int count = serialNumberDAO.updateSerialNumber(serialNumberDO);
		if (count == 0) { // 判断是否更新成功
			BasicSerialNumberDO basicSerialNumberDO = serialNumberDAO.queryById(serialNumberDO.getId()); // 重新查找
			return updateSerialNumber(basicSerialNumberDO, number++);
		} else {
			return serialNumber;
		}

	}
}
