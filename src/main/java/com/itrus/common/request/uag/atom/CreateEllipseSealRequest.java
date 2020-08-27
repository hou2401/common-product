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
public class CreateEllipseSealRequest {
    private String companyName;

    private String horizontalText;

    private String bottomText;

    private Integer color;

    private Integer diameter;

    private Integer sealFontType;

    private Integer alpha;
}
