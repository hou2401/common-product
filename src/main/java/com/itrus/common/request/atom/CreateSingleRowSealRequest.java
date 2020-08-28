package com.itrus.common.request.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 单行人名印章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSingleRowSealRequest {
    /**
     * 人名
     */
    private String name;
    /**
     * 颜色： 1: 红色（默认）, 2: 绿色, 3: 蓝色, 4: 黑色
     */
    private Integer color;
    /**
     * 字体：1:微软雅黑（默认）, 2: 黑体, 3:宋体， 4:华文行楷, 5:方正舒体
     */
    private Integer sealFontType;
    /**
     * 印章透明度（1-10）
     */
    private Integer alpha;
    /**
     * 有无边框（默认 1）  1：有， 0：无
     */
    private Integer frame;

}
