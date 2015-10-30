package com.wdk.wms.basic.client.api;

import com.wdk.wms.basic.daoobject.DiffOrderDO;
import com.wdk.wms.basic.daoobject.DiffOrderDetailDO;
import com.wdk.wms.basic.query.parameters.DiffOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.DiffOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:差异单，差异单详情
 * 
 * @author 李超 Date 2015-09-07
 */
public interface DiffOrderClientAPI {
	/**
	 * 查询差异单
	 * 
	 * @param diffOrderQuery
	 *            差异单Query
	 * @return
	 */
	public PageResult<DiffOrderDO> queryDiffOrder(DiffOrderQuery diffOrderQuery);

	/**
	 * 插入差异单数据默认status为1创建
	 * 
	 * @param diffOrderDO
	 *            差异单DO
	 * @return
	 */
	public long insertDiffOrder(DiffOrderDO diffOrderDO);

	/**
	 * 插入差异单明细数据 规格字段spec不能为空
	 * 
	 * @param diffOrderDetailDO
	 *            差异单明细DO
	 * @return
	 */
	public long insertDiffOrderDetail(DiffOrderDetailDO diffOrderDetailDO);

	/**
	 * 分页获取差异单详情
	 * 
	 * @param diffOrderDetailQuery
	 * @return
	 */
	public PageResult<DiffOrderDetailDO> queryDiffOrderDetailPage(DiffOrderDetailQuery diffOrderDetailQuery);
}
