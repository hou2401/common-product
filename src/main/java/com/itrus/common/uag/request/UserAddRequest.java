package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.Data;
import lombok.ToString;

/**
 * 组织架构添加成员
 */
@ToString
@Data
public class UserAddRequest extends UserBase {
     /**
      * 企业邮箱
      */
     private String employeeEmail;
     /**
      * 员工编号
      */
     private String employeeCode;
     /**
      * 要加入的上级
      */
     private String parent;
     /**
      * 角色
      */
     private String role;
     /**
      * 0 在职（默认） 1 离职
      */
     private String employeeState;
}
