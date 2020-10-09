package com.itrus.common.request.dsvs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.request.dsvs.entity.Signer;

/**
 * @author yuying
 * PDF批量签章
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DsvsBatchSignRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 文档资源地址，参考附录[附录7.2](# 7.2 URI资源说明)，<br />pdfBytes和pdfURI至少要有一项，<br />同时存在时，pdfBytes优先。<br /><span style="color:#00CC00">base64类型的URI在后续版本中会删除，base64请用参数pdfBytes【V1.3.0修改】</span>
     * http:http\|https资源：<br />http://www.itrus.com.cn/contract/10001.pdf
     * fss:文件存储服务上的ID：<br />fss://612764508776960191
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
     * 坐标类型：<br />1：左下角为原点，单位CM（默认）<br />2：左上角为原点，数值为百分比
     */
    private Long coordinateAxisType;
    /**
     * 签名者信息
     */
    private List<Signer> signers;
}
