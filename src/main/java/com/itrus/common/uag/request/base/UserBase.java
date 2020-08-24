package com.itrus.common.uag.request.base;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserBase {
    /**
     * 用户唯一标识
     */
    private Long uuid;

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


    public UserBase() {
    }

    public UserBase(Long uuid, String displayName, String phone, String email, String idCardType, String idCardNum, String passwd, String state) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.phone = phone;
        this.email = email;
        this.idCardType = idCardType;
        this.idCardNum = idCardNum;
        this.passwd = passwd;
        this.state = state;
    }


}
