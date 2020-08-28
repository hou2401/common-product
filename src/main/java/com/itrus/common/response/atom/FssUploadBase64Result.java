package com.itrus.common.response.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 文件上传（base64）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FssUploadBase64Result implements Serializable {
    /**
     * 文件存储ID
     */
    private Long fssId;
    /**
     * 文件SHA1的hash值
     */
    private String hashValue;

}
