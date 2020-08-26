package com.itrus.common.request.uag;

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
