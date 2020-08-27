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
     * 证件类型
     */
    private String idCardType;
    /**
     * 证件号码，若存在，证件类型需存在
     */
    private String idCardNum;
    /**
     * 实名类型
     */
    private String authType;
    /**
     * 认证结果
     */
    private String authResult;
    /**
     * 来源类型（SaaS或者API）0 SaaS（默认） 1 Api
     */
    private String sourceType;
    /**
     * 来源编码（SaaS或者APPID）
     */
    private String sourceCode;
}
