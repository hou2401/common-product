package com.itrus.common.request.uag;

import com.itrus.common.request.uag.base.UserBase;
import com.itrus.common.request.uag.entity.ExtendAttr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人申请企业认证
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrgRegisterRequest extends UserBase {
     /**
     *企业全称
     */
     private String orgName;
     /**
     *是否三证合一
     */
     private String inOneType;
     /**
     *统一社会信用代码（三证合一时必选）
     */
     private String socialCode;
     /**
     *组织架构代码（三证未合一必选）
     */
     private String unitCode;
     /**
     *工商注册号（三证未合一必选）
     */
     private String registerNumber;
     /**
     *认证类型
     */
     private String authType;
     /**
     *实名结果
     */
     private String authResult;
     /**
     *扩展属性
     */
     private ExtendAttr extendAttr;


}
