package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人账号注册
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterAndAuthRequest {
    /**
     * 必选 手机号码
     */
    private String phone;
    /**
     * 可选 密码
     */
    private String passwd;
    /**
     * 可选 状态 0 未激活 1 正常 2 挂起
     */
    private String state;
    /**
     * 可选 姓名
     */
    private String displayName;
    /**
     * 可选 昵称
     */
    private String nickName;
    /**
     * 可选 邮箱
     */
    private String email;
    /**
     * 可选 证件类型
     */
    private String idCardType;
    /**
     * 可选 证件号码
     */
    private String idCardNum;
    /**
     * 实名类型
     */
    private String authType;
    /**
     * 实名结果
     */
    private String authResult;
    /**
     * 银行卡号
     */
    private String bankCardNum;
    /**
     * 验证码
     */
    private String verificationCode;
    /**
     * 验证码发送时间
     */
    private String codeSendTime;
    /**
     * 验证码验证时间
     */
    private String codeAuthTime;
    /**
     * 认证流水ID
     */
    private String authId;
    /**
     * 短信流水ID
     */
    private String smsId;
    /**
     * 认证申请时间
     */
    private String authApplyTime;
    /**
     * 认证完成时间
     */
    private String authFinishTime;
    /**
     * 相似度
     */
    private String similarity;
    /**
     * 实名认证方
     */
    private String certifier;
    /**
     * 可选 账号来源 0:Saas(默认)  1: Api
     */
    private String sourceType;

    /**
     * 可选 来源编码 来源是API，需要传入AppID
     */
    private String sourceCode;

}
