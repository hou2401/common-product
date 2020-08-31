package com.itrus.common.request.dsvs;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * PDF验章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsVerifyBase64Request implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 已签名PDF文档Base64
     */
    private String pdfBytes;
    /**
     * 是否验证批注，验证签章后是否添加批注：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkAnnot;
    /**
     * 是否验证吊销列表：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkCRL;
    /**
     * 是否验证书颁发者：<br />true：验证<br />false：不验证（默认）
     */
    private Boolean checkIssuer;

}
