package com.itrus.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获得访问真实ip地址
 * @author wgx52
 *
 */
public class RemoteAddr {
	
	/**
    *
    * @api RemoteAddr.getRemoteAddr 获得访问真实ip地址
    * @apiVersion 2.2.0
    * @apiName getRemoteAddr
    * @apiGroup RemoteAddr工具类
    * @apiSuccess (Success) {String} str ip地址
    * @apiSuccessExample Success-Response:
    *     {
    *       "str":"127.0.0.1"
    *     }
	*/
	public static String getRemoteAddr(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(null==ra){
			return "127.0.0.1";
		}
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();		
		if(request.getHeader("X-Real-IP")!=null) {
			return request.getHeader("X-Real-IP");
		} else {
			return request.getRemoteAddr();
		}
	}
}
