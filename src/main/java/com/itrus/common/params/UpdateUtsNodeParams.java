package com.itrus.common.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper=true)
public class UpdateUtsNodeParams extends CreateUtsNodeParams {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 要修改的节点uuid
     */
    private Long uuid;
}
