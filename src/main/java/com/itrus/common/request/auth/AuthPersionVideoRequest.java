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
public class AuthPersionVideoRequest extends AuthBaseRequest{

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
	 * 是否视频压缩
	 */
	private boolean javed;


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
	 * 天威云参数
	 * @return
	 */	
	public Map<String,Object> getParams(){
		Map<String, Object> authParam = new HashMap<>();
		authParam.put(AuthBaseRequest.APP_ID, this.getAppId());
		authParam.put(AuthBaseRequest.SERVICE_CODE, this.getServiceCode());
		authParam.put("name", this.name);
		authParam.put("idnumber", this.idnumber);
		if( StringUtils.trimToNull(this.orderNo) != null ) {
			authParam.put("orderNo", this.orderNo);
		}
		if( StringUtils.trimToNull(this.videoFile) != null ) {
			authParam.put("videoFile", this.videoFile);
		}
		return authParam;
	}


	/**
	 * 天威云签名
	 * @return
	 * @throws PersionAuthException
	 */
	@Override
	public String getSignature( String signature) throws PersionAuthException{
		try {
			System.out.println( signature );
			signature = AuthBaseRequest.HMAC_SHA1 + java.util.Base64.getEncoder().encodeToString(HMACSHA1.getHmacSHA1(signature, this.getSecretKey()));
			System.out.println( signature );
			return signature;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new PersionAuthException("发送天威云短信计算签名异常");
		}
	}
	
	public Map<String,String> getHeader() throws PersionAuthException{
		Map<String,String > header = new HashMap<>();
		header.put(AuthBaseRequest.CONTENT_SIGNATURE, getSignature(getPersonSign()));
		return header;
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
	public AuthPersionVideoRequest(String appId, String serviceCode, String secretKey, String url, String name, String idnumber) {
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
	public AuthPersionVideoRequest(String appId, String serviceCode, String secretKey, String url, String name, String idnumber, String orderNo, String videoFile) {
		super(appId,serviceCode, secretKey, url);
		this.name = name;
		this.idnumber = idnumber;
		this.videoFile = videoFile;
		this.orderNo = orderNo;
	}


	public AuthPersionVideoRequest() {
		super();
	}

}
