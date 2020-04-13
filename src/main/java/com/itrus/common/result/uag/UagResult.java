package com.itrus.common.result.uag;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.ToString;

@Data
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
		UagResult uagResult = JSONObject.parseObject(result.toJSONString(), UagResult.class);
		if( uagResult == null ) {
			return false;
		}
		
		return   "0x0000".equals(uagResult.getStatus()) ? true : false;
	}
	
	/**
	 *     请求不OK
	 *
	 * @param result json对象
	 */
	public static boolean isNotOk(JSONObject result) {
		return !isOk(result);
	}
	
	
	/**
	 *  是否存在
	 *
	 * @param result json对象
	 */
	public static boolean isExist(JSONObject result) {
		if(result == null ){
			return false;
		}
		UagResult uagResult = JSONObject.parseObject(result.toJSONString(), UagResult.class);
		if( uagResult == null ) {
			return false;
		}
		
		return   "0x0001".equals(uagResult.getStatus()) ? true : false;
	}
	
}
