package com.itrus.common.params;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "邮件参数实体")
@Data
@ToString
public class EmailParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 账号类型
	 */
	private String[] account;
	
	/**
	 * 发送内容
	 */
	private String content;
	
	/**
	 * 主题
	 */
	private String suject;
	
	/**
	 * 是否是html方式发送
	 */
	private Boolean html;

	public EmailParams(String[] account, String content, String suject, Boolean html) {
		super();
		this.account = account;
		this.content = content;
		this.suject = suject;
		this.html = html;
	}

	public EmailParams() {
		super();
		// TODO Auto-generated constructor stub
	}
}
