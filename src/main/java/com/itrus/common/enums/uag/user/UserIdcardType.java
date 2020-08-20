package com.itrus.common.enums.uag.user;

import lombok.Getter;

/**
 * 个人证件类型
 * @author wgx52
 *
 */
@Getter
public enum UserIdcardType{
	/**
	 * 居民身份证
	 */
	RESIDENT_IDENTITY_CARD(1, "居民身份证"),
	/**
	 * 护照
	 */
	PASSPORT(2, "护照"),
	/**
	 * 港澳居民往来内地通行证
	 */
	HK_MACAO_MAINLAND_PASS(3, "港澳居民往来内地通行证"),
	/**
	 * 台湾居民来往大陆通行证
	 */
	TAIWAN_MAINLAND_PASS(4, "台湾居民来往大陆通行证"),
	/**
	 * 香港永久性居民身份证
	 */
	HK_PERMANENT_RESIDENCE_PERMI(5, "香港永久性居民身份证"),
	/**
	 * 外国人永久居留证
	 */
	FOREIGNERS_PERMANENT_RESIDENCE_PERMI(6, "外国人永久居留证");

	private int code;
	private String name;

	private UserIdcardType(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
