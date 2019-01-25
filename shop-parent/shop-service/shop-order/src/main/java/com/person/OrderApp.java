package com.jiahua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@MapperScan(basePackages="com.jiahua.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class,args);
	}

}
