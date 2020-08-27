package com.itrus.common.request.uag.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTriangleSealRequest {
    private String companyName;

    private String horizontalText;

    private Integer color;

    private Integer sealFontType;

    private Integer alpha;
}
