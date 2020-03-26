package com.itrus.common.params;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ByteArrayEntity;

import com.alibaba.fastjson.JSON;
import com.itrus.common.exception.PersionException;
import com.itrus.common.exception.SmsException;
import com.itrus.common.http.HttpRequset;
import com.itrus.common.utils.HMACSHA1;
import com.itrus.common.utils.HttpTools.HttpData;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class AuthPersionVideoParams extends ServiceParams{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 身份证
	 */
	private String idnumber;

	/**
	 * 手机号
	 */
	private String videoFile;

	private String orderNo;


	/**
	 * 个人签名
	 * @param persion
	 * @return
	 */
	public String getPersonSign() {
		StringBuffer persionSign = new StringBuffer();
		persionSign = persionSign.append(this.getAppId())
		.append(this.getServiceCode())
		.append(name)
		.append(idnumber);
		
		if( StringUtils.trimToNull(orderNo) != null ) {
			persionSign = persionSign.append(orderNo);
		}
		if( StringUtils.trimToNull(videoFile) != null ) {
			persionSign = persionSign.append(videoFile);
		}
		return persionSign.toString();
	}


	/**
	 * 计算天威云 httpData
	 * @return
	 * @throws SmsException
	 */
	public HttpData getData() throws PersionException{
		HttpData data = HttpData.instance()
				.addHeader(HttpRequset.CONTENT_SIGNATURE, getSignature())
				.addHeader(HttpRequset.CONTEXT_TYPE, HttpRequset.CONTEXT_TYPE_JSON)
				.addHeader(HttpRequset.APP_ID, this.getAppId() )
				.addHeader(HttpRequset.SERVICE_CODE, this.getServiceCode())
				.setPostEntity(new ByteArrayEntity(JSON.toJSONBytes(getParams())));
		return data;
	}


	/**
	 * 天威云参数
	 * @return
	 */	
	private Map<String,String> getParams(){
		Map<String, String> authParam = new HashMap<>();
		authParam.put(HttpRequset.APP_ID, this.getAppId());
		authParam.put(HttpRequset.SERVICE_CODE, this.getServiceCode());
		authParam.put("name", this.name);
		authParam.put("idnumber", this.idnumber);
		authParam.put("orderNo", this.orderNo);
		authParam.put("videoFile", this.videoFile);
		return authParam;
	}


	/**
	 * 天威云签名
	 * @return
	 * @throws PersionException
	 */
	private String getSignature() throws PersionException{
		try {
			return ServiceParams.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(getPersonSign(), this.getSecretKey() + this.getServiceCode()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new PersionException("发送天威云短信计算签名异常");
		}
	}


	/**
	 *  熟读获取随机数字
	 * @param appId
	 * @param serviceCode
	 * @param secretKey
	 * @param name
	 * @param idnumber
	 * @param url
	 */
	public AuthPersionVideoParams(String appId, String serviceCode, String secretKey, String name, String idnumber, String url) {
		super(appId,serviceCode, secretKey, url);
		this.name = name;
		this.idnumber = idnumber;
	}
	
	/**
	 *     静默 or 读书实名认证验证接口
	 * @param appId
	 * @param serviceCode
	 * @param secretKey
	 * @param name
	 * @param idnumber
	 * @param videoFile
	 * @param orderNo
	 * @param url
	 */
	public AuthPersionVideoParams(String appId, String serviceCode, String secretKey, String name, String idnumber, String videoFile, String orderNo, String url) {
		super(appId,serviceCode, secretKey, url);
		this.name = name;
		this.idnumber = idnumber;
		this.videoFile = videoFile;
		this.orderNo = orderNo;
	}


	public AuthPersionVideoParams(String appId, String serviceCode, String secretKey, String url) {
		super(appId, serviceCode, secretKey, url);
	}


	public AuthPersionVideoParams() {
		super();
	}

}
