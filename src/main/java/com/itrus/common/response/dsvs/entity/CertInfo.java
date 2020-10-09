package com.itrus.common.response.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertInfo {
	/**
     * 证书序列号
     */
    private String certSN;
    /**
     * 证书版本
     */
    private Long version;
    /**
     * 证书使用者DN
     */
    private String subjectDN;
    /**
     * 证书颁发者DN
     */
    private String issuerDN;
    /**
     * 证书有效期起始日，格式：yyyy-MM-dd HH:mm:ss
     */
    private String notBefore;
    /**
     * 证书有效期截至日，格式：yyyy-MM-dd HH:mm:ss
     */
    private String notAfter;
    /**
     * 签名算法名称:SHA1withRSA、SHA256withRSA、SM3withSM2
     */
    private String sigAlgName;
}
