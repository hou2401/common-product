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
public class getTotalPagesRequest {
    /**
     * 文件名字
     */
    private String fileName;
    /**
     * 文件字节
     */
    private byte[] fileBytes;
    /**
     * 原始文件名
     */
    private String originalFilename;
}
