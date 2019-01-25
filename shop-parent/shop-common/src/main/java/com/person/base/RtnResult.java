package com.jiahua.base;

public enum RtnResult {

	SUCCESS(200,"success"),ERROR(500,"error"),WAIT(101,"正在处理。。。");
	
	/**
	 * 返回的编码
	 */
	private Integer rtnCode;
	
	/**
	 * 返回的信息
	 */
	private String rtnMsg;
	
	public Integer getRtnCode() {
		return rtnCode;
	}
	public void setRtnCode(Integer rtnCode) {
		this.rtnCode = rtnCode;
	}
	public String getRtnMsg() {
		return rtnMsg;
	}
	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}
	private RtnResult(Integer rtnCode, String rtnMsg) {
		this.rtnCode = rtnCode;
		this.rtnMsg = rtnMsg;
	}
	
	
}
