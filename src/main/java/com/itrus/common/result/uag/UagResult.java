package com.itrus.common.result.uag;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UagResult<T> implements Serializable{
	
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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;
	
}
