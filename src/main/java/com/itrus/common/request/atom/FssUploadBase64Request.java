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
public class FssUploadBase64Request {
    /**
     * 文件的Base64编码
     */
    private String fileBytes;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 业务类型，字符串格式[0-9a-zA-Z_-]*，<br />最大长度为20个字符<br />推荐：seal、src_contract、signed_contract...
     */
    private String bizType;
    /**
     * 加密类型：<br />默认值从配置文件读取，fss.encryptionType，如果未配置，默认值为1<br />1. 不加密<br />2. AES加密
     */
    private Integer encryptionType;
}
