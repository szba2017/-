package com.jiahua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.jiahua.mapper")
public class NewApp {

	public static void main(String[] args) {
		SpringApplication.run(NewApp.class, args);
	}

}
