package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.Data;
import lombok.ToString;

/**
 * 个人账号实名接口
 */
@ToString
@Data
public class UserUpdateAuthRequest extends UserBase {
    /**
     *银行卡号
     */
    private String bankCardNum;
    /**
     *认证时间
     */
    private String authTime;
    /**
     *认证结果
     */
    private String authResult;
    /**
     *认证方式
     */
    private String authType;
    /**
     *认证信息来源（SaaS、API），默认SaaS
     */
    private String sourceType;
    /**
     *当sourceType是SaaS时，appid需要传入为企业应用的应
     * 用ID
     */
    private String appId;
}
