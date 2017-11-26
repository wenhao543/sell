package com.wenhao.enums;

public enum PayStatusEnum {
	WAIT(0,"未支付"),
	SUCCESS(1,"支付完成"),
	;
	private Integer code;
	private String message;
	private PayStatusEnum(Integer code, String message) {
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
