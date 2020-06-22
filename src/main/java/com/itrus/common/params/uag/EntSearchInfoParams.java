package com.itrus.common.params.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  企业信息查询请求参数
 * </p>
 *
 * @author hzq
 * @since 2020/6/2
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntSearchInfoParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;
    /**
     * 查询条件
     */
    private EntSearchInfoSearchCondition searchCondition;

}
