package com.itrus.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.itrus.common.WebApplication;
import com.itrus.common.exception.SmsException;
import com.itrus.common.http.SmsRequest;
import com.itrus.common.params.SmsParams;
import com.itrus.common.report.Author;

@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class SmsRequestTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private SmsRequest smsRequest;
	
	@Test(groups = "内部接口", testName = "短信发送", description = "i信短信")
	@Author(names = "wen_guoxing")
	public void smsSendIxin() throws SmsException{
		String content ="【天威诚信】您好：您的验证码为：CODE。";
		String appId = "ecea8764614149";
		String secretKey = "19d2a7192b604f29aa9ebfc319ba24b0";
		String phone = "18600584688";
		String url="http://124.205.224.179:9018/portal/sms/send";
		SmsParams smsParams = new SmsParams(
				appId, 
				null, 
				secretKey, 
				url, 
				phone, 
				content, 
				null);
		smsRequest.send(smsParams);
		Reporter.log(JSON.toJSONString(true));
	}
	
	
	@Test(groups = "内部接口", testName = "短信发送", description = "天威云短信")
	@Author(names = "wen_guoxing")
	public void smsSendTwy() throws SmsException{
		
		String content ="您好：您的验证码为：CODE。";
		String appId = "e7a765ff2a2b46";
		String secretKey = "ab6b33ae9a6f49cb8e6dba4d0520a157";
		String phone = "15010491957";
		String autograph = "【天威诚信】";
		String serviceCode = "msg0001";
		String url="http://demo-open.itruscloud.com/apigate/smsService/sendingSms";
		SmsParams smsParams = new SmsParams(
				appId, 
				serviceCode, 
				secretKey, 
				url, 
				phone, 
				content, 
				autograph);
		smsRequest.send(smsParams);
		Reporter.log(JSON.toJSONString(true));
	}
}
