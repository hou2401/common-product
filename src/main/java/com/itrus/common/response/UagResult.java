package com.itrus.common.response;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Data
@ToString
public class UagResult<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String CODE_KEY = "code";
	private static final Integer GET_CODE = 0;
	public static final String defaultMessage = "调用UAG失败";

	/**
	 * 返回状态
	 */
	private String code;
	
	/**
	 * 返回消息
	 */
	private String msg;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	/**
	 *     请求OK
	 *
	 * @param result json对象
	 */
	public static boolean isOk(JSONObject result) {
		if(result == null ){
			return false;
		}
		return  GET_CODE.equals(result.get(CODE_KEY)) ? true : false;
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
