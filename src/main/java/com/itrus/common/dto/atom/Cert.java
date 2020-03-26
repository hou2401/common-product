package com.itrus.common.dto.atom;

import lombok.Data;
import lombok.ToString;

/**
 *证书相关url
 * @author wen_guoxing
 *
 */
@Data
@ToString
public class Cert {
	/**
	 * 证书申请
	 */
	private String apply;
	/**
	 * 证书查询
	 */
	private String get;
	/**
	 * 证书吊销
	 */
	private String revoke;
	/**
	 * 证书更新
	 */
	private String update;
}
