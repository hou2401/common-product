package com.itrus.common.params;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ServiceParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * appid
	 */
	private String appId;
	
	/**
	 * 服务编码
	 */
	private String serviceCode;
	
	/**
	 * key
	 */
	private String secretKey;
	
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * HMAC-SHA1
	 */
	public static final  String HMAC_SHA1 = "HMAC-SHA1 ";
	
	
	/**
	 * 天威云短信授权
	 */
	public static final String CONTENT_SIGNATURE = "Content-Signature";
	public static final String CONTEXT_TYPE = "Content-type";
	public static final String CONTEXT_TYPE_JSON = "application/json";
	/**
	 * appId
	 */
	public static final String APP_ID = "appId";
	/**
	 * serviceCode
	 */
	public static final String SERVICE_CODE = "serviceCode";
	
	public ServiceParams(String appId, String serviceCode, String secretKey, String url) {
		super();
		this.appId = appId;
		this.serviceCode = serviceCode;
		this.secretKey = secretKey;
		this.url = url;
	}
	public ServiceParams() {
		super();
	}
}
