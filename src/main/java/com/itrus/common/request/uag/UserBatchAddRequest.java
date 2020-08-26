package com.itrus.common.request.uag;

import java.util.List;

import com.itrus.common.request.uag.base.UserBase;
import com.itrus.common.request.uag.entity.UserList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 批量添加成员
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserBatchAddRequest extends UserBase {
    /**
     *批量用户信息
     */
    private List<UserList> userList;
}
