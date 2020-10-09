package com.itrus.common.result.uag.response.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BatchAddPersonalSuccessResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private String phone;

    private String displayName;

    private String externalUserUuid;
    

}