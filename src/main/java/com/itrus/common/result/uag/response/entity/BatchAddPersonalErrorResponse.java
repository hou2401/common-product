package com.itrus.common.result.uag.response.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName BatchAddPersonalErrorResponse
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 20:42 2020/9/2
 * @Modified By:
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BatchAddPersonalErrorResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String displayName;
    
    private String phone;

    private String message;

    private Integer code;


}
