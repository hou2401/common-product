package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 加载指定部门用户列表
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserSearchByDeptRequest extends EntBase {

    /**
     * 0 全量 1 一级（默认）
     */
    private String level;
    /**
     * 个人唯一标识
     */
    private Long userUuid;
    /**
     *姓名
     */
    private String displayName;
    /**
     *手机号
     */
    private String phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *角色名称
     */
    private String roleName;
    /**
     *在职，离职状态
     */
    private String joinState;
    /**
     *每页数量
     */
    private Integer pageSize;
    /**
     *页码
     */
    private Integer pageNumber;
}
