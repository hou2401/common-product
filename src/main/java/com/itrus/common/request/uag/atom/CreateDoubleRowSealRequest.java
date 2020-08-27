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
public class CreateDoubleRowSealRequest {
    private String name;

    private Integer color;

    private Integer diameter;

    private Integer sealFontType;

    private Integer alpha;
}
