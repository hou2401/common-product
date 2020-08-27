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
public class CrossSignatures {

	/**
     * 多页签时为必选项<br/>指定盖章页，格式形如：1~5,8,-3~-1<br/>0：所有页盖章（默认）<br/>1~5：第1页至第5页盖章<br/>-3~-1：倒数第3页至倒数第1页盖章
     */
    private String pages;
    /**
     *印章资源地址，参考附录附录7.2，<br />sealBytes和sealURI都不填，无印章图片的签章<br />同时存在时，sealBytes优先。
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
     * 缩放比例  10%-300%
     */
    private String sealScale;
    
    /**
     * 印章中心距离文档下边缘的距离（cm），<br />默认印章垂直居中
     */
    private Float y;

	
}
