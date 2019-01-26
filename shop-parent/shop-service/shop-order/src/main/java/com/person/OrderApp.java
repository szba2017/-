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
<<<<<<< HEAD
@EnableHystrix
=======
>>>>>>> c755db79c49b1f64c240201b796a75c54c695633
public class OrderApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class,args);
	}

}
