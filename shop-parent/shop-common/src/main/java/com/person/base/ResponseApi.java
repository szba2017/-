package com.jiahua.base;

/**
 *返回的數據類型 封裝 
 */
public class ResponseApi<T> {

	/**
	 * 成功，返回结果不带 数据
	 * @param retCode
	 * @param retMsg
	 * @return
	 */
	public <T> Response<T> setSuccess(){
		return setSuccess(RtnResult.SUCCESS.getRtnCode(),RtnResult.SUCCESS.getRtnMsg(), null); 
	}
	
	/**
	 * 成功，返回带数据
	 * @param date
	 * @return
	 */
	public <T> Response<T> setSuccess(T data){
		return setSuccess(RtnResult.SUCCESS.getRtnCode(),RtnResult.SUCCESS.getRtnMsg(), data); 
	}
	
	/**
	 * 执行失败
	 * @return
	 */
	public <T> Response<T> setError(){
		return setError(RtnResult.ERROR.getRtnCode(),RtnResult.ERROR.getRtnMsg(), null); 
	}
	
	/**
	 * 执行失败
	 * @return
	 */
	public <T> Response<T> setError(T data){
		return setError(RtnResult.ERROR.getRtnCode(),RtnResult.ERROR.getRtnMsg(), data); 
	}
	
	/**
	 * 执行成功  模板
	 * @param retCode
	 * @param retMsg
	 * @param data
	 * @return
	 */
	public <T> Response<T> setSuccess(Integer retCode, String retMsg, T data){
		return new Response<T>(retCode,retMsg,data);
	}
	
	/**
	 * 执行失败 模板
	 * @param retCode
	 * @param retMsg
	 * @param data
	 * @return
	 */
	public <T> Response<T> setError(Integer retCode, String retMsg, T data){
		return new Response<T>(retCode,retMsg,data);
	}
	
	/**
	 *  访问量过大的时候，调用
	 * @param retCode
	 * @param retMsg
	 * @param data
	 * @return
	 */
	public <T>  Response<T> setWait(){
		return new Response<T>(RtnResult.WAIT.getRtnCode(),RtnResult.WAIT.getRtnMsg(),null);
	}
}
