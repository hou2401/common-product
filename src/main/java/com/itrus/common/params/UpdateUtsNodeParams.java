package com.itrus.common.params;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author hzq
 * @since 2020/4/2
 */
@Data
@ToString
public class UpdateUtsNodeParams extends CreateUtsNodeParams {
    /**
     * 要修改的节点uuid
     */
    private Long uuid;
}
