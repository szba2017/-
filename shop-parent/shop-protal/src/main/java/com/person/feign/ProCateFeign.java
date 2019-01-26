package com.jiahua.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.jiahua.fallback.ProCateFeignFallback;
import com.jiahua.service.ProductCategoryService;

@FeignClient(name = "shop-product",fallback = ProCateFeignFallback.class)
public interface ProCateFeign extends ProductCategoryService{ 

}
