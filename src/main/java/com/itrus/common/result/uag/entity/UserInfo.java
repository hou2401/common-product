package com.itrus.common.result.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 批量创建外部联系人-个人 属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     * 必选 姓名
     */
    private String displayName;
    /**
     * 必选 手机号码
     */
    private String phone;
    /**
     * 可选 企业邮箱
     */
    private String email;
    /**
     * 可选 证件类型 详见1.3.1
     * 1 String 居民身份证 （默认）
     * 2 String 护照
     * 3 String 港澳居民来往内地通行证
     * 4 String 台湾居民往来大陆通行证
     * 5 String 香港永久性居民身份证
     * 6 String 外籍身份证
     */
    private String idCardType;
    /**
     * 可选 证件号码，若存在，证件类型需存在
     */
    private String idCardNum;
    /**
     * 可选 实名类型 详见1.3.10
     * 0 String 证件认证
     * 1 String 手机号认证
     * 2 String 人脸认证
     * 3 String 银行卡认证
     */
    private String authType;
    /**
     * 可选 实名结果 详见1.3.11
     * 0 String 未实名（默认）
     * 1 String 已实名
     * 2 String 实名中
     */
    private String authResult;
    /**
     * 可选 来源类型 详见1.3.5（SaaS或者API）0 SaaS（默认） 1 Api
     */
    private String sourceType;
    /**
     * 可选 来源编码 来源是API时，需要传入企业应用AppID
     */
    private String sourceCode;
}
