package com.itrus.common.utils;

import com.itrus.common.constants.SubstringConstant;

/**
 * 用于字符串超过限制长度，截取字符串
 * 主要用于日志存储
 * @author wgx52
 *
 */
public class LogSubStringUtil {

	/**
	 * 截取字符串
	 * 错误日志存储
	 * @param info
	 * @return
	 */
	public static String subStringInfo(String info, Integer totalLength, Integer subLength ){
		
		if( totalLength == null ){
			totalLength = SubstringConstant.TOTAL_LENGTH;
		}
		if( subLength == null ){
			subLength = SubstringConstant.SUBSTRING_LENGTH;
		}
		if( info.length() > totalLength ){
			info = info.substring(subLength);
		}
		return info;
	}
	
	/**
	 * 截取字符串
	 * 错误日志存储
	 * @param info
	 * @return
	 */
	public static String subStringInfo(String info){
		return subStringInfo(info, null, null);
	}
}
