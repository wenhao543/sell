package com.wenhao.exception;

import com.wenhao.enums.ResultEnum;

/**
 * 自定义异常类
 * @author wenhao
 *
 */
public class SellException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public String getCode() {
		return code;
	}
}