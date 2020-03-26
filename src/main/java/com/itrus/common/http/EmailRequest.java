package com.itrus.common.http;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.itrus.common.exception.EmailException;
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

	public EmailRequest() {
		super();
	}
	
	/**
	 * 
	 * @param email
	 * @param mailSender
	 * @throws EmailException 
	 * @throws MessagingException
	 */
	public void send(EmailParams email) throws EmailException{
		 //加认证机制
		JavaMailSenderImpl mailSender = email.getMailSender();
		Properties javaMailProperties = mailSender.getJavaMailProperties();
		Object object = javaMailProperties.get("mail.smtp.auth");
		if( object == null ) {
			//设置默认的，可以自定义参数
			javaMailProperties.put("mail.smtp.auth", true); 
			javaMailProperties.put("mail.smtp.starttls.enable", true); 
			javaMailProperties.put("mail.smtp.timeout", 20000); 
			mailSender.setJavaMailProperties(javaMailProperties);
		}
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message;
		try {
			message = new MimeMessageHelper(mimeMessage, true,
					"UTF-8");// 防止出现中文乱码，
			message.setFrom(mailSender.getUsername());// 设置发送方地址
			message.setTo(email.getEmail());// 设置接收方的email地址
			message.setSubject(email.getSuject());// 设置邮件主题
			message.setText(email.getContent(), email.getHtml());
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			throw new EmailException(e);
		}
	}
	
	/**
	 * 使用方法
	 * @param args
	 * @throws MessagingException
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("wen_guoxing@itrus.com.cn");
		mailSender.setPassword("***");
		mailSender.setPort(587);
		mailSender.setHost("mail.itrus.com.cn");
		String [] toEmail = new String[]{"wen_guoxing@itrus.com.cn"};
		EmailParams emailParams = new EmailParams(toEmail, "test", "温温测试", true, mailSender);
		EmailRequest emailUtil = new EmailRequest();
		emailUtil.send(emailParams);
		
		System.out.println( "发送完成" );
	}
}
