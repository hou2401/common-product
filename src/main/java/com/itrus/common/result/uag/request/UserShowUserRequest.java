package com.itrus.common.result.uag.request;


import lombok.*;

/**
 * 个人详情
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShowUserRequest {
    /**
     * 可选 用户唯一标识
     */
    private String uuid;
    /**
     * 可选 手机号码
     */
    private String phone;

}
