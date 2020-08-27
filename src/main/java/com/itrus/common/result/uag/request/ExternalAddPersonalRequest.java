package com.itrus.common.result.uag.request;

import com.itrus.common.request.base.UserBase;

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
public class ExternalAddPersonalRequest extends UserBase {
    /**
     * 节点类型
     */
    private String type;
}
