package com.jiahua.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiahua.base.Response;
import com.jiahua.utlis.ShoppingCart;

/**
 * 订单详情的接口
 */
public interface CartService {

	@RequestMapping("/modifyShoppingCart")
	public Response<ShoppingCart> modifyShoppingCart(@RequestParam("productId") String productId, 
			 @RequestParam("quantityStr") Integer quantityStr, 
			 @RequestBody ShoppingCart cart) throws Exception;

	 /**
     * 核算购物车的金额
     *
     * @param cart
     * @return
     * @throws Exception
     */
	@RequestMapping("/calculate")
    public ShoppingCart calculate(@RequestBody(required = false) ShoppingCart cart)throws Exception;
}
