package com.jiahua.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.entity.ProductCategory;
import com.jiahua.entity.ProductCategoryParam;
import com.jiahua.utlis.ProductCategoryVo;

/**
 * 商品 service 层
 */
public interface ProductCategoryService {

	 /**
     * 根据id查询商品分类
     * @param id
     * @return
     */
	@RequestMapping("/getById")
    Response<ProductCategory> getById(@RequestParam("id")Integer id);
    /**
     * 查询商品分类列表
     * @param params
     * @return
     */
	@RequestMapping("/queryProCategoryList")
    Response<PageInfo<ProductCategory>> queryProCategoryList(@RequestBody(required = false) ProductCategoryParam params,
    		@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit);
    
	/**
     * 查询数目
     * @param params
     * @return
     */
	@RequestMapping("/queryProductCategoryCount")
    String queryProductCategoryCount(@RequestBody(required = false) ProductCategoryParam params);
    
	/**
     * 修改商品分类
     * @param params
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/modifyProductCategory")
    Response modifyProductCategory(@RequestBody(required = false) ProductCategory productCategory);
   
	/**
     * 添加商品分类
     * @param params
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addProductCategory")
    Response addProductCategory(@RequestBody(required = false) ProductCategory productCategory);
    
    /**
     * 根据id删除
     * @param id
     */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/deleteById")
    Response deleteById(@RequestParam("id")Integer id);
    
	/**
     * 查询全部的商品分类
     * @return
     */
	@RequestMapping("/queryAllProductCategoryList")
    Response<List<ProductCategoryVo>> queryAllProductCategoryList();
	
	 /**
     * 查询子分类
     * @param parentId
     * @return
     */
	@RequestMapping("/getProductCat")
	List<ProductCategory> queryCategorylist(@RequestParam("parentId")Integer parentId);
}
