package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExternalAddPersonalRequest extends UserBase {
    /**
     * 节点类型
     */
    private String type;
}
