package com.itrus.common.params.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 18:42 2020/8/25 0025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignCert implements Serializable {
    private static final long serialVersionUID = 1L;
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
