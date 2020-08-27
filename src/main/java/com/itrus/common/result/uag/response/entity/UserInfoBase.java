package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 用户基本信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBase {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 个人邮箱
     */
    private String email;
    /**
     * 账号状态 0 未激活 1 正常 2 挂起
     */
    private String state;
    /**
     * 证件类型
     */
    private String idCardType;
    /**
     * 证件号码
     */
    private String idCardNum;
    /**
     * 出生日期
     */
    private String birth;
    /**
     * 性别
     */
    private String sex;
    /**
     * 账号扩展属性JSON
     */
    private Object extendAttr;
}
