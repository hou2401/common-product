package com.itrus.common.request.dsvs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.request.dsvs.entity.CrossSignatures;
import com.itrus.common.request.dsvs.entity.KeywordSignatures;
import com.itrus.common.request.dsvs.entity.PagesSignatures;

/**
 * @author yuying
 * PDF签章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsSignRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 文档资源地址,pdfBytes和pdfURI至少要有一项，
     * 同时存在时，pdfBytes优先。
     * base64类型的URI在后续版本中会删除，base64请用参数pdfBytes
     * http:http\|https资源：http://www.itrus.com.cn/contract/10001.pdf
     * fss:文件存储服务上的ID：fss://612764508776960191
     */
    private String pdfURI;
    /**
     * PDF文档的Base64字符串或byte[]
     */
    private String pdfBytes;
    /**
     * 证书Id
     */
    private Long certId;
    /**
     * SM2证书签名时必选
     */
    private String sm3zValue;
    /**
     * 双证书签章时必选
     */
    private Long secondCertId;
    /**
     * 双证书签章时，SM2证书签名时必选
     */
    private String secondSm3zValue;
    /**
     * 是否加盖时间戳，默认false不加盖
     */
    private Boolean timeStamp;
    /**
     * 签名策略： 1：只有第一个印章图片添加数字签名,其它印章添加水印（首次签章默认）
     *           2：所有印章图片都添加签名（非首次签章默认）
     *           3：所有印章图片都不添加数字签名，无
     */
    private Long signaturePolicy;
    /**
     *返回类型：base64 ：返回文档base64编码（默认）
     *         fss : 返回文档存储后的ID
     */
    private String returnType;
    /**
     *坐标类型：1：左下角为原点，单位为像素（默认）2：左上角为原点，数值为百分比
     */
    private Long coordinateAxisType;


    /**
     * 多页签签章列表，三个签章列表中至少有一项
     */
    private List<PagesSignatures> pagesSignatures;
    /**
     * 关键字签签章列表，三个签章列表中至少有一项
     */
    private List<KeywordSignatures> keywordSignatures;
    /**
     * 骑缝签签章列表，三个签章列表中至少有一项
     */
    private List<CrossSignatures> crossSignatures;

}
