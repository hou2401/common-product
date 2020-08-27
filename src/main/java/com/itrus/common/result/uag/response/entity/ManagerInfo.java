package com.itrus.common.result.uag.response.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ManagerInfo implements Serializable {
    /**
     * 管理员UUID
     */
    private String uuid;
    /**
     * 创作者名字
     */
    private String creatorName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 0 未加入 1 在职 2 已拒绝 3 异常 4 离职
     */
    private String state;
    /**
     * 注册时间
     */
    private String createTime;
}
