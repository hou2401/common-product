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
     * 姓名
     */
    private String displayName;
    
    /**
     * 实名id
     */
    private String authId;
    
    /**
     * 短信id
     */
    private String smsId;

    /**
     * 实名认证类型
     */
    private String authType;
    
    /**
     * 实名认证结果
     */
    private String authResult;
    
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
    private List<RoleInfo> roleInfo;
    /**
     * 部门名称列表
     */
    private List<DeptInfo> deptInfo;
    /**
     * 领导部门名称列表
     */
    private List<DeptInfo> leaderDeptInfo;

}
