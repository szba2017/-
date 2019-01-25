package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.User;

/**
 * user  dao mapper  
 */
public interface UserMapper {

	/**
	 * 保存用户
	 * @param user
	 * @return num
	 * @throws Exception
	 */
	int add(User user) throws Exception;//新增用户信息

	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int update(User user) throws Exception;//更新用户信息

	/**
	 *  根据ID 删除用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
    int deleteUserById(Integer id) throws Exception;
	
    /**
     *  分页
     * @param currentPageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> getUserList(@Param("loginName") String loginName)throws Exception;
	
	/**
	 * 根据登录名称和密码统计
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	User getUser(@Param("loginName")String  loginName,@Param("password") String password) throws Exception;
}
