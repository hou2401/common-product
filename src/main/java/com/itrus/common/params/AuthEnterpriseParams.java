package com.itrus.common.params;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.ByteArrayEntity;

import com.alibaba.fastjson.JSON;
import com.itrus.common.exception.EnterpriseAuthException;
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
public class AuthEnterpriseParams extends ServiceParams{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 企业性质
	 * 
	 * ET_PE
	 * 
	 * 
	 */
	private String type;
	/**
	 * 统一信用代码
	 * 或注册号
	 */
	private String idCode;
	
	/**
	 * 组织机构代码
	 */
	private String orgCode;
	
	/**
	 * 法人姓名
	 */
	private String legalName;

	/**
	 * 法人身份证号
	 */
	private String legalId;
	
	/**
	 * 法人人像网络地址
	 */
	private String legalUrl;
	
	/**
	 * 法人人人像base64编码
	 */
	private String legalImg;
	
	/**
	 * 代理人姓名
	 */
	private String agentName;
	
	/**
	 * 代理人身份证号
	 */
	private String agentId;
	
	/**
	 * 代理人人像网络地址
	 */
	private String agentUrl;
	
	/**
	 * 代理人人像base64编码
	 */
	private String agentImg;
	
	
	
	/**
	 * 企业签名
	 * @return
	 */
	public String getEnterpriseSign() {
		StringBuffer enterpriseSign = new StringBuffer();
		enterpriseSign.append(this.getAppId())
		.append(this.getServiceCode())
		.append(type)
		.append(name)
		.append(idCode)
		.append(orgCode)
		.append(legalName)
		.append(legalId)
		.append(legalUrl)
		.append(legalImg)
		.append(agentName)
		.append(agentId)
		.append(agentUrl)
		.append(agentImg);
		return enterpriseSign.toString();
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
		authParam.put("type", this.type);
		authParam.put("idCode", this.idCode);
		authParam.put("orgCode", this.orgCode);
		authParam.put("legalName", this.legalName);
		authParam.put("legalId", this.legalId);
		authParam.put("legalUrl", this.legalUrl);
		authParam.put("legalImg", this.legalImg);
		authParam.put("agentName", this.agentName);
		authParam.put("agentId", this.agentId);
		authParam.put("agentUrl", this.agentUrl);
		authParam.put("agentImg", this.agentImg);
		
		return authParam;
	}


	/**
	 * 天威云签名
	 * @return
	 * @throws PersionAuthException
	 */
	private String getSignature() throws EnterpriseAuthException{
		try {
			return ServiceParams.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(getEnterpriseSign(), this.getSecretKey()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new EnterpriseAuthException("发送天威云短信计算签名异常");
		}
	}

}
