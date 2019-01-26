package com.jiahua.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.Product;

/**
 * 纯商品信息的 service层
 */
public interface ProductService {

	/**
	 * 添加商品
	 * @param product
	 * @return
	*/
	@SuppressWarnings("rawtypes")
	@RequestMapping("/add")
	Response add(@RequestBody(required = false) Product product);
	
	/**
	 * 修改商品
	 * @param product
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/update")
	Response update(@RequestBody(required = false) Product product);
	
	/**
	 * 根据商品ID删除商品
	 * @param productId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteProductById")
	Response deleteProductById(@RequestParam(value = "productId")Integer productId);
	
	/**
	 * 根据商品ID查找商品
	 * @param productId
	 * @return
	 */
	@RequestMapping("/getProductById")
	Response<Product> getProductById(@RequestParam(value = "productId") Integer productId);
	
	/**
	 * 分页显示商品
	 * @param product
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getProductList")
	Response<PageInfo<Product>> getProductList( Product product,
								@RequestParam(value = "preName")  String preName,
								@RequestParam(value = "leve")  Integer leve,
								@RequestParam(value = "page") Integer page,
								@RequestParam(value = "limit") Integer limit);
	
	/**
	 * 修改商品库存
	 * @param productId
	 * @param stock
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/updateStock")
	Response updateStock(@RequestParam(value = "productId") Integer productId,
							  @RequestParam(value = "stock") Integer stock);
}
