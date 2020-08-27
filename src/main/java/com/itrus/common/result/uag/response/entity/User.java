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
public class User {
    private String uuid;

    private String displayName;

    private String nickName;

    private String phone;

    private String state;

    private String email;

    private String createTime;

    private String isJoinCompany;

    private String authResult;

    private String authType;

    private String relations;
}
