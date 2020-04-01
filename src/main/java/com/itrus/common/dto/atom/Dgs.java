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

	/**
	 * 添加文字水印
	 */
	private String pdfTextMark;

	/**
	 * 添加图片水印
	 */
	private String pdfImageMark;

	/**
	 * 添加二维码水印
	 */
	private String pdfQrCodeMark;

	/**
	 * 添加文字和二维码水印
	 */
	private String pdfTextAndQrCodeMark;
}
