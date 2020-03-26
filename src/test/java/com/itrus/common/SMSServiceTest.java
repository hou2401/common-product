package com.itrus.common;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

import org.apache.http.entity.ByteArrayEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itrus.common.exception.SmsException;
import com.itrus.common.utils.HMACSHA1;
import com.itrus.common.utils.HttpTools;
import com.itrus.common.utils.HttpTools.HttpData;

public class SMSServiceTest {

	private static String APPID = "1830963abc0144c";

	private static String APPKEY = "5d71e828914d484688e7608e8f7fb748";

	private static RestTemplate restTemplate;

	static{
		restTemplate = new RestTemplate();
	}

	public static void main(String[] args) throws Exception {
		String url = "http://124.205.224.179:9018/portal/sms/send";
		String mphone = "15010491957";
		String content = "【天威诚信】您好：您的验证码为：CODE。";
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appid", APPID);
		map.add("mphone", mphone);
		map.add("content", content);
		
		
		
		try {
			HttpData data = HttpData.instance()
					.addHeader("authHmac", Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(APPID + content + mphone, APPKEY)))
					//.addHeader(TwyRequestHeaderConstants.CONTEXT_TYPE, TwyRequestHeaderConstants.CONTEXT_TYPE_JSON)
					.setPostEntity(new ByteArrayEntity(JSON.toJSONBytes(map)));
			HttpTools.ResponseEntity responseEntity = HttpTools.post(url, data);
			if (responseEntity.isOk()) {
	            JSONObject jsonObject = JSON.parseObject(responseEntity.getContent());
	            	Integer retCode = jsonObject.getInteger("retCode");
	            	if (!Objects.equals(retCode, 1000)) {
	            		// TODO:出证申请失败处理
	            		throw new SmsException("retCode="+retCode+"retMsg="+jsonObject.get("retMsg"));
	            	} 
	            	// TODO:出证申请成功处理
	            
	        } else {
	            // TODO：Http调用失败处理
	        	throw new SmsException(responseEntity.getMessage());
	        }
		} catch (SmsException | IOException e) {
			throw new SmsException("发送短信错误");
		}
		
		/*final Map<String, Object> params = new HashMap<>();
		params.put("appid", APPID);
		params.put("mphone", mphone);
		params.put("content", content);
		final Map<String, String> header = new HashMap<>();
		header.put("authHmac", Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(APPID + content + mphone, APPKEY)));
		String doPost = HttpUtil.doPost(url,params,header);
		System.out.println(doPost);*/
		/*try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("authHmac", Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(APPID + content + mphone, APPKEY)));
			System.out.println(Base64.getEncoder().encode(HMACSHA1.getHmacSHA1(APPID + content + mphone, APPKEY)));
			HttpEntity httpEntity = new HttpEntity(map, headers);
			ResponseEntity<String> resStr = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
			System.out.println("statusCode:" + resStr.getStatusCode());
			System.out.println("body:" + resStr.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
