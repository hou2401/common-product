package com.itrus.common.request.atom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 印章图片透明处理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SealLimpidRequest {
    /**
     * 印章图片的Base64编码
     */
    private String sealBase64;
    /**
     * 印章颜色 1: 红色（默认）、2: 绿色、3: 蓝色、4:黑色
     */
    private Integer color;
    /**
     * 印章大小，如果印章图片为圆章该值为印章直径，
     * 如果为椭圆章该值为印章宽度。如果不传会使用原始图片的大小，单位：px
     */
    private Integer diameter;
    /**
     * 印章透明度（0-10），值越小透明度越大，默认：10
     */
    private Integer alpha;
}
