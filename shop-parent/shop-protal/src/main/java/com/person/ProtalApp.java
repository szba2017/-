package com.jiahua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude=
{DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableHystrix
public class ProtalApp {

	public static void main(String[] args) {
		SpringApplication.run(ProtalApp.class, args);
	}
}
