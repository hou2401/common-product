package com.itrus.common.request.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppDeleteRequest {
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
}
