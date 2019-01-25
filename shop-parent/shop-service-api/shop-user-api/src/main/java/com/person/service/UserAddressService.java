package com.jiahua.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.UserAddress;


/**
 * user 详细信息  的 service
 */
public interface UserAddressService {
   
	/**
     * 根据id 查询用户地址
     * @param id
     * @return
     * @throws Exception
     */
	@RequestMapping("/queryUserAdressList")
    Response<PageInfo<UserAddress>> queryUserAdressList(@RequestParam(value="id",required =true,defaultValue="") Integer id,
			@RequestParam(value="page",required =true,defaultValue="1") Integer page,
			@RequestParam(value="limit",required =true,defaultValue="10") Integer limit ) throws Exception;
   
	/**
     * 给用户添加地址
     * @param id
     * @param address
     * @return
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addUserAddress")
     Response addUserAddress(@RequestParam("id")Integer id, 
    		 @RequestParam("address")String address, 
    		 @RequestParam("remark")String remark) throws Exception;
   
	/**
     * 根据id查询地址
     * @param id
     * @return
     */
	@RequestMapping("/getUserAddressById")
    Response<UserAddress> getUserAddressById(@RequestParam("id")Integer id);

}
