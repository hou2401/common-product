package com.itrus.common.params;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.ByteArrayEntity;

import com.alibaba.fastjson.JSON;
import com.itrus.common.exception.PersionAuthException;
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
public class AuthPersionParams extends ServiceParams{

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
	public Map<String,String> getParams(){
		Map<String, String> authParam = new HashMap<>();
		authParam.put(HttpRequset.APP_ID, this.getAppId());
		authParam.put(HttpRequset.SERVICE_CODE, this.getServiceCode());
		authParam.put("name", this.name);
		authParam.put("idCard", this.idCard);
		authParam.put("mobile", this.mobile);
		authParam.put("selfUrl", this.selfUrl);
		authParam.put("selfImg", this.selfImg);
		authParam.put("bankcard", this.bankcard);
		return authParam;
	}


	/**
	 * 天威云签名
	 * @return
	 * @throws PersionAuthException
	 */
	public String getSignature() throws PersionAuthException{
		try {
			return ServiceParams.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(getPersonSign(), this.getSecretKey() + this.getServiceCode()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new PersionAuthException("发送天威云短信计算签名异常");
		}
	}

}
