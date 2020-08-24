package com.itrus.common.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExternalRemoveRequest {
    /**
     * 数据库标识
     */
    private Long id;
}
