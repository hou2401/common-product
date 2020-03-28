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
import com.itrus.common.params.AuthPersionParams;
import com.itrus.common.report.Author;

@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class CommonRequestTest extends AbstractTestNGSpringContextTests {

	
	
	@Autowired
	private CommonRequest commonRequest;
	
	private final static  String appId = "af346fdaab3848";
	
	private final static String  secretKey = "edf611789ce54938a30dce5b74af7ed9";
	
	private final static String url = "http://demo-open.itruscloud.com/apigate/authapi";
	
	@Test(groups = "内部接口", testName = "个人实名认证", description = "个人实名认证")
	@Author(names = "wen_guoxing")
	public void authPersion() throws  PersionAuthException{
		//servicecode  
		//两要素  idc0001
		//手机号三要素 idc0012
		//银行卡四要素 idc0004
		AuthPersionParams authPersionParams = new AuthPersionParams(
				appId, 
				"idc0004", 
				secretKey, 
				url+"/person/authIden", 
				"南建坤", 
				"130521198709140030", 
				"15010491957", 
				"6227003812990548131", 
				null, 
				null
				);
		JSONObject authPersion = commonRequest.auth(authPersionParams);
		Reporter.log(JSON.toJSONString(authPersion),true);
	}
	
	
	/*@Test(groups = "内部接口", testName = "企业实名认证", description = "企业实名认证")
	@Author(names = "wen_guoxing")
	public void authEnterprise() throws  EnterpriseAuthException{
		//servicecode  
		//工商信息 idb0003
		//type ET_PE:企业   ET_SE:个体工商户  OU:企事业单位 （orgCode 必传， id_code  不一定 ）
		AuthEnterpriseParams authEnterpriseParams = new AuthEnterpriseParams(
				appId, 
				"idb0003", 
				secretKey, 
				url+"/enterprise/authIden", 
				"北京天威诚信电子商务服务有限公司", 
				"ET_PE", 
				"911101088020176153", 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null
				);
		JSONObject authEnterprise = commonRequest.auth(authEnterpriseParams);
		Reporter.log(JSON.toJSONString(authEnterprise),true);
	}*/
	
	
	
	
}
