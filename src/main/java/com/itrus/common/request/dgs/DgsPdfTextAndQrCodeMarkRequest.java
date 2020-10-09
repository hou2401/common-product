package com.itrus.common.request.dgs;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuying
 * 添加文字和二维码水印
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfTextAndQrCodeMarkRequest implements Serializable {
	
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
    private DgsPdfTextMarkRequest textMark;
    
    /**
     * 二维码水印的实体类
     * 注意，对象里pdfData应该为空，如果传递数据将自动转为空；
     */
    private DgsPdfQrCodeMarkRequest qrCodeMark;
}
