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
public class generateThumbnailRequest {
    private String fileName;
    private byte[] fileBytes;
    private String originalFilename;
    private String pages;
    private Float scale;
    private Float dpi;
}
