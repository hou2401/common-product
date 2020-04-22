package com.itrus.common.params.sign;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName PdfBatchSign
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 9:38 2020/4/22
 * @Modified By:
 * @Version 1.0
 **/
@Data
@ToString
public class PdfBatchSign {

    /**
     * 文档资源地址，参考附录附录7.2，<br />pdfBytes和pdfURI至少要有一项，<br />同时存在时，pdfBytes优先
     */
    private String pdfURI;
    /**
     * PDF文档的Base64字符串或byte[]
     */
    private String pdfBytes;
    /**
     * 返回类型：<br />base64 ：返回文档base64编码（默认）<br />fss : 返回文档存储后的ID
     */
    private String returnType;
    /**
     * 坐标类型：<br />1：左下角为原点，单位为像素（默认）<br />2：左上角为原点，数值为百分比
     */
    private Long coordinateAxisType;

    private List<Signers> signers;

}
