package com.jiahua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.UserAddress;
import com.jiahua.entity.UserAddressParam;
import com.jiahua.mapper.UserAddressMapper;

@RestController
@Transactional
public class UserAddressServiceImpl<T> extends ResponseApi<T> implements UserAddressService {

	@Autowired
	private UserAddressMapper userAddressDao;

	/**
	 * 根据 查询用户地址 列表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryUserAdressList")
	public Response<PageInfo<UserAddress>> queryUserAdressList(@RequestParam(value = "id", required = true, defaultValue = "") Integer id,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) throws Exception {
		List<UserAddress> userAddressList = null;
		try {
			UserAddressParam params = new UserAddressParam();
			params.setUserId(id);
			PageHelper.startPage(page-1,limit);
			userAddressList = userAddressDao.queryUserAddressList(params);
			PageInfo<UserAddress> pageInfo = new PageInfo<UserAddress>();
			return setSuccess(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setError();
	}

	/**
	 * 给用户添加地址
	 * 
	 * @param id
	 * @param address
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addUserAddress")
	public Response addUserAddress(Integer id, String address, String remark) throws Exception {
	        int num = 0;
	        try {
	            UserAddress userAddress=new UserAddress();
	            userAddress.setUserId(id);
	            userAddress.setAddress(address);
	            userAddress.setRemark(remark);
	            num = userAddressDao.add(userAddress);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        if(num>0){
	        	return setSuccess();
	        }else{
	        	 return setError();
	        }
	       
	}

	/**
	 * 根据id查询地址
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUserAddressById")
	public Response<UserAddress> getUserAddressById(Integer id) {
	        UserAddress userAddress= null;
	        try {
	            userAddress = (UserAddress) userAddressDao.getUserAddressById(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        if(userAddress != null){
	        	return  setSuccess(userAddress);
	        }else{
	        	return setError();
	        }
	}

}
