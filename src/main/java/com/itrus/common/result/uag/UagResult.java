package com.itrus.common.result.uag;

import com.alibaba.fastjson.JSONObject;

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
	
	
	public static final String defaultMessage = "调用UAG失败";
	
	public static final String messageKey = "message";
	
	/**
	 *     请求OK
	 *
	 * @param result json对象
	 */
	public static boolean isOk(JSONObject result) {
		
		if(result == null ){
			return false;
		}
		UagResult uagResult = JSONObject.toJavaObject(result, UagResult.class);
		if( uagResult == null ) {
			return false;
		}
		
		return   uagResult.getStatus().equals("0x0000") ? true : false;
	}
	
	/**
	 *     请求不OK
	 *
	 * @param result json对象
	 */
	public static boolean isNotOk(JSONObject result) {
		return !isOk(result);
	}
	
}
