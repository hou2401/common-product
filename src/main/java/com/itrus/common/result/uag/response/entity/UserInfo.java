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
public class UserInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 编号
     */
    private String uuid;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 账号状态 0 未激活 1 正常(默认) 2 挂起
     */
    private String state;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建日期
     */
    private String createTime;
}
