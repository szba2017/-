package com.jiahua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiahua.entity.Product;

public interface ProductMapper {

	/**
	 * 添加商品
	 * @param product
	 * @return
	*/
	int add(Product product);
	
	/**
	 * 修改商品
	 * @param product
	 * @return
	 */
	int update(Product product);
	
	/**
	 * 根据ID删除商品
	 * @param productId
	 * @return
	 */
	int deleteProductById(@Param("productId")Integer productId);
	
	/**
	 * 根据ID 查找商品
	 * @param productId
	 * @return
	 */
	Product getProductById(Integer productId);
	
	/**
	 * 分页显示商品
	 * @param proName 		商品名称
	 * @param categoryId 	类别ID
	 * @return
	 */
	List<Product> getProductList(@Param("product")Product product,
								@Param("proName")String proName,
								@Param("leve")Integer	leve);
	
	/**
	 * 修改商品库存
	 * @param productId
	 * @param stock 库存
	 * @return
	 */
	int updateStock(@Param("productId")Integer productId,
						   @Param("stock")Integer stock);
}
