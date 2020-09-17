package com.itrus.common.request.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author hzq
 * @since 2020/9/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextareaItem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 文本
     */
    private String text;

    /**
     * 文字字体 1:宋体、2:楷体、3:黑体，默认:1
     */
    private Integer fontText;

    /**
     * 字体大小，默认：12
     */
    private Float fontSize;

    /**
     * 字体颜色，十六进制颜色代码，默认：#333333
     */
    private String fontColor;

    /**
     *文本对齐方式 0:左对齐、1:居中对齐、2:右对齐，默认:0
     */
    private Integer alignment;

    /**
     * 文本域宽度，单位:px
     */
    private Integer textareaWidth;

    /**
     * 文本域高度，单位:px
     */
    private Integer textareaHeight;

    /**
     * 百分比X横坐标，0.5代表在横向中部位置，左上角为起点，默认:0
     */
    private Float xPercent;

    /**
     *百分比Y纵坐标，0.5代表在纵向中部位置，左上角为起点，默认:0
     */
    private Float yPercent;


}
