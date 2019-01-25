package com.jiahua.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.jiahua.fallback.ProFeignFallback;
import com.jiahua.service.ProductService;

@FeignClient(name = "shop-product",fallback = ProFeignFallback.class)
public interface ProFeign extends ProductService{

}
