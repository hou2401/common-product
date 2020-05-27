package com.itrus.common.params.uag;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author hzq
 * @since 2020/5/27
 */
@Data
@ToString
public class SearchOneNodeParams extends BaseUagParams {
    /**
     * 查询条件
     */
    private SearchCondition searchCondition;
}
