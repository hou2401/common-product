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
public class CreateSingleRowSealRequest {
    private String name;

    private Integer color;

    private Integer sealFontType;

    private Integer alpha;

    private Integer frame;

}
