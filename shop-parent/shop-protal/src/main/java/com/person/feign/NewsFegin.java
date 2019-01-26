package com.jiahua.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.jiahua.fallback.NewsFeginFallback;
import com.jiahua.service.NewsService;

@FeignClient(name="shop-news",fallback = NewsFeginFallback.class)
public interface NewsFegin extends NewsService{

}
