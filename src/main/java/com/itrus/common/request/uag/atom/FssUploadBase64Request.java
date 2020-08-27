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
public class FssUploadBase64Request {
    private String fileBytes;
    private String fileName;
    private String bizType;
    private Integer encryptionType;
}
