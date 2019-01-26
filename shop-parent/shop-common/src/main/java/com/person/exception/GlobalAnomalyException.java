package com.jiahua.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiahua.base.Response;
import com.jiahua.base.ResponseApi;

/**
 * 定义全局异常
 */
@Component
@ControllerAdvice
public class GlobalAnomalyException extends ResponseApi<JSONObject>{
	
	@ExceptionHandler(value=RuntimeException.class)
	@ResponseBody
	public Response<JSONObject> getException(){
		return  setError();
	}
}
