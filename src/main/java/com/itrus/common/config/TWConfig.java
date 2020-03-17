package com.itrus.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.itrus.newportal.servlet.ApiServiceServlet;

import lombok.extern.slf4j.Slf4j;

/**
 * ApiService 配置
 *
 * @author ssr
 */
@Slf4j
@Configuration
@ConditionalOnClass(ApiServiceServlet.class)
public class TWConfig {

    private static final ApiServiceServlet API_SERVLET = new ApiServiceServlet();
    /**
     * 获取ApiServiceServlet
     *
     * @return ApiServiceServlet
     */
    public static ApiServiceServlet getApiServiceServlet() {
        return API_SERVLET;
    }

}