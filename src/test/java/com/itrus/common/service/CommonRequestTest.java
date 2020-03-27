package com.itrus.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.WebApplication;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.http.CommonRequest;
import com.itrus.common.params.AuthEnterpriseParams;
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.report.Author;

@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class CommonRequestTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private CommonRequest commonRequest;
	
	@Test(groups = "内部接口", testName = "个人实名认证", description = "个人实名认证")
	@Author(names = "wen_guoxing")
	public void authPersion() throws  PersionAuthException{
		//servicecode  
		//两要素  idc0001
		//手机号三要素 idc0012
		//银行卡四要素 idc0004
		AuthPersionParams authPersionParams = new AuthPersionParams(
				"af346fdaab3848", 
				"idc0004", 
				"edf611789ce54938a30dce5b74af7ed9", 
				"http://demo-open.itruscloud.com/apigate/authapi/person/authIden", 
				"南建坤", 
				"130521198709140030", 
				"15010491957", 
				"6227003812990548131", 
				null, 
				null
				);
		JSONObject authPersion = commonRequest.authPersion(authPersionParams);
		System.out.println( JSON.toJSONString(authPersion) );
		Reporter.log(JSON.toJSONString(authPersion));
	}
	
	
	@Test(groups = "内部接口", testName = "企业实名认证", description = "企业实名认证")
	@Author(names = "wen_guoxing")
	public void authEnterprise() throws  PersionAuthException{
		//servicecode  
		//工商信息 idb0003
		// idc0012
		//银行卡四要素 idc0004
		//type ET_PE:企业   ET_SE:个体工商户  OU:企事业单位 （orgCode 必传， id_code  不一定 ）
		AuthEnterpriseParams authEnterpriseParams = new AuthEnterpriseParams(
		JSONObject authPersion = commonRequest.authPersion(authPersionParams);
		System.out.println( JSON.toJSONString(authPersion) );
		Reporter.log(JSON.toJSONString(authPersion));
	}
	
	
	
	
}
