package com.itrus.common.params.sign;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName Signers
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 17:06 2020/4/21
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
public class Signers {
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
     * 签名策略： <br/>1：只有第一个印章图片添加数字签名，<br />      其它印章添加水印（首次签章默认）<br/>2：所有印章图片都添加签名（非首次签章默认） <br/>3：所有印章图片都不添加数字签名，无
     */
    private String signaturePolicy;
    /**
     *多页签签章列表，三个签章列表中至少有一项
     */
    private List<PagesSignItem> pagesSignatures;
    /**
     * 关键字签签章列表，三个签章列表中至少有一项
     */
    private List<KeywordSignItem > keywordSignatures;
    /**
     * 骑缝签签章列表，三个签章列表中至少有一项
     */
    private List<CrossSignItem> crossSignatures;


}
