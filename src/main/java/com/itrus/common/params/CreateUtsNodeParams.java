package com.itrus.common.params;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *  UAG新增节点参数
 * </p>
 *
 * @author hzq
 * @since 2020/4/1
 */
@Data
@ToString
public class CreateUtsNodeParams implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 管理员账户，必填
     */
    private String manager;

    /**************** 新增用户参数****************/
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码，必填
     */
    private String password;
    /**
     * 职位
     */
    private String position;
    /**
     * 用户状态："在职/离职/实习"
     */
    private String userstate;
    /**
     * 员工编号
     */
    private String employeecode;
    /**
     * 手机号
     */
    private String telephonenum;
    /**
     * 姓名，必填
     */
    private String displayname;
    /**
     * 身份证号
     */
    private String employeecard;
    /**
     * 节点类型：1表示人员2表示部门3表示公司；必填
     */
    private String nodetype;
    /**
     * 父节点id，必填
     */
    private Long parentuuid;
    /**
     * 是否管理员角色："true/false"；必填
     */
    private String hasAdminRole;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 住址
     */
    private String address;
    /**
     * 实名状态：1表示已认证，2表示未认证，3表示认证未通过，4表示联系人已离职，5表示待审核；必填
     */
    private String realName;
    /**
     * 系统用户id
     */
    private Long userId;
    /**
     * 审核状态：1表示审核通过，3表示待审核，4表示审核拒绝；必填
     */
    private String ifAudited;


    /*******************新增部门节点参数**************/
    /**
     * 部门或子公司名称；必填
     */
    private String deptname;
    /**
     * 部门编号或子公司统一代码；必填
     */
    private String deptcode;


    /*******************新增子公司*******************/
    /**
     * 子公司别名
     */
    private String orgaliases;
    
    /**
     * 是否是超级管理员  默认0，不是，   1是超级管理员
     */
    private String ifRoot = "0";

}
