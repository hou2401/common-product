package com.itrus.common.request.dsvs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeywordSignatures {
	/**
     * 多页签时为必选项<br/>指定盖章页，格式形如：1~5,8,-3~-1<br/>0：所有页盖章（默认）<br/>1~5：第1页至第5页盖章<br/>-3~-1：倒数第3页至倒数第1页盖章
     */
    private String pages;
    /**
     * 印章资源地址，参考附录附录7.2，<br />sealBytes和sealURI都不填，无印章图片的签章<br />同时存在时，sealBytes优先
     */
    private String sealURI;
    /**
     * 印章的Base64字符串或byte[]
     */
    private String sealBytes;
    /**
     * 印章图片的宽度（cm），默认为图片的宽度
     */
    private Float sealWidth;
    /**
     * 印章图片的高度（cm），默认为图片的高度
     */
    private Float sealHeight;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 最大盖章数量，默认为10，值为0时不限制数量
     */
    private Integer stampMax;
    /**
     * 签章样式：<br />none：不加任何样式（默认）<br />date：加印章下方加时间
     */
    private String stampStyle;
    /**
     * 水平偏移距离（cm），相对于印章默认位置   <br />印章默认位置：印章左边缘与关键字首字的左边缘对齐
     */
    private Float offsetX;
    /**
     * 垂直偏移距离（cm），相对于印章默认位置   <br />印章默认位置：   印章水平中心线与关键字首字的下边缘对齐
     */
    private Float offsetY;
    
    /**
     * 印章图片缩放比例：<span style="color:#00CC00">【V1.5.1新增】</span><br/>取值范围大于0小于等于5<br>0.1：缩小到10%<br>1：原始大小<br>3：放大到300%
     */
    private String sealScale;

    /**
     * 签章模式 0:图片签、1:文本签，默认:0
     */
    private Integer signatureMode;

    /**
     * 文本域参数，signatureMode为1时必填
     */
    private TextareaItem textareaItem;
}
