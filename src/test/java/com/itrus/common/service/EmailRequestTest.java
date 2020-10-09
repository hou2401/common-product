package com.itrus.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.itrus.common.WebApplication;
import com.itrus.common.exception.EmailException;
import com.itrus.common.http.EmailRequest;
import com.itrus.common.params.EmailParams;
import com.itrus.common.report.Author;


@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class EmailRequestTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private EmailRequest smsRequest;
	
	@Test(groups = "内部接口", testName = "邮件发送", description = "邮件发送")
	@Author(names = "wen_guoxing")
	public void EmailSend() throws  EmailException{
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("han_yanhui@itrus.com.cn");
		mailSender.setPassword("Han@743431");
		mailSender.setPort(587);
		mailSender.setHost("mail.itrus.com.cn");
		String [] toEmail = new String[]{"han806433285@qq.com"};
		EmailParams emailParams = new EmailParams(toEmail, "test", "温温测试", true, mailSender);
		smsRequest.send(emailParams);
		System.out.println( "发送完成" );
		Reporter.log(JSON.toJSONString(true));
	}
	
	public static void main(String[] args) {
		String str = "{\"suject\":\"温温测试\",\"listFile\":[],\"bytes\":[],\"html\":true,\"content\":\"test\",\"email\":[\"wen_guoxing@itrus.com.cn\"]}";
		String [] toEmail = new String[]{"wen_guoxing@itrus.com.cn"};
		EmailParams emailParams = new EmailParams(toEmail, "test", "温温测试", true, null);
		System.out.println(JSON.toJSON(emailParams));
		
	}
	
}
