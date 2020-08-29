package com.itrus.common.request.dsvs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName DsvsKeywordCoordinateRequest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 12:14 2020/8/29
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DsvsKeywordCoordinateRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 要获取关键字坐标的PDF文件
     */
    private Long fssId;
    /**
     * 关键字
     */
    private String keyword;

}
