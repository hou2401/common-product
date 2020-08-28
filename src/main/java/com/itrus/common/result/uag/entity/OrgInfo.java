package com.itrus.common.result.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 企业信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgInfo {
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
     * 必选 企业名称
     */
    private String orgName;
    /**
     * 必选 是否三证合一 详见1.3.2
     * 0 String 否 1 String 是（默认）
     */
    private String inOneType;
    /**
     * 可选 统一社会信用代码
     */
    private String socialCode;
    /**
     * 可选 组织机构代码
     */
    private String unitCode;
    /**
     * 可选 来源类型 详见1.3.5 0 SaaS（默认） 1 Api
     */
    private String sourceType;
    /**
     * 可选 来源编码 来源是API时，需要传入企业应用AppID
     */
    private String sourceCode;
    /**
     * 可选 个人实名类型 详见1.3.10
     * 0 String 证件认证
     * 1 String 手机号认证
     * 2 String 人脸认证
     * 3 String 银行卡认证
     */
    private String authType;
    /**
     * 可选 个人实名结果 详见1.3.11
     * 0 String 未实名（默认）
     * 1 String 已实名
     * 2 String 实名中
     */
    private String authResult;
    /**
     * 可选 企业实名类型 详见1.3.10
     * 0 String 证件认证
     * 1 String 手机号认证
     * 2 String 人脸认证
     * 3 String 银行卡认证
     */
    private String companyAuthType;
    /**
     * 可选 企业实名结果 详见1.3.11
     * 0 String 未实名（默认）
     * 1 String 已实名
     * 2 String 实名中
     */
    private String companyAuthResult;
}
