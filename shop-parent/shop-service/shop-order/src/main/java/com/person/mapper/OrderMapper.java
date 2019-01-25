package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.Order;

/**
 * 订单  mapper
 */
public interface OrderMapper {

	/**
	 *  添加一个订单
	 * @param order
	 */
	int add(@Param("order")Order order) ;

	/**
	 * 根据订单ID删除一个订单
	 * @param id
	 */
	int deleteById(@Param("id")Integer id);
	
	/**
	 * 根据订单ID查询出一张订单
	 * @param id
	 * @return
	 */
	Order getOrderById(@Param("id")Integer id) ;
	
	/**
	 * 根据用户ID查询出他的所有订单，分页显示
	 * @param userId
	 * @param currentPageNo
	 * @return
	 */
	List<Order> getOrderList(@Param("userId")Integer userId) ;
	
}
