package com.jiahua.fallback;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;
import com.jiahua.entity.Product;
import com.jiahua.feign.ProFeign;

@Component
@SuppressWarnings("rawtypes")
public class ProFeignFallback extends ResponseApi implements ProFeign{

	@Override
	public Response add(Product product) {
		return setWait();
	}

	@Override
	public Response update(Product product) {
		return setWait();
	}

	@Override
	public Response deleteProductById(Integer productId) {
		return setWait();
	}

	@Override
	public Response<Product> getProductById(Integer productId) {
		return setWait();
	}

	@Override
	public Response updateStock(Integer productId, Integer stock) {
		return setWait();
	}

	@Override
	public Response<PageInfo<Product>> getProductList(Product product, String preName, Integer leve, Integer page,
			Integer limit) {
		return setWait();
	}

}
