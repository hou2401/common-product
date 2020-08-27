package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuying
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoAll implements Serializable {
    private String uuid;

    private String nickName;

    private String displayName;

    private String phone;

    private String email;

    private String state;

    private String idCardType;

    private String idCardNum;

    private Object extendAttr;

    private List<RoleName> roleName;

    private List<DeptName> deptName;

    private List<DeptName> leaderDeptName;

    private List<Parent> parent;
}
