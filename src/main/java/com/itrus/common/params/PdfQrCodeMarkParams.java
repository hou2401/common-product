package com.itrus.common.params;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * @ClassName PdfTextMarkParams
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 14:59 2020/4/1
 * @Modified By:
 * @Version 1.0
 **/

@ApiModel(description = "添加二维码水印请求参数实体")
@ToString
@Component
@Data
public class PdfQrCodeMarkParams implements Serializable {

    /**
     * pdf文件的base64编码
     */
    private String pdfData;

    /**
     * 开始页码；范围：1至total；如果等于null或者小于1或者大于total或者大于endPage，默认为1；（total：总页数
     */
    private Integer beginPage;
    /**
     * 结束页码；范围：1至total；如果等于null或者小于1或者大于total或者小于beginPage，默认为total；（total：总页数）
     */
    private Integer endPage;
    /**
     * 透明度；范围：0至1；0：透明，1：不透明；如果等于null，默认为1；如果小于0，默认为0；如果大于1，默认为1；
     */
    private Float opacity;
    /**
     * 旋转角度；正数：逆时针旋转，负数：顺时针旋转；如果等于null，默认为0；
     */
    private Float rotation;

    /**
     * 水印图片放在PDF上的宽度；如果等于null，则为水印图片默认宽度；
     */
    private Float width;
    /**
     * 水印图片放在PDF上的高度；如果等于null，则为水印图片默认高度；
     */
    private Float height;

    /**
     * 坐标数组；如果等于null，则指定一个x=0且y=0的坐标为默认坐标；
     */
    private Array[] positionList;

    /**
     * 二维码的内容；
     */
    private String qrCodeContent;
    /**
     * 二维码的宽度；如果等于null，默认为100；
     */
    private Integer qrCodeWidth;
    /**
     * 二维码的高度；如果等于null，默认为100；
     */
    private Integer qrCodeHeight;

}
