package com.itrus.common.request.dgs.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    /**
     * 参数类型，文本：text、图片：pic、复选框：checkbox（暂不支持）
     */
    private String type;
    /**
     * 参数值，参数类型是text时为文本，是pic时为图片的Base64编码
     */
    private String value;
    /**
     * 目标页码
     */
    private Integer pageNum;
    /**
     * 相对百分比横坐标，0.5代表填充在pdf的横向中部位置
     */
    @JsonProperty("xPercent")
    @JSONField(name = "xPercent")
    private Float xPercent;
    /**
     * 相对百分比纵坐标，0.5代表填充在pdf的纵向中部位置
     */
    @JsonProperty("yPercent")
    @JSONField(name = "yPercent")
    private Float yPercent;
    /**
     * 图片宽度，默认值为图片本身宽度
     */
    private Float picWidth;
    /**
     * 图片高度，默认值为图片本身高度
     */
    private Float picHeight;
    /**
     * 字体大小，默认：12
     */
    private Float fontSize;
    /**
     * 字体颜色，十六进制颜色代码，默认：#333333
     */
    private String fontColor;
    /**
     * 图片缩放比例，默认：1
     */
    private Float scale;
    /**
     * 文本域宽度，单位:px
     */
    private Integer textareaWidth;
    /**
     * 文本域高度，单位:px
     */
    private Integer textareaHeight;
    /**
     * 文字字体 1:宋体、2:楷体、3:黑体，默认:1
     * 仅文本域支持
     */
    private Integer fontType;
    /**
     * 文本对齐方式 0:左对齐、1:居中对齐、2:右对齐，默认:0
     * 仅文本域支持
     */
    private Integer alignment;

}
