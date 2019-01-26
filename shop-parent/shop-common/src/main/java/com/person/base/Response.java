package com.jiahua.base;

/**
 * 返回的數據entity
 * @param <T>
 */
public class Response<T> {

	/**
	 * 返回的狀態碼
	 */
	private Integer retCode;
	
	/**
	 * 返回的信息
	 */
	private String retMsg;
	
	/**
	 * 返回的數據
	 */
	private T Date;

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public T getDate() {
		return Date;
	}

	public void setDate(T date) {
		Date = date;
	}

	
	public Response() {
	}

	public Response(Integer retCode, String retMsg, T date) {
		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
		Date = date;
	}
	
}
