package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人账号实名接口
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateAuthRequest {
    /**
     * 必选 要修改的账号唯一标识
     */
    private String uuid;
    /**
     * 姓名 可选
     */
    private String displayName;
    /**
     * 证件类型 可选
     * 与idCardNum同时存在
     * 1  居民身份证 （默认）
     * 2  护照
     * 3  港澳居民来往内地通行证
     * 4  台湾居民往来大陆通行证
     * 5  香港永久性居民身份证
     * 6  外籍身份证
     */
    private String idCardType;
    /**
     * 证件号码 可选
     */
    private String idCardNum;
    /**
     * 银行卡号 可选
     */
    private String bankCardNum;
    /**
     * 实名类型 可选
     * 0  证件认证
     * 1  手机号认证
     * 2  人脸认证
     * 3  银行卡认证
     */
    private String authType;
    /**
     * 实名结果 可选
     * 0  未实名（默认）
     * 1  已实名
     * 2  实名中
     */
    private String authResult;
    /**
     * 验证码 可选
     */
    private String verificationCode;
    /**
     * 验证码发送时间 可选
     */
    private String codeSendTime;
    /**
     * 验证码验证时间 可选
     */
    private String codeAuthTime;
    /**
     * 认证流水ID 可选
     */
    private String authId;
    /**
     * 短信流水ID 可选
     */
    private String smsId;
    /**
     * 认证申请时间 可选
     */
    private String authApplyTime;
    /**
     * 认证完成时间 可选
     */
    private String authFinishTime;
    /**
     * 相似度 可选
     */
    private String similarity;
    /**
     * 来源类型 可选
     * 0 String SaaS（默认）
     * 1 String API
     */
    private String sourceType;
    /**
     * 来源编码 来源是API时，需要传入企业应用AppID 可选
     */
    private String sourceCode;
    /**
     * 实名认证方 可选
     * 0 String 第三方实名
     * 1 String 天威实名（默认）
     */
    private String certifier;


}
