package com.itrus.common.result.uag.request;


import com.itrus.common.result.uag.response.entity.DeptInfo;
import com.itrus.common.result.uag.response.entity.RoleInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 组织架构添加成员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequest {
    /**
     * 必选
     * 姓名
     */
    private String displayName;
    /**
     * 必选
     * 手机号码
     */
    private String phone;
    /**
     * 可选
     * 企业邮箱
     */
    private String employeeEmail;
    /**
     * 可选
     * 员工编号
     */
    private String employeeCode;
    /**
     * 必选
     * 要加入的上级
     */
    private List<DeptInfo> deptInfo;
    /**
     * 可选
     * 角色
     */
    private List<RoleInfo> roleInfo;
    /**
     * 必选
     * 用户状态
     * 0 String 未加入
     * 1 String 在职
     * 2 String 已拒绝
     * 3 String 异常
     * 4 String 离职
     */
    private String joinState;
    /**
     * 可选
     * 来源编码 若是接口创建，请填写企业应用ID ,否则默
     * 认为界面创建
     */
    private String sourceCode;

}
