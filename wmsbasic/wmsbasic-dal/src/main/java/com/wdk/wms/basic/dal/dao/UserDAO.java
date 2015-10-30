package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.BasicUserDO;
import com.wdk.wms.basic.query.parameters.PrivilegedUserQuery;
import com.wdk.wms.basic.query.parameters.UserQuery;

@Dao("basic_user")
public interface UserDAO {

	@Select
	List<BasicUserDO> queryBasicUser(UserQuery queryParameter);

	@Select
	BasicUserDO queryBasicUserById(Long id);

	@Insert
	Long insertBasicUserDO(BasicUserDO userDO);

	@Update
	int updateBasicUserDO(BasicUserDO userDO);

	@Delete
	int deleteBasicUserByIds(String ids);

	/**
	 * 批量更新状态
	 * 
	 * @param ids
	 *            1、ids 需要更新的id 例如：xx,xx,xx
	 * @param status
	 *            2、status 需要更新的状态
	 * @return
	 */
	@Update
	int updateUserStatus(@Param("ids") String ids, @Param("status") int status, @Param("operatorId") Long operatorId);

	/**
	 * 校验用户
	 * 
	 * @param account
	 *            登陆账户
	 * @param password
	 *            密码 MD5 加密
	 * @return
	 */
	@Select
	BasicUserDO checkNameAndPassword(@Param("account") String account, @Param("password") String password);

	/**
	 * 通过用户名查询
	 * 
	 * @param account
	 * @return
	 */
	@Select
	BasicUserDO queryUserByAccount(String account);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	@Select
	int queryUserCount(UserQuery userQuery);

	/**
	 * 查询单个记录
	 * 
	 * @param workNumber
	 *            用户编号
	 * @return
	 */
	@Select
	BasicUserDO queryUserByWorkNumber(String workNumber);

	/**
	 * 通过id获取名称
	 * 
	 * @param id
	 * @return
	 */
	@Select
	String queryUserNameById(Long id);
	
	/**
	 * 获取特权用户列表
	 * @param query
	 * @return
	 */
	@Select
	List<BasicUserDO> queryPrivilegedUser(PrivilegedUserQuery query);
	
	@Select
	int queryPrivilegedUserCount(PrivilegedUserQuery query);
}
