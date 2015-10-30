package com.wdk.wms.basic.common;

import com.wdk.wms.basic.client.api.impl.ParamClientAPIImpl;
import com.wdk.wms.basic.dal.dao.ItemDAO;
import com.wdk.wms.basic.daoobject.BasicItemDO;
import com.wdk.wms.basic.enums.ParamTypeCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Description: 公共服务层
 *
 * @author 刘勇
 * @Date 15/10/21
 */
@Component
public class CommonService {

    final static Logger log = LoggerFactory.getLogger(CommonService.class);

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private ParamClientAPIImpl paramClientAPIImpl;

	/**
	 * 库存数量 转换 或 反转换 1.标品 -> 库存数量: 数量与库存数量对等 2.非标品 -> 库存数量: 销售数量 * 库存系数 3.库存数量 -> 非标品销售数量: 库存数量 / 库存系数
	 * 
	 * @param itemId
	 *            商品id
	 * @param sellQuanity
	 *            需要转换的数量
	 * @param whId
	 *            仓库id
	 * @param isInventory
	 *            是否库存数量 是：true 乘 否：false 除 销售数量
	 *
	 *
	 * @see com.wdk.wms.basic.enums.ParamTypeCodeEnum 参数类型枚举
	 * @return
	 */
	public double quanityTransform(long itemId, double sellQuanity, long whId, boolean isInventory) {
		BasicItemDO item = itemDAO.queryById(itemId);
		int isStandard = item.getIsStandard();// 是否标品,1是标品
		String InventoryUnit = item.getInventoryUnit();// 库存单位
		double quantity = 0;// 库存数量
		BigDecimal sellQuanityB = BigDecimal.valueOf(sellQuanity);
		; // 类型转换
		if (isStandard == 0) {
			String param = paramClientAPIImpl.queryValueByWhidAndCodeAndKey(whId, ParamTypeCodeEnum.UNIT_TRANSFORM.getIndex(), InventoryUnit);// 通过参数表转化成库存数量,参数类型UNIT_TRANSFORM
			if (param != null) {
				BigDecimal coefficient = BigDecimal.valueOf(Double.parseDouble(param));// 转换系数
				if (isInventory) {
					quantity = sellQuanityB.multiply(coefficient).doubleValue();// 库存数量=销售数量*转换系数
				} else {
					quantity = sellQuanityB.divide(coefficient).doubleValue(); // 销售数量 = 库存数量/转换系数
				}
			} else {
				quantity = sellQuanityB.doubleValue();
			}
		} else {
			quantity = sellQuanityB.doubleValue();
		}
		return quantity;
	}


    /**
	 * 校验是否可以包含小数和是否超过包含小数3为 并校验数量不能是负数
	 *
	 * 1 可包含3小数单位 存储在 com.wdk.wms.basic.common.StaticConstants #units#
	 *
	 * @param quanity
	 *            数量
	 * @param unit
	 *            单位
	 * @return true 通过 false 失败
	 */
    public Boolean checkDecimal(Double quanity, String unit) {
		if (quanity < 0) {
			log.info("数量为负数=" + quanity);
			return false;
		}
            quanity = BigDecimal.valueOf(quanity).doubleValue();   //去除小数位后无用的精度
            for (String u : StaticConstants.units) {  //一一比对可是否可包含小数
                if (unit.equalsIgnoreCase(u)) {  //可以包含3位小数
                    int length = quanity.toString().length() - quanity.toString().indexOf(".") - 1; //计算小数位后数量
                    if (length > 3) {  //大于3 不通过
                        return false;
                    }
                } else { //不可包含小数
				if (quanity != quanity.intValue()) {
					log.info("数量转换出错,单位=" + unit + " 不可以带小数！");
					return false;
				}
                }
            }
        return true;
	}

	/**
	 * 校验指定异常msg
	 * 
	 * @param e
	 *            异常
	 * @param exceptionMsg
	 *            需要判断的异常msg
	 * @param msg
	 *            判断成立的日志msg
	 * @param result1
	 *            判断成立返回值
	 * @param result2
	 *            其他情况返回值
	 * @return
	 */
	public int checkException(Exception e, String exceptionMsg, String msg, int result1, int result2) {
		if (e instanceof UncategorizedSQLException && ((UncategorizedSQLException) e).getSQLException().getMessage().contains(exceptionMsg)) {
			log.info(msg, e); // 表示此批次已经接收
			return result1; // 违法唯一性约束
		} else {
			log.error("其他异常", e);
			return result2; // 其他异常
		}
    }
}
