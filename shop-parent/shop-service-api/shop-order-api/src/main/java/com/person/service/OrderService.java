package com.jiahua.service;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.Order;
import com.jiahua.entity.OrderDetail;
import com.jiahua.entity.User;
import com.jiahua.utlis.ShoppingCart;

/**
 * OrderService接口方法：
 * （1）结算订单（返回类型：Order对象，参数：ShoppingCart对象、User对象、收货地址）。
 * （2）根据查询条件，分页显示订单信息列表（返回类型：List<Order>，参数：当前页码、页码容量，用户id）。
 * （3）根据条件查询订单表总记录数（返回类型：int，参数：用户id）。
 * （4）根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。
 *
 */
public interface OrderService {
	@RequestMapping("/payShoppingCart")
	public Response<Order> payShoppingCart(@RequestBody(required = false) ShoppingCart cart, 
								  @RequestBody(required = false) User user,
								  @RequestParam("address") String address);
	
	@RequestMapping("/getOrderList")
	public Response<PageInfo<Order>> getOrderList(@RequestParam("userId") Integer userId,
							   @RequestParam("page") Integer page,
							   @RequestParam("limit") Integer limit);

	@RequestMapping("/count")
    public String count(@RequestParam("userId") Integer userId);
    
	@RequestMapping("/getOrderDetailList")
    public List<OrderDetail> getOrderDetailList(@RequestParam("orderId") Integer orderId);

}
