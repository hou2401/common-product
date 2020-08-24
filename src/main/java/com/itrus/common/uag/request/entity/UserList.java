package com.itrus.common.uag.request.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
    /**
     *姓名
     */
    private String displayName;
    /**
     *手机号码
     */
    private String phone;
    /**
     *企业邮箱
     */
    private String employeeEmail;
    /**
     *员工编号
     */
    private String employeeCode;
    /**
     *要加入的上级,从企业名称按照层级目录书写，以-隔开
     */
    private String parent;
    /**
     *角色名称
     */
    private String role;

}
