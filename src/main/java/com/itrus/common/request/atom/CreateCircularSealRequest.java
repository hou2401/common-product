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
public class CreateCircularSealRequest {
    private String companyName;

    private String horizontalText;

    private String bottomText;

    private Integer color;

    private Integer diameter;

    private Integer sealFontType;

    private Integer alpha;
}
