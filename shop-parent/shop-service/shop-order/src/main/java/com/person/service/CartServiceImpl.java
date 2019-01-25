package com.jiahua.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.utlis.ShoppingCart;
import com.jiahua.utlis.ShoppingCartItem;

@RestController
@Transactional
public class CartServiceImpl<T> extends ResponseApi<T> implements CartService{

	@Override
	@RequestMapping("/modifyShoppingCart")
	public Response<ShoppingCart> modifyShoppingCart(@RequestParam String productId, 
									 @RequestParam Integer quantityStr, 
									 @RequestParam ShoppingCart cart) throws Exception {
		Integer quantity = 0;
        //遍历购物车寻找该商品 修改其数量
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getProduct().getId().toString().equals(productId)) {
                if (quantity == 0 || quantity < 0) {
                    cart.getItems().remove(item);
                    break;
                } else {
                    item.setQuantity(quantity);
                }
            }
        }
        //重新计算金额
        calculate(cart);
        return setSuccess(cart);
	}

	 /**
     * 核算购物车的金额
     *
     * @param cart
     * @return
     * @throws Exception
     */
	public ShoppingCart calculate(ShoppingCart cart) throws Exception {
		   double sum = 0.0;
	        for (ShoppingCartItem item : cart.getItems()) {
	            sum = sum + item.getQuantity() * item.getProduct().getPrice();
	            item.setCost(item.getQuantity() * item.getProduct().getPrice());
	        }
	        cart.setSum(sum);
	        return cart;
	}

}
