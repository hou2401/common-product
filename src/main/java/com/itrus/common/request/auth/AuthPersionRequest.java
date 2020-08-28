package com.itrus.common.request.auth;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.utils.HMACSHA1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class AuthPersionRequest extends AuthBaseRequest{

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
	private String idCard;

	/**
	 * 手机号
	 */
	private String mobile;

	private String selfUrl;

	private String selfImg;

	private String bankcard;
	
	
	

	/**
	 * 个人签名
	 * @param persion
	 * @return
	 */
	public String getPersonSign() {
		StringBuffer persionSign = new StringBuffer();
		persionSign.append(this.getAppId())
		.append(this.getServiceCode())
		.append(name)
		.append(idCard)
		.append(selfUrl)
		.append(selfImg)
		.append(bankcard)
		.append(mobile);
		return persionSign.toString();
	}

	/**
	 * 天威云参数
	 * @return
	 */
	public Map<String,Object> getParams(){
		Map<String, Object> authParam = new HashMap<>();
		authParam.put(AuthBaseRequest.APP_ID, this.getAppId());
		authParam.put(AuthBaseRequest.SERVICE_CODE, this.getServiceCode());
		authParam.put("name", this.name);
		authParam.put("idCard", this.idCard);
		if( StringUtils.trimToNull(this.mobile) != null ) {
			authParam.put("mobile", this.mobile);
		}
		if(  StringUtils.trimToNull(this.selfUrl) != null  ) {
			authParam.put("selfUrl", this.selfUrl);
		}
		if(  StringUtils.trimToNull(this.selfImg) != null  ) {
			authParam.put("selfImg", this.selfImg);
		}
		if(  StringUtils.trimToNull(this.bankcard) != null  ) {
			authParam.put("bankcard", this.bankcard);
		}
		return authParam;
	}

	public AuthPersionRequest(String appId, String serviceCode, String secretKey, String url, String name, String idCard,
			String mobile, String bankcard, String selfUrl, String selfImg) {
		super(appId, serviceCode, secretKey, url);
		this.name = name;
		this.idCard = idCard;
		this.mobile = mobile;
		this.bankcard = bankcard;
		this.selfUrl = selfUrl;
		this.selfImg = selfImg;
	}

	public AuthPersionRequest(String appId, String serviceCode, String secretKey, String url) {
		super(appId, serviceCode, secretKey, url);
	}

	public AuthPersionRequest() {
		super();
	}
	
	@Override
	public String getSignature(String signature ) throws PersionAuthException {
		try {
			System.out.println(signature);
			signature = AuthBaseRequest.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(signature, this.getSecretKey()));
			System.out.println(signature);
			return signature;
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new PersionAuthException("实名认证签名计算错误");
		}
	}

	/**
	 * header
	 * @return
	 * @throws PersionAuthException
	 */
	public Map<String,String> getHeader() throws PersionAuthException {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put(AuthBaseRequest.CONTENT_SIGNATURE, getSignature(getPersonSign()));
		return hashMap;
	}

}
