package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import com.itrus.common.uag.request.entity.ExtendAttr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人账号更新
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest extends UserBase {
    /**
     * 昵称
     */
    private String nikeName;
    /**
     * 扩展属性
     */
    private ExtendAttr extendAttr;
}
