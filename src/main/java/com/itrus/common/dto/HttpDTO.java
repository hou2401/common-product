package com.itrus.common.dto;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "http")
public class HttpDTO {
	
	/**
	 * 是否采用http请求方式
	 */
	private String httped;
	
	/**
	 * 当httped 为1 或者 true 时，此参数生效
	 */
	private String url;
	
	/**
	 * 调用原子服务 使用 分布的 还是 整合版本
	 */
	private String alled;
	
	/**
	 * 重试次数 
	 * 默认1此
	 */
	@Value("${http.retryCount:1}")
	private Integer retryCount;
	
	/**
	 * 是否为http模式
	 * @return
	 * @throws HttpException
	 */
	public boolean httped() throws HttpException{
		if( "1".equals(httped) || "true".equalsIgnoreCase(httped) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否为合并调用式
	 * @return
	 * @throws HttpException
	 */
	public boolean alled() throws HttpException{
		if( "1".equals(alled) || "true".equalsIgnoreCase(alled) ) {
			return true;
		}
		return false;
	}
}
