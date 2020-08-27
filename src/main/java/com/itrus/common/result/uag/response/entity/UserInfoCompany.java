package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuying
 * 查看成员详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoCompany {
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户UUId
     */
    private String uuid;
    /**
     * 用户编号
     */
    private String employeeCode;
    /**
     * 用户职位
     */
    private String employeePosition;
    /**
     * 用户企业邮箱
     */
    private String employeeEmail;
    /**
     * 用户在企业内扩展属性JSON
     */
    private Object extendAttrCompany;
    /**
     * 角色名字列表
     */
    private List<RoleName> roleName;
    /**
     * 部门名称列表
     */
    private List<DeptName> deptName;
    /**
     * 领导部门名称列表
     */
    private List<DeptName> leaderDeptName;

}
