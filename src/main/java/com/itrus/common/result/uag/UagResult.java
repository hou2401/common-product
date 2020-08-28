package com.itrus.common.result.uag;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Data
@ToString
@AllArgsConstructor
public class UagResult<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Integer GET_CODE = 0;
	public static final String DATA_KEY = "data";
	public static final String defaultMessage = "调用用户中心失败";

	/**
	 * 返回状态
	 */
	public Integer code;
	
	/**
	 * 返回消息
	 */
	public String msg;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public T data;

	/**
	 *     请求OK
	 *
	 * @param result json对象
	 */
	public boolean isOk() {
		return  GET_CODE.equals(code) ? true : false;
	}

	/**
	 *     请求不OK
	 *
	 * @param result json对象
	 */
	public boolean isNotOk() {
		return !isOk();
	}

	/**
	 * 获取响应失败提示语
	 */
	public String getMessage() {
		if(StringUtils.isBlank(msg)) {
			return defaultMessage;
		}
		return msg;
	}

}
