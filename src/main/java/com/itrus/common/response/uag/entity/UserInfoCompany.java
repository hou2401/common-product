package com.itrus.common.response.uag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoCompany {

    private String userName;

    private String uuid;

    private String employeeCode;

    private String employeePosition;

    private String employeeEmail;

    private Object extendAttrCompany;

    private List<RoleName> roleName;

    private List<DeptName> deptName;

    private List<DeptName> leaderDeptName;

}
