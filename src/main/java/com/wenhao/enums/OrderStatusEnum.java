package com.wenhao.enums;

public enum OrderStatusEnum {
	NEW(0,"已下单"),
	FINISH(1,"已完成"),
	CANCEL(2,"已取消"),
	;
	private Integer code;
	private String message;
	private OrderStatusEnum(Integer code,String message){
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
