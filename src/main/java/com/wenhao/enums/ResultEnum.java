package com.wenhao.enums;

public enum ResultEnum {
	PRODUCT_NOT_EXIST("0","商品不存在"),
	
	
	DATA_UPDATE_FAIL("01","数据库更新失败！")
	;
	private String code;
	private String message;
	private ResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
