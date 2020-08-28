package com.itrus.common.request.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBase {
    /**
     * 用户唯一标识
     */
    private String uuid;

    /**
     *姓名
     */
    private String displayName;
    
    /**
     *昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
    /**
     *证件类型
     */
    private String idCardType;
    /**
     *证件号码
     */
    private String idCardNum;

    /**
     * 用户密码
     */
    private String passwd;

    /**
     * 0未激活 1 正常（默认） 2挂起
     */
    private String state;
    
    /**
     * 实名流水ID
     */
    private String authId;
    
    /**
     * 短信流水ID
     */
    private String smsId;
    
    /**
     * 出生日期
     */
    private String birth;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * {账号扩展属性JSON}
     */
    private String extendAttr;

}
