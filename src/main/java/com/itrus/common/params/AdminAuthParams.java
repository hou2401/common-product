package com.itrus.common.params;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  UAG 用户管理员升级降级入参
 * </p>
 *
 * @author han_yanhui
 * @since 2020/4/1
 */
@Data
@ToString
public class AdminAuthParams implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 管理员账户，必填
     */
    private String manager;

   /**
    * 组织id
    */
    private Long uuid;

}
