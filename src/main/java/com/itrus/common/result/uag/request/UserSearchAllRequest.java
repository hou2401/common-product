package com.itrus.common.result.uag.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询全网指定用户信息
 */
@Data
@AllArgsConstructor
@ToString

public class UserSearchAllRequest {
    /**
     * 可选 姓名（精确）
     */
    private String displayName;
    /**
     * 可选 手机号码（精确）
     */
    private String phone;
    /**
     * 可选 邮箱（精确）
     */
    private String email;
    /**
     * 可选 证件号码（精确）
     */
    private String idCardNum;

}
