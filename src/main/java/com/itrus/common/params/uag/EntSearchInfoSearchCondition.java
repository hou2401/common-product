package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  企业信息查询条件
 * </p>
 *
 * @author hzq
 * @since 2020/6/2
 */
@Data
@ToString
public class EntSearchInfoSearchCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 企业名称
     */
    private String orgName;
    /**
     * 企业简称
     */
    private String orgAliases;
    /**
     * 企业统一信用代码
     */
    private String orgCode;
    /**
     * 企业uuid唯一标识
     */
    private String uuid;
    /**
     * 审核状态
     */
    private String[] ifAudited;
    /**
     * 1精确查 2 模糊查 默认精确查询
     */
    private String queryMode;
}
