package com.itrus.common.result.uag.response.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName BatchAddCompanyErrorResponse
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 11:35 2020/9/3
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BatchAddCompanyErrorResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    private String displayName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 企业名称
     */
    private String orgName;
    /**
     * 错误消息
     */
    private String message;
    
    /**
     * 错误码
     */
    private Integer code;


}
