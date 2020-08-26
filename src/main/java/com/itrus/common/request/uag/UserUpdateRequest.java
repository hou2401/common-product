package com.itrus.common.request.uag;

import com.itrus.common.request.uag.base.UserBase;
import com.itrus.common.request.uag.entity.ExtendAttr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人账号更新
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
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
