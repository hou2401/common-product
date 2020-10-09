package com.itrus.common.request.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.itrus.common.request.dgs.entity.Param;

/**
 * @author yuying
 * PDF模板填充
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfFillRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 文档资源地址
     * http:http\|https资源：<br />http://www.itrus.com.cn/contract/10001.pdf
     * fss:文件存储服务上的ID：<br />fss://612764508776960191
     */
    private String pdfURI;
    /**
     * 参数信息列表
     */
    private List<Param> params;
    /**
     * 返回类型：<br />base64 ：返回文档base64编码（默认）<br />fss : 返回文档存储后的ID
     */
    private String returnType;

}
