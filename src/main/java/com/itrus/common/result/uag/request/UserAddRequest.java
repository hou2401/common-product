package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 组织架构添加成员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
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
