package com.itrus.common.request.uag;

import com.alibaba.fastjson.JSONArray;
import com.itrus.common.request.uag.base.EntBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 添加/移除主管
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class DeptAddAndRemoveLeaderRequest extends EntBase {

    /**
     *企业  部门
     */
    private String type;
    /**
     * 主管uuid
     */
    private Long  leaderUuid;
    /**
     *主管uuid列表
     */
    private JSONArray leaderUuids;


}
