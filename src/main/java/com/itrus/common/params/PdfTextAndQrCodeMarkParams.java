package com.itrus.common.params;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName PdfTextMarkParams
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 14:59 2020/4/1
 * @Modified By:
 * @Version 1.0
 * 添加文本和二维码水印请求参数实体
 **/

@ToString
@Component
@Data
public class PdfTextAndQrCodeMarkParams implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * pdf文件的base64编码
     */
    private String pdfData;
    /**
     * 文本水印的实体类
     * 注意，对象里pdfData应该为空，如果传递数据将自动转为空；
     */
    private PdfTextMarkParams textMark;
    /**
     * 二维码水印的实体类
     * 注意，对象里pdfData应该为空，如果传递数据将自动转为空；
     */
    private PdfQrCodeMarkParams qrCodeMark;

}
