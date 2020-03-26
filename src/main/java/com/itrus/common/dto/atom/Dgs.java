package com.itrus.common.dto.atom;

import lombok.Data;
import lombok.ToString;

/**
 *文档生产服务url
 * @author wen_guoxing
 *
 */
@Data
@ToString
public class Dgs {
	/**
	 * PDF模板填充
	 */
	private String pdfFill;
	/**
	 * PDF创建
	 */
	private String pdfCreate;
}
