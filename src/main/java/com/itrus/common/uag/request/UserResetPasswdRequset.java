package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.Data;
import lombok.ToString;

/**
 * 重置密码
 */
@ToString
@Data
public class UserResetPasswdRequset extends UserBase {
    /**
     * 用户原始密码
     */
    private  String oldPasswd;
}
