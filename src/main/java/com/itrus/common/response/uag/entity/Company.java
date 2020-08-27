package com.itrus.common.response.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String orgName;

    private String phone;

    private String createTime;

    private String displayName;

    private String userUuid;

    private String authResult;

    private String employeeEmail;

    private String companyUuid;

    private String state;

    private Relations relations;
}
