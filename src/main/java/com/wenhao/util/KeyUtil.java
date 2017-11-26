package com.wenhao.util;

import java.util.Random;

public class KeyUtil {
	/**
	 * 生成唯一主键
	 * 时间戳+随机数
	 * @return
	 */
	public static synchronized String getUniqueKey(){
		Random random = new Random();
		Integer i = random.nextInt(900000)+100000;//6位随机数
		return System.currentTimeMillis()+Integer.toString(i);
	}
	
	public static void main(String[] args) {
		System.out.println(getUniqueKey());
	}
}
