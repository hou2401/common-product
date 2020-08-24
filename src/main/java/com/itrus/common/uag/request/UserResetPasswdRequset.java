package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 重置密码
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResetPasswdRequset extends UserBase {
    /**
     * 用户原始密码
     */
    private  String oldPasswd;
}
