package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  离职接口入参对象
 * </p>
 *
 * @author hzq
 * @since 2020/6/5
 */
@Data
@ToString
public class UserDimissionParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;
    /**
     * 当前企业的uuid
     */
    private Long parentUuid;
    /**
     * 用户uuid
     */
    private Long uuid;
    /**
     * 用户状态（0 待加入 1 已加入 2 异常 3 拒绝 4 离职）
     */
    private String joinState;

}
