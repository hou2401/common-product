package com.itrus.common.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
	
	private static OkHttpClient client=new OkHttpClient().newBuilder()
			.connectTimeout(3, TimeUnit.SECONDS)
			.readTimeout(3, TimeUnit.SECONDS)
			.writeTimeout(3, TimeUnit.SECONDS)
			.build();
	
	public static void setClient(OkHttpClient client) {
		HttpUtil.client = client;
	}
	private static void addHeaders(Request.Builder builder,Map<String,String> headers) {
		if(builder!=null && headers!=null && headers.size()>0) {
			for(String key:headers.keySet()) {
				builder.addHeader(key, headers.get(key));
			}
		}
	}
	private static String mapToQueryStr(Map<String,Object> params) {
		StringBuilder sb=new StringBuilder();
		if(params != null && params.size()>0) {
			for(String key: params.keySet()){
				Object value=params.get(key);
				sb.append("&").append(key).append("=").append(value!=null?String.valueOf(value):"");
			}
		}
		return sb.toString();
	}
	private static String appendUrl(String url,String params) {
		if(url != null && url.length()>0 && params != null && params.length()>0) {
			if(!url.contains("?")) {
				url=url+"?"+params.substring(1);
			}else {
				url=url+params;
			}
		}
		return url;
	}
	private static FormBody.Builder mapToFormBody(Map<String,Object> params){
		FormBody.Builder formBody = new FormBody.Builder();
		if(params != null && params.size()>0) {
			for(String key: params.keySet()){
				Object value=params.get(key);
				formBody.add(key,value!=null?String.valueOf(value):"");
			}
		}
		return formBody;
	}
	public static String doGet(String url,Map<String,Object> params,Map<String,String> headers) throws Exception{
		String result=null;
		if(url != null && url.length()>0) {
			url=appendUrl(url,mapToQueryStr(params));
			Request.Builder builder = new Request.Builder().url(url);
			addHeaders(builder,headers);
			Request request = builder.build();
			try(Response response = client.newCall(request).execute()){
				if(response.isSuccessful()) {
					result = response.body().string();
				}
		    }catch(IOException e) {
		    	throw e;
		    }
		}
		return result;
	}
	public static String doGet(String url,Map<String,Object> params) throws Exception{
		return doGet(url,params,null);
	}
	public static String doGet(String url) throws Exception{
		return doGet(url,null);
	}
	private static String doPost(boolean useJson,String url,Map<String,String> headers,Map<String,Object> params,String json) throws Exception{
		String result=null;
		if(url != null && url.length()>0) {
			Request.Builder builder =new Request.Builder().url(url);
			addHeaders(builder,headers);
			RequestBody body = null;
			if(!useJson) {
				body = mapToFormBody(params).build();
			}else {
				body = RequestBody.create(MediaType.parse("application/json"), json!=null&&json.length()>0?json:"{}");
			}
			
			builder.post(body);
			Request request = builder.build();
			try(Response response = client.newCall(request).execute()){
//				if(response.isSuccessful()) {
					result = response.body().string();
//				}
		    }catch(IOException e) {
		    	throw e;
		    }
		}
		return result;
	}
	public static String doPost(String url,Map<String,Object> params,Map<String,String> headers) throws Exception{
		return doPost(false,url,headers,params,null);
	}
	public static String doPost(String url,Map<String,Object> params) throws Exception{
		return doPost(url,params,null);
	}
	public static String doPost(String url) throws Exception{
		return doPost(url,null);
	}
	public static String doPostJson(String url,String json,Map<String,String> headers) throws Exception{
		return doPost(true,url,headers,null,json);
	}
	public static String doPostJson(String url,String json) throws Exception{
		return doPostJson(url,json,null);
	}
	public static String doPostJson(String url) throws Exception{
		return doPostJson(url,null);
	}
	/*public static void main(String[] args) throws Exception{
		String url="http://tieba.baidu.com/f";
		Map<String,Object> params=new HashMap<>();
		params.put("fr", "wwwt");
		params.put("kw", "测试");
		Map<String,String> headers=new HashMap<>();
		headers.put("header111", "header111");
		System.out.println(HttpUtil.doPost(url,params,headers));
	}*/
}
