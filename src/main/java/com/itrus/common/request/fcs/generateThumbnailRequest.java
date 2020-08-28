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
    /**
     * 页码范围，格式形如：1~5,8,-3~-1<br/>0：所有页（默认）<br/>1~5：第1页至第5页<br/>-3~-1：倒数第3页至倒数第1页
     */
    private String pages;
    /**
     * 缩放比例，取值范围0.0~1.0之间，1.0为100%，值越小缩略图尺寸越小<br/>默认值：1.0
     */
    private Float scale;
    /**
     * 图片分辨率，取值越大生成的图片清晰度越高图片尺寸也越大<br/>默认值：96
     */
    private Float dpi;
}
