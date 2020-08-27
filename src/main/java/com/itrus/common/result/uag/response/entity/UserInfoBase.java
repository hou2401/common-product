package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBase {
    private String nickName;

    private String uuid;

    private String displayName;

    private String phone;

    private String email;

    private String state;

    private String idCardType;

    private String idCardNum;

    private String birth;

    private String sex;

    private Object extendAttr;
}
