package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.UserAddress;
import com.jiahua.entity.UserAddressParam;

/**
 * 收货地址
 *
 */
public interface UserAddressMapper {

	/**
	 * 查询出 所有符合条件的 订单信息
	 * @param param
	 * @return
	 */
	List<UserAddress> queryUserAddressList(UserAddressParam param);
	
	/**
	 * 添加一个收货地址
	 * @param userAddress
	 * @return
	 */
	int add(@Param("userAddress") UserAddress userAddress);
	
	/**
	 * 根据收货地址ID查询出收货地址
	 * @param addressId
	 * @return
	 */
	UserAddress getUserAddressById(@Param("addressId") Integer addressId);

	/**
	 * 删除一个收货地址
	 * @return
	 */
	int deleteByAddressId(@Param("addressId") Integer addressId);
	
}
