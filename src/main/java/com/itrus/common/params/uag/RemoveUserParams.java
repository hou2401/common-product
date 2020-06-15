package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  移除企业成员请求UAG参数对象
 * </p>
 *
 * @author hzq
 * @since 2020/5/29
 */
@Data
@ToString
public class RemoveUserParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;

    /**
     * 企业关系表id
     */
    private Long id;

}
