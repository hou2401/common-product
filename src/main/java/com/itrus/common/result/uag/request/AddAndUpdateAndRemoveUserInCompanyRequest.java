package com.itrus.common.result.uag.request;

import com.alibaba.fastjson.JSONArray;
import com.itrus.common.request.base.EntBase;
import com.itrus.common.result.uag.base.ExtendAttr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 添加/更新/移除成员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AddAndUpdateAndRemoveUserInCompanyRequest extends EntBase {
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
     *要加入的上级
     */
    private JSONArray parent;
    /**
     *角色
     */
    private JSONArray role;
    /**
     * 0 在职（默认） 1 离职
     */
    private String employeeState;
    /**
     * 用户角色列表
     */
    private JSONArray roleList;
    /**
     * 上级节点类型 0 企业（默认） 1 部门 2 用户 3 全部
     */
    private String parentType;
    /**
     * 扩展属性
     */
    private ExtendAttr extendAttr;
}
