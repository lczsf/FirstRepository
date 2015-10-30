package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.query.parameters.CabinetQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:库位
 * 
 * @author 李超 Date 2015-09-07
 */
public interface CabinetClientAPI {

	/**
	 * 新增库位，默认状态status为1
	 * 
	 * @param basicCabinetDO
	 *            库位DO
	 * @return
	 * @throws Exception
	 */
	public long insertCabinet(BasicCabinetDO basicCabinetDO) throws Exception;
	
	/**
	 * 查询库位
	 * 
	 * @param cabinetQuery
	 *            库位Query
	 * @return
	 */
	public List<BasicCabinetDO> queryCabinet(CabinetQuery cabinetQuery);
	
	/**
	 * 根据Id修改库位信息
	 * 
	 * @param basicCabinetDO
	 *            库位DO
	 * @return
	 */
	public Integer updateCabinet(BasicCabinetDO basicCabinetDO);
	
	/**
	 * 分页查询库位
	 * 
	 * @param cabinetQuery
	 *            库位Query
	 * @return
	 */
	public PageResult<BasicCabinetDO> queryCabinetPage(CabinetQuery cabinetQuery);
	
	/**
	 * 启用停用接口
	 * 
	 * @param status
	 *            状态
	 * @param idList
	 *            id串，用“,”分隔
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
	public boolean updateCabinetStatus(int status ,String idList,long operatorId);
	
	/**
	 * 根据id查询库位
	 * 
	 * @param id
	 *            库位id
	 * @return
	 */
	public BasicCabinetDO queryCabinetById(long id);

	/**
	 * 仓库id和库位code查询库位
	 * 
	 * @param warehouseId
	 *            仓库id
	 * @param cabinetCode
	 *            库位code
	 */
	public BasicCabinetDO queryBycabinetCode(Long warehouseId, String cabinetCode);

	/**
	 * 根据库位id集合查询库位DO集合
	 * 
	 * @param ids
	 * @return
	 */
	public List<BasicCabinetDO> queryCabinetByIds(List<Long> ids);

	/**
	 * 查询未被分配到拣货分区的库位
	 * 
	 * @param sortingType
	 *            拣货分区类型
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public List<BasicCabinetDO> unAllocatedCabinet(Integer sortingType, long warehouseId);

	/**
	 * 插入库位list
	 * 
	 * @param cabinetList
	 * @return
	 */
	public long insertCabinetList(List<BasicCabinetDO> cabinetList);

	/**
	 * 获取默认库位
	 * 
	 * @return
	 */
	public long queryDefaultCabinetId();
}
