package com.itrus.common.request.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 椭圆印章生成
 * 圆形印章生成
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCircularSealRequest {
    /**
     * 印章上弦文字
     */
    private String companyName;
    /**
     * 印章宽度，单位：px 默认为400px【V1.3.0修改】
     */
    private Integer diameter;
    /**
     * 印章水平文字
     */
    private String horizontalText;
    /**
     * 印章下弦文字
     */
    private String bottomText;
    /**
     * 颜色 ： 1：红色（默认）， 2：绿色， 3：蓝色， 4：黑色
     */
    private Integer color;

    /**
     * 字体 ：1：微软雅黑（默认）， 2：黑体， 3：宋体，4：华文行楷， 5：方正舒体
     */
    private Integer sealFontType;
    /**
     * 印章透明度（0-10），默认：10
     */
    private Integer alpha;
}
