package com.jiahua.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.jiahua.service.ProductService;

@FeignClient(name = "shop-product")
public interface OrderFeign extends ProductService{
}
