package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  UAG（十二接口）:用户详细信息查询请求参数
 * </p>
 *
 * @author hzq
 * @since 2020/5/28
 */
@Data
@ToString
public class UserSearchInfoParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;
    /**
     * 用户上级节点uuid
     */
    private Long parentUuid;
    /**
     * 查询条件
     */
    private UserInfoSearchCondition searchCondition;

}
