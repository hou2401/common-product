package com.itrus.common.http;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.itrus.common.params.EmailParams;

import lombok.Data;

/**
 * 邮件发送工具类
 * @author wgx52
 *
 */
@Data
@Component
public class EmailRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 邮件内容
	 */
	private String mailContent; 
	
	
	/**
	 * 邮件服务器
	 */
	private JavaMailSenderImpl  mailSender;
	
	/**
	 * 默认不使用 html
	 */
	private boolean html = false;
	
	/**
	 * 发送地址，数组格式
	 */
	private String[] toEmail = new String[]{};
	
	
	/**
	 * 主题
	 */
	private String subject;
	
	/**
	 * @param mailSender
	 * @param toEmail
	 * @param subject
	 * @param mailContent
	 * @param html
	 */
	public EmailRequest(JavaMailSenderImpl mailSender, String[] toEmail, String subject, String mailContent, 
			boolean html) {
		super();
		this.mailSender = mailSender;
		this.mailContent = mailContent;
		this.html = html;
		this.toEmail = toEmail;
		this.subject = subject;
	}

	/**
	 * html 默认false
	 * @param mailSender
	 * @param toEmail
	 * @param subject
	 * @param mailContent
	 */
	public EmailRequest(JavaMailSenderImpl mailSender, String[] toEmail, String subject, String mailContent) {
		super();
		this.mailSender = mailSender;
		this.mailContent = mailContent;
		this.toEmail = toEmail;
		this.subject = subject;
	}

	public EmailRequest() {
		super();
	}
	
	public EmailRequest(JavaMailSenderImpl mailSender, EmailParams email) {
		this.mailSender = mailSender;
		this.toEmail = email.getAccount();
		this.subject = email.getSuject();
		this.mailContent = email.getContent();
		this.html = email.getHtml();
	
	}

	public void send() throws MessagingException{
		 //加认证机制
        Properties javaMailProperties = new Properties();
    	javaMailProperties.put("mail.smtp.auth", "true"); 
    	javaMailProperties.put("mail.smtp.starttls.enable", true); 
    	javaMailProperties.put("mail.smtp.timeout", 20000); 
        mailSender.setJavaMailProperties(javaMailProperties);
		final MimeMessage mimeMessage = mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,
				"UTF-8");// 防止出现中文乱码，
		message.setFrom(mailSender.getUsername());// 设置发送方地址
		message.setTo(this.toEmail);// 设置接收方的email地址
		message.setSubject(this.subject);// 设置邮件主题
		message.setText(this.mailContent, this.html);
		mailSender.send(mimeMessage);
	}
	
	/**
	 * 使用方法
	 * @param args
	 * @throws MessagingException
	 */
	public static void main(String[] args) throws MessagingException {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("wen_guoxing@itrus.com.cn");
		mailSender.setPassword("wengx521");
		mailSender.setPort(587);
		mailSender.setHost("mail.itrus.com.cn");
		
		String [] toEmail = new String[]{"wen_guoxing@itrus.com.cn"};
		EmailRequest emailUtil = new EmailRequest(mailSender,toEmail,"test","test");
		emailUtil.send();
	}
}
