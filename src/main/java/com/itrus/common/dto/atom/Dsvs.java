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
public class Dsvs {
	/**
	 * PDF签章
	 */
	private String sign;
	/**
	 * PDF批量签章
	 */
	private String batchSign;
	/**
	 * PDF验章
	 */
	private String verifyBase64;

}
