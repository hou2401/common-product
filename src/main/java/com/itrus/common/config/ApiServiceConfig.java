package com.itrus.common.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.WebApplicationContext;

import com.itrus.api.common.ApiService;
import com.itrus.newportal.servlet.ApiServiceServlet;
import com.itrus.newportal.servlet.AppHomeServiceImpl;
import com.itrus.newportal.servlet.AppHomeServlet.ApiServiceImpl;

/**
 * ApiService 配置
 *
 * @author ssr
 */
@Configuration
@ConditionalOnClass(ApiServiceServlet.class)
public class ApiServiceConfig {

	//	private static final ApiServiceServlet API_SERVLET = new ApiServiceServlet();
	/**
	 * 获取ApiServiceServlet
	 *
	 * @return ApiServiceServlet
	 */
	public static ApiServiceImpl getApiServiceServlet() {
		// apphome 中获取
		ApiServiceImpl apiService  =  (ApiServiceImpl) getRequest().getServletContext().getAttribute("__apiservice__");
		return  apiService;
	}

	private static  WebApplicationContext webApplicationConnect;

	@Autowired
	public void setSysUserRoleService(WebApplicationContext webApplicationConnect) {
		ApiServiceConfig.webApplicationConnect = webApplicationConnect;
	}

	private static HttpServletRequest getRequest() {
		return new MockHttpServletRequest(webApplicationConnect.getServletContext());
	}

}