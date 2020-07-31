package com.itrus.common.params;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 短信参数实体
 * @author wgx52
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class SmsParams extends ServiceParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 账号
	 */
	private String phone;
	
	/**
	 * 发送内容
	 */
	private String content;
	
	/**
	 * 短信签名
	 */
	private String signature;
	
	

	public SmsParams(String phone, String content, String signature) {
		super();
		this.phone = phone;
		this.content = content;
		this.signature = signature;
	}

	public SmsParams() {
		super();
	}

	public SmsParams(String appId, String serviceCode, String secretKey, String url, String phone, String content,
			String signature) {
		super(appId, serviceCode, secretKey, url);
		this.phone = phone;
		this.content = content;
		this.signature = signature;
	}
}
