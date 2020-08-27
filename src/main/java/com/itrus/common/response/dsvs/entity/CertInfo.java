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
    private String certSN;
    private Long version;
    private String subjectDN;
    private String issuerDN;
    private String notBefore;
    private String notAfter;
    private String sigAlgName;
}
