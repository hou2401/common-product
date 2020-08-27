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
public class FssUploadRequest {
    String fileName;
    String bizType;
    byte[] fileBytes;
    String originalFilename;
    Integer encryptionType;
}
