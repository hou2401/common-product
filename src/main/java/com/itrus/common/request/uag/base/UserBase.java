package com.itrus.common.request.uag.base;

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


}
