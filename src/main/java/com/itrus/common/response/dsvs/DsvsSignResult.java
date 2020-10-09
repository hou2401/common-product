package com.itrus.common.response.dsvs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * PDF批量签章
 * PDF签章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsSignResult implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * returnType=fss时，返回存储在文档存储服务器上的ID
     */
    private Long fssId;
    /**
     * returnType=base64时，返回文档base64编码
     */
    private String pdfBytes;
    /**
     * 文件SHA1的hash值
     */
    private String hashValue;
}
