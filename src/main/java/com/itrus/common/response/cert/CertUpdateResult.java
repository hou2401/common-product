package com.itrus.common.response.cert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertUpdateResult implements Serializable {
    private Long id;

    private String certBuf;

    private String certChain;

    private String certSn;

    private String subject;

    private String issuer;

    private String notAfter;

    private String notBefore;

    private String privateKeyAlg;

    private Integer status;

    private String sm3zValue;
}
