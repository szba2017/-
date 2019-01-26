package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.ProductCategory;
import com.jiahua.entity.ProductCategoryParam;

public interface ProductCategoryMapper {

	/**
	 * 根据id删除商品
	 * @param parseLong
	 */
	int delete(@Param("id") Integer id);//删除商品分类
	/**
	 * 根据条件查询商品列表
	 * @param param
	 */
	List<ProductCategory> queryCatelist(@Param("productCateg") ProductCategoryParam productCateg);
	/**
	 * 根据id查询商品分类
	 * @param param
	 */
	ProductCategory queryProductCategoryById(@Param("id") Integer id);
	/**
	 * 添加商品分类
	 * @param param
	 */
	Integer add(@Param("productCategory") ProductCategory productCategory) ;
	/**
	 * 根据参数查询商品分类的数目
	 * @param param
	 */
	Integer queryProductCategoryCount(ProductCategoryParam param);
	/**
	 * 修改商品分类
	 * @param param
	 */
	Integer modify(@Param("productCategory")ProductCategory productCategory) ;

}
