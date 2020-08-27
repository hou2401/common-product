package com.itrus.common.request.fcs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pdf2pngRequest {
    private byte[] data;
    private Float scale;
}
