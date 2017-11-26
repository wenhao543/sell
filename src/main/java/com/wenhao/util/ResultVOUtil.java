package com.wenhao.util;

import com.wenhao.VO.ResultVO;

public class ResultVOUtil {
	public static ResultVO<Object> success(Object object){
		ResultVO<Object> resultVO = new ResultVO<Object>();
		resultVO.setCode("0");
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
}
