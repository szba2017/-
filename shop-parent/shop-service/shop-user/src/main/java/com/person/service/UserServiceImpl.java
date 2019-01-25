package com.jiahua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.User;
import com.jiahua.mapper.UserMapper;

@SuppressWarnings("rawtypes")
@RestController
@Transactional
public class UserServiceImpl extends ResponseApi implements UserService{

	@Autowired
	private UserMapper  userMapper;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/add")
	public Response add(User user) throws Exception {
		int num = userMapper.add(user);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	
	}

	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/update")
	public Response update(User user) throws Exception {
		int num = userMapper.update(user);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 根据ID删除用户
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/deleteUserById")
	public Response deleteUserById(Integer userId) throws Exception {
		int num = userMapper.deleteUserById(userId);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 根据 userID 和 loginName 获得一个用户
	 * @param userId
	 * @param loginName
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getUser")
	public Response<User> getUser(@RequestParam String loginName,
			@RequestParam String password) throws Exception {
		User user = userMapper.getUser(loginName, password);
		if(user != null){
			return setSuccess(user);
		}else{
			return setError();
		}
	}

	/**
	 * 分页显示所有 User
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getUserList")
	@Override
	public Response<PageInfo<User>> getUserList(@RequestParam(value="loginName",required =false,defaultValue="") String loginName,
			@RequestParam(value="page",required =true,defaultValue="1") Integer page,
			@RequestParam(value="limit",required =true,defaultValue="10") Integer limit) throws Exception {
		PageHelper.startPage(page-1, limit); 
		List<User> userList = userMapper.getUserList(loginName);
		PageInfo<User> pageInfo =new PageInfo<>(userList);
		 if(userList != null){
			 return setSuccess(pageInfo);
		 }else{
			 return setError();
		 }
	}

}
