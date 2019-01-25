package com.jiahua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.Product;
import com.jiahua.mapper.ProductMapper;

/**
 * 商品的操作
 */
@RestController
@Transactional
public class ProductServiceImpl<T> extends ResponseApi<T> implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 添加商品
	 * @param product
	 * @return
	*/
	@SuppressWarnings("rawtypes")
	public Response add(Product product) {
		int num = productMapper.add(product);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 修改商品
	 * @param product
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Response update(Product product) {
		int num = productMapper.update(product);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 根据商品ID删除商品
	 * @param productId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Response deleteProductById(Integer productId) {
		int num = productMapper.deleteProductById(productId);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

	/**
	 * 根据商品ID查找商品
	 * @param productId
	 * @return
	 */
	public Response<Product> getProductById(Integer productId) {
		Product product = productMapper.getProductById(productId);
		if(product != null){
			return setSuccess(product);
		}else{
			return setError();
		}
	}

	/**
	 * 分页显示商品
	 */
	public Response<PageInfo<Product>> getProductList(@RequestBody Product product,
			@RequestParam(value = "preName",required = false) String preName,
			@RequestParam(value = "leve",required = false) Integer leve,
			@RequestParam(value="page",required=true,defaultValue="1") Integer page,
			@RequestParam(value="limit",required=true,defaultValue="10") Integer limit){
		PageHelper.startPage(page -1,limit);
		List<Product> productList = productMapper.getProductList(product,preName,leve);
		PageInfo<Product> pageInfo = new PageInfo<>(productList);
		return setSuccess(pageInfo);
	}

	/**
	 * 修改商品库存
	 * @param productId
	 * @param stock
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Response updateStock(@RequestParam Integer productId,@RequestParam Integer stock) {
		int num  = productMapper.updateStock(productId, stock);
		if(num>0){
			return setSuccess();
		}else{
			return setError();
		}
	}

}
