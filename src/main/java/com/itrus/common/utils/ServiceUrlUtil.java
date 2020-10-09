/*
 * package com.itrus.common.utils;
 * 
 * import java.util.List; import java.util.Map;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.apache.commons.lang3.StringUtils;
 * 
 * import com.itrus.api.name.NameService; import
 * com.itrus.api.name.NameServiceUtil;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 *//**
	 * Copyright: Copyright (c) 2019 LanRu-Caifu
	 * 
	 * @ClassName: ChargeUtil.java
	 * @Description: 该类的功能描述
	 *
	 * @version: v1.0.0
	 * @author: wen_guoxing
	 * @date: 2019年5月7日 下午12:40:39
	 *
	 */
/*
 * @Slf4j public class ServiceUrlUtil {
 * 
 * private static String appUrl = null;
 * 
 * private static final String URL = "url";
 * 
 * public static String getAppSingle( HttpServletRequest request,String
 * groupNames, String appName){ if(StringUtils.isEmpty(appUrl)){ appUrl =
 * getApigatUrl(request,groupNames,appName); } log.info("apigateUrl={}",appUrl);
 * return appUrl; }
 * 
 *//**
	 * @Function: ChargeUtil.java
	 * @Description: 该函数的功能描述 获得apigate url
	 * @param:@param request
	 * @param:@param authBean
	 * @param:@return
	 * @return：String @throws：
	 *//*
		 * private static String getApigatUrl(HttpServletRequest request,String
		 * groupNames, String appName){ NameService nameservice =
		 * NameServiceUtil.createNameService(request.getServletContext()); final
		 * Map<String, List<Map<String,Object>>> apihostmap =
		 * ServiceUtil.parseApiServiceHost(nameservice.getService(groupNames)); final
		 * List<Map<String,Object>> servers = apihostmap.get(appName); if (servers !=
		 * null && !servers.isEmpty()) { final Map<String, Object> config =
		 * servers.get((int) (Math.random() * servers.size())); String apigateUrl =
		 * config.get(URL).toString(); return apigateUrl; } return null; } }
		 */