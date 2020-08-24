package com.itrus.common.uag.request;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 添加/移除主管
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptAddandRemoveLeaderRequest {
    /**
     *指定部门/企业唯一标识
     */
    private Long uuid;
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
