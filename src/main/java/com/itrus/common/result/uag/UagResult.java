package com.itrus.common.result.uag;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UagResult {
	
	/**
	 * 返回状态
	 */
	private String status;
	
	/**
	 * 返回消息
	 */
	private String message;
	
	
	/**
	 *     请求OK
	 *
	 * @param result json对象
	 */
	public static boolean isOk(UagResult result) {
		if(result == null ){
			return false;
		}
		return   result.getStatus().equals("0x0000") ? true : false;
	}
	
	/**
	 *     请求不OK
	 *
	 * @param result json对象
	 */
	public static boolean isNotOk(UagResult result) {
		return !isOk(result);
	}
	
}
