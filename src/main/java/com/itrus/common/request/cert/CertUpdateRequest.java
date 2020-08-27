package com.itrus.common.request.cert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertUpdateRequest {
    private Long id;

    private Integer validDays;
}
