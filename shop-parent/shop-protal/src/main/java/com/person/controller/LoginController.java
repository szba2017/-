package com.jiahua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiahua.entity.User;
import com.jiahua.feign.UserFeign;

@Controller
public class LoginController {

	@Autowired
	private UserFeign userFeign;

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("status", 1);
		model.addAttribute("retMsg", "用户名或密码错误");
		return "/pre/login";
	}

	// 如果遇到乱码或者无法解析的时候，requestMapping添加如下代码
	// produces = "application/json;charset=UTF-8"
	@ResponseBody
	@RequestMapping(value = "/loginMethod")
	public String loginMethod( User user) throws Exception{
		JSONObject result = new JSONObject();
			User rstuser = userFeign.getUser(user.getLoginName(), user.getPassword()).getDate();
			if(rstuser == null){
				result.put("retMsg", "用户名或密码错误");
			}else{
				result.put("status", 1);
			}
		return result.toJSONString();
	}
}
