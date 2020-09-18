package com.itrus.common.request.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    private Boolean timestamp;

    /**
     * 时间戳代码，用于选择使用哪个时间戳服务<br/>不填时使用默认的时间戳服务
     */
    private String tsaCode;
    /**
     * 签名策略： <br/>1：只有第一个印章图片添加数字签名，<br />      其它印章添加水印（首次签章默认）<br/>2：所有印章图片都添加签名（非首次签章默认） <br/>3：所有印章图片都不添加数字签名，无
     */
    private Long signaturePolicy;
    /**
     *多页签签章列表，三个签章列表中至少有一项
     */
    private List<PagesSignItem> pagesSignatures;
    /**
     * 关键字签签章列表，三个签章列表中至少有一项
     */
    private List<KeywordSignatures > keywordSignatures;
    /**
     * 骑缝签签章列表，三个签章列表中至少有一项
     */
    private List<CrossSignatures> crossSignatures;
}
