package com.itrus.common.response.cert;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApplyCertResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 证书ID
	 */
	private Long id;
	
	/**
	 * 证书序列号
	 */
	private String certSn;
	/**
	 * 证书Base64编码
	 */
	private String certBuf;
	
	/**
	 * 证书链
	 */
	private String certChain;
	
	/**
	 * 证书签发者
	 */
	private String  issuer;
	
	/**
	 * 证书主题
	 */
	private String subject;
	
	/**
	 * 证书生效时间，日期格式：yyyy-MM-dd HH:mm:ss
	 */
	private String notBefore;

	/**
	 * 证书过期时间，日期格式：yyyy-MM-dd HH:mm:ss
	 */
	private String notAfter;
	
	/**
	 * 密钥算法
	 */
	private String privateKeyAlg;
	
	/**
	 * 证书状态 1:有效，2:吊销，3：已过期
	 */
	private Integer status ;
	
	/**
	 * SM3哈希算法参数Z值，SM2证书时返回
	 */
	private String sm3zValue;
}
