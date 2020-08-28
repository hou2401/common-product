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
public class PagesSignatures {
	/**
     * 多页签时为必选项<br/>指定盖章页，格式形如：1~5,8,-3~-1<br/>0：所有页盖章（默认）<br/>1~5：第1页至第5页盖章<br/>-3~-1：倒数第3页至倒数第1页盖章
     */
    private String pages;
    /**
     * 印章资源地址，参考附录附录7.2，<br />sealBytes和sealURI都不填，无印章图片的签章<br />同时存在时，sealBytes优先。
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
     * 将印章置于签章定位点的哪个位置<br />取值：center-以印章中心做为坐标定位点；leftTop-以印章左上做为坐标定位点；leftBottom-以印章左下做为坐标定位点<br />coordinateAxisType=1时，默认以印章左下做为坐标定位点<br />coordinateAxisType=2时，默认以印章左上做为坐标定位点
     */
    private String sealPoint;
    /**
     * 签章样式：<br />none：不加任何样式（默认）<br />date：加印章下方加时间
     */
    private String stampStyle;
    /**
     * 结合coordinateAxisType和sealPoint来确定坐标X轴位置<br />默认印章水平居中， A4文件大小：21cm×29.7cm
     */
    private Float x;
    /**
     * 结合coordinateAxisType和sealPoint来确定坐标Y轴位置，<br />默认印章垂直居中
     */
    private Float y;
    /**
     * 印章图片缩放比例：<span style="color:#00CC00">【V1.5.1新增】</span><br/>取值范围大于0小于等于5<br>0.1：缩小到10%<br>1：原始大小<br>3：放大到300%
     */
    private String sealScale;

}
