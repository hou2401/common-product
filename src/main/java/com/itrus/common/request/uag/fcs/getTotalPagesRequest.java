package com.itrus.common.request.uag.fcs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class getTotalPagesRequest {
    private String fileName;
    private byte[] fileBytes;
    private String originalFilename;
}
