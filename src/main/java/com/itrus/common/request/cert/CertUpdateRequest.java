package com.itrus.common.request.cert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 更新证书
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertUpdateRequest {
    /**
     * 证书Id
     */
    private Long id;
    /**
     * 证书有效期延长天数，单位：天
     */
    private Integer validDays;
}
