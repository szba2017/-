package com.jiahua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	/**
     * 跳到注册页面
     *
     * @param request
     * @param response
     * @return
     */
	@RequestMapping("/register")
	public String register(){
		return "/pre/register";
	}
}
