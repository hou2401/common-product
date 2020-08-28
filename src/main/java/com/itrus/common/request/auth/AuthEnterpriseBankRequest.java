package com.itrus.common.request.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.itrus.common.exception.AuthException;
import com.itrus.common.utils.HMACSHA1;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Component
@Data
@Slf4j
public class AuthEnterpriseBankRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String appId;
	
	private String secretKey;
	
	private String serviceCode;
	
	/**
	 * 请求实名URL
	 */
	private String url;
	
	/**
	 * 开户行所在省份编码
	 */
	private String provinceCode;
	
	/**
	 * 开户行所在城市编码
	 */
	private String cityCode;
	
	/**
	 * 企业名称
	 */
	private String name;
	
	/**
	 * 银行账号
	 */
	private String bankAccount;
	
	/**
	 * 银行编码
	 */
	private String bankCode;
	
	/**
	 * 银行名称
	 */
	private String bankName;
	
	/**
	 * 开户支行网点名称
	 */
	private String branchBankName;
	
	//打款金额验证
	private String orderNumber;
	private Float paymentAmount;
	private String random;
	
	//支付描述
	private String description = "天威云打款认证";
	
	/**
	 * 查询银行列表，查询省/直辖市列表的构造方法
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url) {
		super();
		this.url = url;
	}
	
	/**
	 * 查询市/区列表的构造方法
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url,String provinceCode) {
		super();
		this.url = url;
		this.provinceCode = provinceCode;
	}
	
	/**
	 * 查询支行列表的构造方法
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url,String bankCode,String cityCode) {
		super();
		this.url = url;
		this.bankCode = bankCode;
		this.cityCode = cityCode;
	}
	
	/**
	 * 企业对公银行账户打款的构造方法
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url,String appId,String secretKey,String serviceCode,String name,String bankAccount,String bankName,
			String branchBankName,String provinceCode,String cityCode,String bankCode) {
		super();
		this.url = url;
		this.appId = appId;
		this.secretKey =secretKey;
		this.serviceCode = serviceCode;
		this.name = name;
		this.bankAccount = bankAccount;
		this.bankName = bankName;
		this.branchBankName = branchBankName;
		this.provinceCode = provinceCode;
		this.bankCode = bankCode;
		this.cityCode = cityCode;
	}
	
	/**
	 * 账户打款查询的构造方法  secretKey无需给值
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url,String orderNumber,String appId,String secretKey) {
		super();
		this.url = url;
		this.appId = appId;
		this.orderNumber = orderNumber;
	}
	
	/**
	 * 打款金额验证的构造方法
	 * @param url 请求全路径
	 */
	public AuthEnterpriseBankRequest(String url,String orderNumber,Float paymentAmount) {
		super();
		this.url = url;
		this.orderNumber = orderNumber;
		this.paymentAmount = paymentAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<String, String> getNullHeaders() {
		Map<String, String> headers = new HashMap<>(0);
		return headers;
	}
	
	/**
	 * @Description:市/区
	 * @return
	 */
	public Map<String, Object> getCityList() {
		Map<String, Object> params = new HashMap<>(1);
		params.put("provinceCode",this.provinceCode);
		return params;
	}
	
	/**
	 * @Description:支行
	 * @return
	 */
	public Map<String, Object> getBranchBankList() {
		Map<String, Object> params = new HashMap<>(2);
		params.put("bankCode",this.bankCode);
		params.put("cityCode",this.cityCode);
		return params;
	}
	
	/**
	 * 企业对公银行账户打款入参
	 * @return
	 */
	public Map<String, Object> getPayBankParams() {
		Map<String, Object> params = new HashMap<>(10);
		params.put("appId", this.appId);
		params.put("serviceCode", this.serviceCode);
		params.put("name", this.name);
		params.put("bankAccount", this.bankAccount);
		params.put("bankName", this.bankName);
		params.put("branchBankName", this.branchBankName);
		params.put("provinceCode",this.provinceCode);
		params.put("cityCode",this.cityCode);
		params.put("bankCode",this.bankCode);
		params.put("description",this.description);
		return params;
	}
	
	/**
	 * @Description:打款查询入参
 	 * @return
	 */
	public Map<String, Object> getQueryAmount() {
		Map<String, Object> params = new HashMap<>(2);
		params.put("appId",this.appId);
		params.put("orderNumber",this.orderNumber);
		return params;
	}
	
	/**
	 * @Description:打款金额验证入参
	 * @return
	 */
	public Map<String, Object> getVerifyAmount() {
		Map<String, Object> params = new HashMap<>(4);
		params.put("appId",this.appId);
		params.put("orderNumber",this.orderNumber);
		params.put("paymentAmount",this.paymentAmount);
//		params.put("random",this.random);
		return params;
	}
	
	public Map<String, String> getHeater() throws AuthException{
		Map<String,String> headers=new HashMap<>(1);
		try {
			headers.put("Content-Signature", "HMAC-SHA1 " + Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(this.getVerificationSign(), secretKey)));
			log.info("银行打款实名认证Content-Signature："+headers.get("Content-Signature"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("银行打款实名认证：签名计算异常",e);
			throw new AuthException("银行打款实名认证：签名计算异常");
		}
		return headers;
	}
	
	//银行打款
	//必须按照以下顺序依次获取map键所对应的值
	private String getVerificationSign() {
		StringBuffer verificationSign = new StringBuffer();
		verificationSign.append(this.appId)
		.append(this.serviceCode)
		.append(this.name)
		.append(this.bankAccount)
		.append(this.bankCode)
		.append(this.bankName)
		.append(this.branchBankName)
		.append(this.provinceCode)
		.append(this.cityCode);
		log.debug("verificationSign===", verificationSign.toString());
		return verificationSign.toString();
	}
	
	public AuthEnterpriseBankRequest() {
		super();
	}

}
