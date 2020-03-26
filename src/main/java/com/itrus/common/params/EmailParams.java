package com.itrus.common.params;

import java.io.Serializable;

import org.springframework.mail.javamail.JavaMailSenderImpl;

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
	private String[] email;
	
	/**
	 * 发送内容
	 */
	private String content;
	
	/**
	 * 主题
	 */
	private String suject;
	
	/**
	 * 邮件服务器
	 */
	private JavaMailSenderImpl  mailSender;
	
	/**
	 * 是否是html方式发送
	 */
	private Boolean html;

	public EmailParams(String[] email, String content, String suject, Boolean html, JavaMailSenderImpl  mailSender) {
		super();
		this.email = email;
		this.content = content;
		this.suject = suject;
		this.html = html;
		this.mailSender = mailSender;
	}

	public EmailParams() {
		super();
	}
}
