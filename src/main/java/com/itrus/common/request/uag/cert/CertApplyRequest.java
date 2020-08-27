package com.itrus.common.request.uag.cert;

import com.itrus.common.request.uag.cert.entity.ExtJson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertApplyRequest {
    private String o;

    private String ou;

    private String cn;

    private String raCode;

    private String validDays;

    private ExtJson extJson;
}
