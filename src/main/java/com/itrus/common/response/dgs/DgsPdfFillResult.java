package com.itrus.common.response.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * PDF模板填充
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfFillResult implements Serializable {
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
