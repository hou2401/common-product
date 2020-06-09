package com.itrus.common.result.uag;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UagResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回状态
	 */
	private String code;
	
	/**
	 * 返回消息
	 */
	private String msg;
	
	private JSONObject data;
	
	
	public static final String defaultMessage = "调用UAG失败";
	
	public static final String messageKey = "msg";
	
	public static final String DATA_KEY = "data";
	
	private static final String CODE_KEY = "code";
	
	/**
	 *     请求OK
	 *
	 * @param result json对象
	 */
	public static boolean isOk(JSONObject result) {
		if(result == null ){
			return false;
		}
		return   "0x0000".equals(result.get(CODE_KEY)) ? true : false;
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
		if( isOk(result)){
			//1001  手机号已经存在
			return   "1001".equals(result.get(CODE_KEY)) ? 
					true : false;
		}
		return false;
		
	}
	
	/**
	 * 获取响应失败提示语
	 */
	public static String getMessage(JSONObject jsonObject) {
		if(jsonObject == null) {
			return defaultMessage;
		}
		String string = jsonObject.getString("msg");
		if(StringUtils.isNotBlank(string)) {
			return string;
		}
		return defaultMessage;
	}
	
	
}
