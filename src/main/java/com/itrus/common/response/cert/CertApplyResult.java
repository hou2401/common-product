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
public class CertApplyResult implements Serializable {
    private Long id;

    private String certSn;

    private String certBuf;

    private String certChain;

    private String issuer;

    private String subject;

    private String notAfter;

    private String notBefore;

    private String privateKeyAlg;

    private Long status;

    private String sm3zValue;
}
