package com.itrus.common.response.dsvs;

import com.itrus.common.response.dsvs.entity.CertInfo;
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
public class DsvsVerifyBase64Result implements Serializable {

    private CertInfo signCert;
    private String signTime;
    private String timestamp;
    private String hashAlg;
    private Long vcResult;
    private Long vdsResult;
    private Long vtsResult;
    private Boolean isSecondSign;


}
