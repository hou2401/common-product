package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  用户信息信息查询条件
 * </p>
 *
 * @author hzq
 * @since 2020/5/28
 */
@Data
@ToString
public class UserInfoSearchCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户uuid
     */
    private Long uuid;
    /**
     * 用户姓名
     */
    private String displayName;
    /**
     * 用户认证状态
     */
    private String realName;

    /**
     * 加入状态
     */
    private String[] joinState;

    /**
     * 查询方式：1精确查询、2模糊查询 （不传默认精确查）
     */
    private String queryMode;
}
