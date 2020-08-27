package com.itrus.common.result.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgInfo {
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 企业邮箱
     */
    private String email;
    /**
     * 企业名称
     */
    private String orgName;
    /**
     * 是否三证合一
     */
    private String inOneType;
    /**
     * 统一社会信用代码
     */
    private String socialCode;
    /**
     * 组织机构代码
     */
    private String unitCode;
    /**
     * 来源类型 0 SaaS（默认） 1 Api
     */
    private String sourceType;
    /**
     * 来源编码，当sourceType是API时，需要传入企业应
     * 用ID
     */
    private String sourceCode;
    /**
     * 实名类型
     */
    private String authType;
    /**
     * 企业实名类型
     */
    private String companyAuthType;
    /**
     * 企业实名结果
     */
    private String companyAuthResult;
}
