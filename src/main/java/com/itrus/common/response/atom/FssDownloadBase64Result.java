package com.itrus.common.response.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 * 文件下载
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FssDownloadBase64Result implements Serializable {
    private static final long serialVersionUID = 7364722461130134714L;
    /**
     * 文件名称
     */
    private String fileBytes;
    /**
     * 文件Base64编码
     */
    private String fileName;
}
