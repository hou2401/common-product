package com.itrus.common.params.sign;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName keywordSignItem
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 17:28 2020/4/21
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
public class KeywordSignItem {

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

}
