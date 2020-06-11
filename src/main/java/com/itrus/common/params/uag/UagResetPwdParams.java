package com.itrus.common.params.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName UagResetPwdParams
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 13:35 2020/6/10
 * @Modified By:
 * @Version 1.0
 **/
@ToString
@Data
@AllArgsConstructor
public class UagResetPwdParams {

    /**
     * 用户的手机号
     */
    private String phone;
    /**
     * 旧密码
     */
    private String oldPassWd;
    /**
     * 新密码
     */
    private String passWd;

}
