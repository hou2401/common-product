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
    *
    * @api LogSubStringUtil.subStringInfo 截取字符串
    * @apiVersion 2.2.0
    * @apiParam {String} info 字符串
    * @apiParam {Integer} totalLength 限制字符串长度
    * @apiParam {Integer} subLength 截取字符串长度
    * @apiName subStringInfo
    * @apiGroup LogSubStringUtil工具类
    * @apiSuccess (Success) {String} string 截取后字符串
    * @apiSuccessExample Success-Response:
    *     {
    *       "string":"aakjnakankcakna"
    *     }
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
    *
    * @api LogSubStringUtil.subStringInfo 截取字符串
    * @apiVersion 2.2.0
    * @apiParam {String} info 字符串
    * @apiName subStringInfo
    * @apiGroup LogSubStringUtil工具类
    * @apiSuccess (Success) {String} string 截取后字符串
    * @apiSuccessExample Success-Response:
    *     {
    *       "string":"aakjnakankcakna"
    *     }
	*/
	public static String subStringInfo(String info){
		return subStringInfo(info, null, null);
	}
}
