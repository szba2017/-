package com.jiahua.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.jiahua.service.UserService;

@FeignClient(name = "shop-user")
public interface UserFeign  extends UserService{

}
