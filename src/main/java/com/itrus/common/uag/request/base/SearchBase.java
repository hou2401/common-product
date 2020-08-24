package com.itrus.common.uag.request.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBase {
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
