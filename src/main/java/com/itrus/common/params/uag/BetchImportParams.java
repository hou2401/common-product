package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  批量导入企业成员请求UAG参数对象
 * </p>
 *
 * @author hzq
 * @since 2020/5/29
 */
@Data
@ToString
public class BetchImportParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员账号-手机号
     */
    private String manager;

    /**
     * 所属企业uuid
     */
    private Long uuid;
    /**
     * 邀请用户集合
     */
    private List userList;

}
