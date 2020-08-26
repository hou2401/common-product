package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class ApiUpdatePersonalRequest extends UserBase {
    /**
     * 数据库记录
     */
    private Long id;
    /**
     * 实名状态
     */
    private String authResult;
}
