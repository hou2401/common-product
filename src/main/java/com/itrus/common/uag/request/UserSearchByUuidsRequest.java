package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
