package com.itrus.common.params;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	 * 文件流集合
	 */
	private List<File> listFile = new ArrayList<>();
	
	/**
	 * byte[] 集合
	 */
	private List<ByteParams> bytes = new ArrayList<>();
	
	/**
	 * 邮件服务器
	 */
	private JavaMailSenderImpl  mailSender;
	
	/**
	 * 是否是html方式发送
	 */
	private Boolean html;

	/**
	 * 不带附件
	 * @param email
	 * @param content
	 * @param suject
	 * @param html
	 * @param mailSender
	 */
	public EmailParams(String[] email, String content, String suject, Boolean html, JavaMailSenderImpl  mailSender) {
		super();
		this.email = email;
		this.content = content;
		this.suject = suject;
		this.html = html;
		this.mailSender = mailSender;
	}
	
	/**
	 * 带附件
	 * @param email
	 * @param content
	 * @param suject
	 * @param html
	 * @param mailSender
	 */
	public EmailParams(String[] email, String content, String suject, Boolean html, JavaMailSenderImpl  mailSender,List<File> listFile,List<ByteParams> bytes) {
		super();
		this.email = email;
		this.content = content;
		this.suject = suject;
		this.html = html;
		this.mailSender = mailSender;
		this.listFile = listFile;
		this.bytes = bytes;
	}

	public EmailParams() {
		super();
	}
}
