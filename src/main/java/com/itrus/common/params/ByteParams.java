package com.itrus.common.params;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * 邮件参数实体
 * @author wgx52
 *
 */
@Data
@ToString
public class ByteParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *文件流名称 比如 ceshi.md  ceshi.png  必带后缀
	 */
	private String fileName;
	
	private byte[] bytes;

	public ByteParams(String fileName, byte[] bytes) {
		super();
		this.fileName = fileName;
		this.bytes = bytes;
	}

	public ByteParams() {
		super();
	}
}
