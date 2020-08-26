package com.itrus.common.request.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import com.itrus.common.request.uag.base.UserBase;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSearchByUuidsRequest{
    /**
     * 用户唯一标识集合
     */
    private List<UserBase> uuids;
}
