package com.itrus.common.request.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SealLimpidRequest {
    private String sealBase64;

    private Integer color;

    private Integer diameter;
    private Integer alpha;
}
