package com.jiahua.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.ProductCategory;
import com.jiahua.entity.ProductCategoryParam;
import com.jiahua.feign.ProCateFeign;
import com.jiahua.utlis.ProductCategoryVo;

/**
 * ProCateFeign 熔断
 */
@SuppressWarnings("rawtypes")
@Component
public class ProCateFeignFallback extends ResponseApi implements ProCateFeign{

	@Override
	public Response<ProductCategory> getById(Integer id) {
		return setWait();
	}

	@Override
	public Response<PageInfo<ProductCategory>> queryProCategoryList(ProductCategoryParam params, Integer page,
			Integer limit) {
		return setWait();
	}

	@Override
	public String queryProductCategoryCount(ProductCategoryParam params) {
		return null;
	}

	@Override
	public Response modifyProductCategory(ProductCategory productCategory) {
		return setWait();
	}

	@Override
	public Response addProductCategory(ProductCategory productCategory) {
		return setWait();
	}

	@Override
	public Response deleteById(Integer id) {
		return setWait();
	}

	@Override
	public Response<List<ProductCategoryVo>> queryAllProductCategoryList() {
		return setWait();
	}

	@Override
	public List<ProductCategory> queryCategorylist(Integer parentId) {
		return null;
	}

}
