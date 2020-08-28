package com.itrus.common.request.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.http.entity.ByteArrayEntity;

import com.alibaba.fastjson.JSON;
import com.itrus.common.exception.ItrusException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.exception.SmsException;
import com.itrus.common.utils.HMACSHA1;
import com.itrus.common.utils.HttpTools.HttpData;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthBaseRequest implements Serializable{

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
	
	/**
	 * 计算天威云 httpData
	 * @return
	 * @throws ItrusException 
	 * @throws SmsException
	 */
	public HttpData getData( Map<String,String> params, String signature ) throws ItrusException{
		HttpData data = HttpData.instance()
				.addHeader(CONTENT_SIGNATURE, getSignature(signature))
				.addHeader(CONTEXT_TYPE, CONTEXT_TYPE_JSON)
				.addHeader(APP_ID, this.getAppId() )
				.addHeader(SERVICE_CODE, this.getServiceCode())
				.setPostEntity(new ByteArrayEntity(JSON.toJSONBytes( params )));
		return data;
	}
	
	/**
	 * 天威云签名
	 * @return
	 * @throws PersionAuthException
	 */
	public String getSignature(String signature) throws ItrusException{
		try {
			return AuthBaseRequest.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(signature, this.secretKey+this.serviceCode));
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new PersionAuthException("实名认证签名计算错误");
		}
	}
	
	
	public AuthBaseRequest(String appId, String serviceCode, String secretKey, String url) {
		super();
		this.appId = appId;
		this.serviceCode = serviceCode;
		this.secretKey = secretKey;
		this.url = url;
	}
	public AuthBaseRequest() {
		super();
	}
}
