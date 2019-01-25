package com.jiahua.service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.User;

/**
 * user   的 service
 */
public interface UserService {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/add")
	Response add(@RequestBody(required = false) User user) throws Exception ;
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/update")
	Response update(@RequestBody(required = false) User user) throws Exception ;
	
	/**
	 * 根据ID删除用户
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteUserById")
	Response deleteUserById(@RequestParam("userId") Integer userId) throws Exception ;
	
	/**
	 * 根据 userID 和 loginName 获得一个用户
	 * @param userId
	 * @param loginName
	 * @return
	 */
	@RequestMapping("/getUser")
	Response<User> getUser(@RequestParam("loginName") String loginName,
				@RequestParam("password") String password) throws Exception ;
	
	/**
	 * 分页显示所有 User
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getUserList")
	Response<PageInfo<User>> getUserList(@RequestParam("loginName") String loginName,
				@RequestParam("page") Integer page,@RequestParam("limit") Integer limit) throws Exception ;
}
