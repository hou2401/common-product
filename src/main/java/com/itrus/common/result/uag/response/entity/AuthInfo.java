package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AuthInfo implements Serializable {
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
     * 法人代表
     */
    private String legalName;
    /**
     * 工商注册号
     */
    private String registerNumber;
    /**
     * 注册资金
     */
    private String registerMoney;
    /**
     * 注册地址
     */
    private String registerAddress;
    /**
     * 登记机关
     */
    private String registrationAuthority;
    /**
     * 营业期限开始时间
     */
    private String beginTime;
    /**
     * 营业期限结束时间
     */
    private String endTime;
    /**
     * 银行账号
     */
    private String bankNum;
    /**
     * 开户银行名称
     */
    private String bankName;
    /**
     * 开户支行名称
     */
    private String subBankName;
    /**
     * 营业范围
     */
    private String businessScope;
    /**
     * 核准日期
     */
    private String checkTime;
    /**
     * 成立日期
     */
    private String setupTime;
    /**
     * 吊销日期
     */
    private String revokeTime;
    /**
     * 经营状态
     */
    private String orgState;
    /**
     * 认证类型
     */
    private String authType;
    /**
     * 认证结果
     */
    private String authResult;
    /**
     * 认证时间
     */
    private String authTime;
    /**
     * 银行编码
     */
    private String bankCode;
    /**
     * 银行身份编码
     */
    private String bankProvinceCode;
    /**
     * 银行城市编码
     */
    private String bankCityCode;

}
