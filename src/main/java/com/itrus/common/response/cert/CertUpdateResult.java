package com.itrus.common.response.cert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 更新证书
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertUpdateResult implements Serializable {
    private static final long serialVersionUID = 3800105503305458201L;
    /**
     * 证书ID
     */
    private Long id;
    /**
     * 证书Base64编码
     */
    private String certBuf;
    /**
     * 证书链Base64编码
     */
    private String certChain;
    /**
     * 证书序列号
     */
    private String certSn;
    /**
     * 证书使用者
     */
    private String subject;
    /**
     * 证书签发者
     */
    private String issuer;
    /**
     * 证书过期时间，日期格式：yyyy-MM-dd HH:mm:ss
     */
    private String notAfter;
    /**
     * 证书生效时间，日期格式：yyyy-MM-dd HH:mm:ss
     */
    private String notBefore;
    /**
     * 密钥算法
     */
    private String privateKeyAlg;
    /**
     * 证书状态 1:有效，2:吊销，3：已过期
     */
    private Integer status;
    /**
     * SM3哈希算法（当密钥算法为SM2时才返回此参数）
     */
    private String sm3zValue;
}
