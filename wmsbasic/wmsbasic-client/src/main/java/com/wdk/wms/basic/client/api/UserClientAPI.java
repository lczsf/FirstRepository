package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.BasicUserDO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.CoupleData;
import com.wdk.wms.basic.query.parameters.PrivilegedUserQuery;
import com.wdk.wms.basic.query.parameters.UserQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * 用户管理接口
 * 
 * @author 刘勇
 */
public interface UserClientAPI {

	/**
	 * 条件查询
	 * 
	 * @param queryParameter
	 * @return
	 */
	PageResult<BasicUserDO> queryBasicUser(UserQuery queryParameter);

	/**
	 * 插入
	 * 
	 * @param userDO
	 * @return
	 */
	Long inserUser(BasicUserDO userDO);

	/**
	 * 更新
	 * 
	 * @param userDO
	 * @return
	 */
	int updateUser(BasicUserDO userDO);

	/**
	 * 删除
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByIds(String ids);

	/**
	 * 启用或停用
	 * 
	 * @param ids
	 *            需要更新的ids 例如：xx,xx,xx
	 * @param status
	 *            更新的状态 1 启用 0 停用
	 * @param operatorId
	 *            操作人id
	 * @return
	 */
	int updateUserStatus(String ids, int status, Long operatorId);

	/**
	 * 查询单个记录
	 * 
	 * @param id
	 * @return
	 */
	BasicUserDO queryBasicUserById(Long id);

	/**
	 * 校验用户名和密码
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	BasicUserDO checkNameAndPassword(String account, String password);

	/**
	 * 查询可操作仓库
	 * 
	 * @param userId
	 *            用户id
	 * @return id name
	 */
	List<CoupleData> queryWareHouseByUserId(Long userId);

	/**
	 * 通过id查询name
	 * 
	 * @param id
	 * @return
	 */
	String queryUserNameById(Long id);

	/**
	 * 通过用户名获取可操作仓库
	 * 
	 * @param name
	 *            用户名
	 * @return
	 */
	List<CoupleData> queryWareHouseByUserName(String name);

	/**
	 * 校验用户是否又某个仓库权限
	 * 
	 * @param userId
	 *            用户id
	 * @param wareHouseId
	 *            仓库id
	 * @return true 有 false 没有
	 */
	Boolean checkWareHousePurview(Long userId, Long wareHouseId);

	/**
	 * 通过登录账户 获取用户
	 * 
	 * @param account
	 *            用户账户
	 * @return
	 */
	BasicUserDO queryByAccount(String account);
	
	/**
	 * 用户权限系统中用户列表接口
	 * @return
	 */
	PageResult<BasicUserDO> getUserList(Long userId,String account,String userName,Integer status,String userIds,int index);
	
}
