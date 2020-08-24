package com.itrus.common.uag.request;

import com.itrus.common.uag.request.base.UserBase;
import com.itrus.common.uag.request.entity.ExtendAttr;
import lombok.Data;
import lombok.ToString;

/**
 * 个人账号更新
 */
@ToString
@Data
public class UserUpdateRequest extends UserBase {
    /**
     * 昵称
     */
    private String nikeName;
    /**
     * 扩展属性
     */
    private ExtendAttr extendAttr;

    public UserUpdateRequest(String nikeName, ExtendAttr extendAttr) {
        this.nikeName = nikeName;
        this.extendAttr = extendAttr;
    }

    public UserUpdateRequest(Long uuid, String displayName, String phone, String email, String idCardType, String idCardNum, String passwd, String state, String nikeName, ExtendAttr extendAttr) {
        super(uuid, displayName, phone, email, idCardType, idCardNum, passwd, state);
        this.nikeName = nikeName;
        this.extendAttr = extendAttr;
    }
}
