package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.SearchBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 加载指定部门用户列表
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchByDeptRequest extends SearchBase {
    /**
     * 企业唯一标识
     */
    private Long parentUuid;
}
