package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.OrderDetail;

/**
 * 订单详细
 * 
 */
public interface OrderDetailMapper {

	/**
	 * 添加订单详情 
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	int add(@Param("orderDetail")OrderDetail orderDetail) throws Exception;

	/**
	 * 删除订单详情
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	int deleteById(@Param("id")Integer id) throws Exception;

	/**
	 * 根据ID获得  OrderDetail对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	OrderDetail getOrderDetailById(@Param("id")Integer id) throws Exception;

	/**
	 * 根据订单ID查询出所有订单详情信息
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	List<OrderDetail> getOrderDetailList(@Param("orderId")Integer orderId) throws Exception;

	//Integer queryOrderDetailCount(@Param("orderDetailParam")OrderDetailParam orderDetailParam) throws Exception;
}
