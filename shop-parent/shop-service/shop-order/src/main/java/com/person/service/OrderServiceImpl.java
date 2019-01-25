package com.jiahua.service;

import java.util.ArrayList;
import java.util.Date;
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
import com.jiahua.entity.Order;
import com.jiahua.entity.OrderDetail;
import com.jiahua.entity.User;
import com.jiahua.feign.OrderFeign;
import com.jiahua.mapper.OrderDetailMapper;
import com.jiahua.mapper.OrderMapper;
import com.jiahua.utlis.ShoppingCart;
import com.jiahua.utlis.ShoppingCartItem;
import com.jiahua.utlis.StringUtils;

/**
 *  结算购物车物品
 * @param <T>
 */
@RestController
@Transactional
public class OrderServiceImpl<T> extends ResponseApi<T> implements OrderService{

	/**
     * 结算购物车物品包含以下步骤：
     * 1.生成订单
     * 2.生成订单明细
     * 3.更新商品表，减库存
     * 注意加入事物的控制
     */
	@Autowired
	private  OrderMapper orderDao;
	
	@Autowired
	private OrderDetailMapper orderDetailDao;

	@Autowired
	private OrderFeign productDao;
	
	@RequestMapping("/")
	public  Response<Order> payShoppingCart(ShoppingCart cart, User user, String address) {
	        Order order = new Order();
	        try {
	            //增加订单
	            order.setUserId(user.getId());
	            order.setLoginName(user.getLoginName());
	            order.setUserAddress(address);
	            order.setCreateTime(new Date());
	            order.setCost(cart.getTotalCost());
	            order.setSerialNumber(StringUtils.randomUUID());
	            orderDao.add(order);
	            //增加订单对应的明细信息
	            for (ShoppingCartItem item : cart.getItems()) {
	                OrderDetail orderDetail = new OrderDetail();
	                orderDetail.setOrderId(order.getId());
	                orderDetail.setCost(item.getCost());
	                orderDetail.setProduct(item.getProduct());
	                orderDetail.setQuantity(item.getQuantity());
	                orderDetailDao.add(orderDetail);
	                //更新商品表的库存
	                productDao.updateStock(item.getProduct().getId(), item.getQuantity());
	            }
	        } catch (Exception e) {
	            order = null;
	            return setError();
	        }   
	        return setSuccess(order);
	}

	@RequestMapping("/getOrderList")
	public Response<PageInfo<Order>> getOrderList(@RequestParam(value="userId",required =false,defaultValue="") Integer userId, 
							   @RequestParam(value="page",required =true,defaultValue="1") Integer page, 
							   @RequestParam(value="limit",required =true,defaultValue="10") Integer limit) {
	        List<Order> orderList = new ArrayList<Order>();
	        PageInfo<Order> pageInfo = null;
	        try {
	        	PageHelper.startPage(page-1, limit); 
	            orderList = orderDao.getOrderList(userId);
	            for(Order order:orderList){
	            	order.setOrderDetailList(orderDetailDao.getOrderDetailList(order.getId()));
	            }
	            pageInfo =new PageInfo<>(orderList);
	            return setSuccess(pageInfo);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return setError();
	}

	@RequestMapping("/count")
	public String count(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("/getOrderDetailList")
	public List<OrderDetail> getOrderDetailList(Integer orderId) {
	        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	        try {
	            orderDetailList = orderDetailDao.getOrderDetailList(orderId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	            return orderDetailList;
	}

}
