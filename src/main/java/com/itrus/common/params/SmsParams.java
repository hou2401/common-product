package com.itrus.common.params;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel(description = "短信参数实体")
@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class SmsParams extends ServiceParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 账号类型
	 */
	private String account;
	
	/**
	 * 发送内容
	 */
	private String content;
	
	/**
	 * 短信签名
	 */
	private String signature;

	public SmsParams(String account, String content, String signature) {
		super();
		this.account = account;
		this.content = content;
		this.signature = signature;
	}

	public SmsParams() {
		super();
		// TODO Auto-generated constructor stub
	}
}
