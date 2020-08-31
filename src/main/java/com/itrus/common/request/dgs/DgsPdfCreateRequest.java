package com.itrus.common.request.dgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;

/**
 * @author yuying
 * PDF创建
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DgsPdfCreateRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 样式类型，0 夜晚样式，1 github样式(默认)，2 白报纸样式
     */
    private int styleType;
    /**
     * 页面大小，支持0，1，2，3，4，分别代表A0，A1，A2，A3，A4，默认为A4
     */
    private int pageSize;
    /**
     * 模板创建数据，其中包含vtp.md模板文件，param.json模板参数文件和其它使用到的图片文件，vtp.md,param.json,图片文件，必须在压缩包的根目录
     */
    private File zipFile;
}
