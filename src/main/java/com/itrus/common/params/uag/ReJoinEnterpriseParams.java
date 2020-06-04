package com.itrus.common.params.uag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *  编辑企业成员，调用Uag重新邀请用户接口请求参数
 * </p>
 *
 * @author hzq
 * @since 2020/6/4
 */
@Data
@ToString
@AllArgsConstructor
public class ReJoinEnterpriseParams extends JoinEnterpriseParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * uag企业关系表id
     */
    private Long id;

}
