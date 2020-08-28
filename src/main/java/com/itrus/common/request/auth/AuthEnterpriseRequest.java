package com.itrus.common.request.auth;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.itrus.common.exception.EnterpriseAuthException;
import com.itrus.common.exception.PersionAuthException;
import com.itrus.common.utils.HMACSHA1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=true)
public class AuthEnterpriseRequest extends AuthBaseRequest{

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
	 * ET_PE 企业
	 * 
	 * ET_SE 个体工商户
	 * 
	 * OU 企事业单位，当为OU时候，org_code不允许为null
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
	public Map<String,Object> getParams(){
		Map<String, Object> authParam = new HashMap<>();
		authParam.put(AuthBaseRequest.APP_ID, this.getAppId());
		authParam.put(AuthBaseRequest.SERVICE_CODE, this.getServiceCode());
		authParam.put("name", this.name);
		authParam.put("type", this.type);
		if( StringUtils.trimToNull(this.idCode) != null ) {
			authParam.put("idCode", this.idCode);
		}
		if( StringUtils.trimToNull(this.orgCode) != null ) {
			authParam.put("orgCode", this.orgCode);
		}
		if( StringUtils.trimToNull(this.legalName) != null ) {
			authParam.put("legalName", this.legalName);
		}
		if( StringUtils.trimToNull(this.legalId) != null ) {
			authParam.put("legalId", this.legalId);
		}
		if( StringUtils.trimToNull(this.legalUrl) != null ) {
			authParam.put("legalUrl", this.legalUrl);
		}
		if( StringUtils.trimToNull(this.legalImg) != null ) {
			authParam.put("legalImg", this.legalImg);
		}	
		if( StringUtils.trimToNull(this.agentName) != null ) {
			authParam.put("agentName", this.agentName);
		}	
		if( StringUtils.trimToNull(this.agentId) != null ) {
			authParam.put("agentId", this.agentId);
		}	
		if( StringUtils.trimToNull(this.agentUrl) != null ) {
			authParam.put("agentUrl", this.agentUrl);
		}	
		if( StringUtils.trimToNull(this.agentImg) != null ) {
			authParam.put("agentImg", this.agentImg);
		}

		return authParam;
	}


	/**
	 * 天威云签名
	 * @return
	 * @throws PersionAuthException
	 */
	@Override
	public String getSignature(String signature) throws EnterpriseAuthException{
		try {
			return AuthBaseRequest.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(getEnterpriseSign(), this.getSecretKey()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new EnterpriseAuthException("发送天威云短信计算签名异常");
		}
	}

	/**
	 * header
	 * @return
	 * @throws PersionAuthException
	 * @throws EnterpriseAuthException 
	 */
	public Map<String,String> getHeader() throws EnterpriseAuthException {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put(AuthBaseRequest.CONTENT_SIGNATURE, getSignature(getEnterpriseSign()));
		return hashMap;
	}

	/**
	 * 企业法人代理人实名认证
	 * @param appId
	 * @param serviceCode
	 * @param secretKey
	 * @param url
	 * @param name
	 * @param type
	 * @param idCode
	 * @param orgCode
	 * @param legalName
	 * @param legalId
	 * @param legalUrl
	 * @param legalImg
	 * @param agentName
	 * @param agentId
	 * @param agentUrl
	 * @param agentImg
	 */
	public AuthEnterpriseRequest(String appId, String serviceCode, String secretKey, String url, String name,
			String type, String idCode, String orgCode, String legalName, String legalId, String legalUrl,
			String legalImg, String agentName, String agentId, String agentUrl, String agentImg) {
		super(appId, serviceCode, secretKey, url);
		this.name = name;
		this.type = type;
		this.idCode = idCode;
		this.orgCode = orgCode;
		this.legalName = legalName;
		this.legalId = legalId;
		this.legalUrl = legalUrl;
		this.legalImg = legalImg;
		this.agentName = agentName;
		this.agentId = agentId;
		this.agentUrl = agentUrl;
		this.agentImg = agentImg;
	}

	public AuthEnterpriseRequest() {
		super();
	}

	/**
	 * 企业实名认证，不含法人，代理人
	 * @param appId
	 * @param serviceCode
	 * @param secretKey
	 * @param url
	 * @param name
	 * @param type
	 * @param idCode
	 * @param orgCode
	 */
	public AuthEnterpriseRequest(String appId, String serviceCode, String secretKey, String url, String name,
			String type, String idCode, String orgCode) {
		super(appId, serviceCode, secretKey, url);
		this.name = name;
		this.type = type;
		this.idCode = idCode;
		this.orgCode = orgCode;
	}

	/**
	 * 企业和法人实名认证
	 * @param appId
	 * @param serviceCode
	 * @param secretKey
	 * @param url
	 * @param name
	 * @param type
	 * @param idCode
	 * @param orgCode
	 * @param legalName
	 * @param legalId
	 * @param legalUrl
	 * @param legalImg
	 */
	public AuthEnterpriseRequest(String appId, String serviceCode, String secretKey, String url, String name,
			String type, String idCode, String orgCode, String legalName, String legalId, String legalUrl,
			String legalImg) {
		super(appId, serviceCode, secretKey, url);
		this.name = name;
		this.type = type;
		this.idCode = idCode;
		this.orgCode = orgCode;
		this.legalName = legalName;
		this.legalId = legalId;
		this.legalUrl = legalUrl;
		this.legalImg = legalImg;
	}

}
