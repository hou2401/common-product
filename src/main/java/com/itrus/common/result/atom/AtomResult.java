package com.itrus.common.result.atom;

import org.apache.poi.ss.formula.functions.T;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AtomResult {
	/**
	 * 状态码，0成功
	 */
	private Long code;
	
	/**
	 * 返回对象
	 */
	private T data;
}
