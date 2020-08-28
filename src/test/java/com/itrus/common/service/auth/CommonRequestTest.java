package com.itrus.common.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.WebApplication;
import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.http.CommonRequest;
import com.itrus.common.report.Author;
import com.itrus.common.request.auth.AuthPersionParams;
import com.itrus.common.request.auth.AuthPersionRequest;
import com.itrus.common.request.auth.AuthPersionVideoParams;
import com.itrus.common.utils.Img2Base64Util;

@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class CommonRequestTest extends AbstractTestNGSpringContextTests {

	
	
	@Autowired
	private CommonRequest commonRequest;
	
	@Autowired
	private  callApiUrl;
	
	private final static  String appId = "a929cd69afae46";
	
	private final static String  secretKey = "7d837a8f7b164c8887802cc94815b6db";
	
	private final static String url = "http://demo-open.itruscloud.com/apigate/authapi";
	
	@Test(groups = "内部接口", testName = "个人实名认证", description = "个人实名认证")
	@Author(names = "wen_guoxing")
	public void authPersion() throws  PersionAuthException{
		
		
		System.out.println(callApiUrl.toString());
		
		//servicecode  
		//两要素  idc0001
		//手机号三要素 idc0012
		//银行卡四要素 idc0004
		AuthPersionRequest authPersionParams = new AuthPersionRequest(
				appId, 
				"idc0001", 
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
	
	
	@Test(groups = "内部接口", testName = "个人实名认证-h5-获取唇语数字接口", description = "h5接口--数读获取{\"lips\":\"0578\",\"orderNo\":\"idc202003282225082399160\",\"message\":\"成功\",\"status\":1}")
	@Author(names = "wen_guoxing")
	public void authPersionVideoLips() throws  PersionAuthException{
		//servicecode  
		AuthPersionVideoParams authPersionParams = new AuthPersionVideoParams(
				appId, 
				"idc2001", 
				secretKey, 
				url+"/h5/getlips", 
				"陈扬", 
				"211421199602082416", 
				null, 
				null
				);
		JSONObject authPersion = commonRequest.auth(authPersionParams);
		Reporter.log(JSON.toJSONString(authPersion),true);
	}
	
	/**
	 * 	//servicecode  
		//数读idc2001
		//静默idc2002
		//使用过程中，视频如果超过1M，需要进行压缩操作
		//VideoEncodeUtil.encode(source, target);
		//com.itrus.common.utils.VideoEncodeUtil
	 * @throws PersionAuthException
	 */
	@Test(groups = "内部接口", testName = "个人实名认证-h5-验证熟读接口&验证静默接口，只是服务编码不一样", description = "数读idc2001 静默idc2002使用过程中，视频如果超过1M，需要进行压缩操作,使用此目录的压缩方法 com.itrus.common.utils.VideoEncodeUtil.encode(source, target);")
	@Author(names = "wen_guoxing")
	public void authPersionVideo() throws  PersionAuthException{
		String videoFile=Img2Base64Util.getImgStr("e:\\h5_ys.mp4"); 
		AuthPersionVideoParams authPersionParams = new AuthPersionVideoParams(
				appId, 
				"idc2001", 
				secretKey, 
				url+"/h5/bodyFaceCheck", 
				"陈扬", 
				"211421199602082416", 
				"idc202003282225082399160", 
				videoFile
				);
		JSONObject authPersion = commonRequest.auth(authPersionParams);
		Reporter.log(JSON.toJSONString(authPersion),true);
	}
	
	
	@Test(groups = "内部接口", testName = "企业实名认证", description = "企业实名认证")
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
	}
	
	
	@Test(groups = "内部接口", testName = "企业法人四要素认证", description = "企业实名认证")
	@Author(names = "wen_guoxing")
	public void authEnterpriselegalPersonAuth() throws  EnterpriseAuthException{
		//servicecode  
		//工商信息 idb0003
		// 企业法人四要素 idb0031
		//type ET_PE:企业   ET_SE:个体工商户  OU:企事业单位 （orgCode 必传， id_code  不一定 ）
		
		//String appId,
		   String serviceCode, 
		   String secretKey, 
		   String url, 
		   String name,
		String type, 
		String idCode, 
		String orgCode, 
		String legalName, 
		String legalId, 
		String legalUrl,
		String legalImg, 
		String agentName, String agentId, String agentUrl, String agentImg
		AuthEnterpriseParams authEnterpriseParams = new AuthEnterpriseParams(
				appId, 
				"idb0033", 
				secretKey, 
				url+"/enterprise/authIden", 
				"北京天威诚信电子商务服务有限公司", 
				"ET_PE", 
				"911101088020176153", 
				null, 
				"张强", 
				"220724198701155432", 
				null, 
				null, 
				null, 
				null, 
				null, 
				null
				);
		JSONObject authEnterprise = commonRequest.auth(authEnterpriseParams);
		Reporter.log(JSON.toJSONString(authEnterprise),true);
	}
	
}
