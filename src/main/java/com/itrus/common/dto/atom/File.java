package com.itrus.common.dto.atom;

import lombok.Data;
import lombok.ToString;

/**
 * 文件相关url
 * @author wen_guoxing
 *
 */
@Data
@ToString
public class File {
	/**
	 * 上传文件
	 */
	private String upload;

	/**
	 * 文件base64上传
	 */
	private String uploadBase64;

	/**
	 * #文件删除
	 */
	private String delete;

	/**
	 * 文件下载
	 */
	private String download;

	private String downloadBase64;
	/**
	 * 文档转换
	 */
	private String word2Pdfs;
}
