package com.itrus.common.uag.request;

import com.alibaba.fastjson.JSONArray;
import com.itrus.common.uag.request.entity.UserList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 批量添加成员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBatchAddRequest {
    /**
     *当前登录人员的唯一标识
     */
    private Long uuid;
    /**
     *批量用户信息
     */
    private List<UserList> userList;
}
