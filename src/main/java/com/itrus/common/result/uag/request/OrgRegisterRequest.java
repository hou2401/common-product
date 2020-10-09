package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人申请企业认证
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgRegisterRequest {
    /**
     * 必选
     * 个人账号唯一标识
     */
    private String uuid;
    /**
     * 必选
     * 企业全称
     */
    private String orgName;
    /**
     * 可选
     * 是否三证合一
     * 0 String 否 1 String 是（默认）
     */
    private String inOneType;
    /**
     * 可选
     * 统一社会信用代码（三证合一时必选）
     */
    private String socialCode;
    /**
     * 可选
     * 组织架构代码（三证未合一必选）
     */
    private String unitCode;
    /**
     * 可选
     * 工商注册号
     */
    private String registerNumber;
    /**
     * 可选
     * 姓名
     */
    private String displayName;
    /**
     * 可选
     * 个人证件类型
     * 1 String 居民身份证 （默认）
     * 2 String 护照
     * 3 String 港澳居民来往内地通行证
     * 4 String 台湾居民往来大陆通行证
     * 5 String 香港永久性居民身份证
     * 6 String 外籍身份证
     */
    private String idCardType;
    /**
     * 可选
     * 个人证件号码（与证件类型同时存在）
     */
    private String idCardNum;
    /**
     * 可选
     * 若是接口创建，请填写企业应用ID ,否则默
     * 认为界面创建
     */
    private String sourceCode;
    /**
     * 可选
     * 个人实名类型
     * 0 String 证件认证
     * 1 String 手机号认证
     * 2 String 人脸认证
     * 3 String 银行卡认证
     */
    private String authType;
    /**
     * 可选
     * 个人实名结果
     * 0 String 未实名（默认）
     * 1 String 已实名
     * 2 String 实名中
     */
    private String authResult;
    /**
     * 可选
     * 验证码
     */
    private String verificationCode;
    /**
     * 可选
     * 验证码发送时间
     */
    private String codeSendTime;
    /**
     * 可选
     * 验证码验证时间
     */
    private String codeAuthTime;
    /**
     * 可选
     * 银行卡号
     */
    private String bankCardNum;
    /**
     * 可选
     * 认证流水ID
     */
    private String authId;
    /**
     * 可选
     * 短信流水ID
     */
    private String smsId;

}
