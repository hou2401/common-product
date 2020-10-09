package com.itrus.common.response.dsvs;

import com.itrus.common.response.dsvs.entity.CertInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * PDF验章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsVerifyBase64Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 签名证书信息
     */
    private CertInfo SignCert;
    /**
     * 签名时间，格式：yyyy-MM-dd HH:mm:ss<br/>如果有时间戳，签名时间以时间戳时间为准
     */
    private String signTime;
    /**
     * 时间戳，格式：yyyy-MM-dd HH:mm:ss
     */
    private String timestamp;
    /**
     * 摘要Hash算法
     */
    private String hashAlg;
    /**
     * 证书验证结果： VcResultEnum
     */
    private Long vcResult;
    /**
     *数字签名验证结果 VdsResultEunm
     */
    private Long vdsResult;
    /**
     *时间戳验证结果 VtsResultEnum
     */
    private Long vtsResult;
    /**
     *双证书签章时，是否为第二个证书的签名
     */
    private Boolean isSecondSign;


}
