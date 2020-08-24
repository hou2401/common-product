package com.itrus.common.uag.request.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShowBase {
    /**
     *账号唯一标识
     */
    private Long uuid;
    /**
     * 企业唯一标识
     */
    private Long companyUuid;
}
