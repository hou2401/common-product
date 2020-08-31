package com.itrus.common.result.uag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 通过uuid集合获取用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSearchByUuidsRequest{

    /**
     * 必选 用户唯一标识集合
     */
    private String[] uuids;
}
