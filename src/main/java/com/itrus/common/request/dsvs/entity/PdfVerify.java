package com.itrus.common.request.dsvs.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: meng
 * @Description: pdf验证
 * @Date: Create in 16:41 2020/8/25 0025
 */
@Data
@ToString
public class PdfVerify {
    /**
     * 已签名PDF文档Base64  必选
     */
    private String pdfBytes;
    /**
     * 是否验证批注，验证签章后是否添加批注：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkAnnot;
    /**
     * 是否验证吊销列表：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkCrl;
    /**
     * 是否验证书颁发者：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkIssuer;
}
