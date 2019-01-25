package com.jiahua;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiahua.utlis.Producer;
import com.jiahua.utlis.RedisUtil;

/**
 * 测试用例
 */
@RestController
public class TestRedis {
	@Autowired
    private RedisUtil redisUtil;
	
	@Autowired
	private Producer producer;
	
	@GetMapping("/testRedis")
	public String testRedis(){
		redisUtil.set("sdfasdf", "666");
		return "666";
	}
	
	@GetMapping("/testmq")
	public String testMq(){
		Destination destination = new ActiveMQQueue("login.queue");
		producer.sendMessage(destination, "test the mq is success");
		return "mq";
	}
}
