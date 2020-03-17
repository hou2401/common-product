package com.itrus.common.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.springframework.stereotype.Component;

import com.itrus.common.utils.YmlConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpDTO {
	/**
	 * 读取yaml文件
	 * @return
	 * @throws HttpException
	 */
	private String getHttped() throws HttpException {
		String httped =  YmlConfig.get("http.httped");{}
		 log.info("YmlConfig http.httped={}", httped );
		 
		 if( StringUtils.trimToNull(httped) == null ) {
			 throw new HttpException("http请求模式，请配置http-httped参数信息，修改位置文件"); 
		 }
		 return httped;
	}
	
	public boolean httped() throws HttpException{
		if( "1".equals(getHttped()) || "true".equalsIgnoreCase(getHttped()) ) {
			return true;
		}
		return false;
	}

	public String getUrl() throws HttpException{
		String url =  YmlConfig.get("http.url");
		if( httped() && StringUtils.isEmpty(url) ) {
			throw new HttpException("http请求模式，请配置http-url参数信息，修改位置文件");
		}
		return url;
	}
}
