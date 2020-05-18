package com.itrus.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从redis获取具体地址
 * @author wgx52
 *
 */
public class ServiceUtil {

	  public static  Map<String,List<Map<String,Object>>> parseApiServiceHost(Map<String, String> apiServiceHost)
	    {
	        Map<String,List<Map<String,Object>>> apiHostMap = new HashMap<>();
	        for(Map.Entry<String, String> host: apiServiceHost.entrySet()) {
	            Map<String,Object> config = JSON.parseObject(host.getValue());
	            for(String apiname: ((JSONArray)config.get("funclist")).toJavaList(String.class)){
	                List<Map<String,Object>> hostlist = apiHostMap.get(apiname);
	                if(hostlist==null) {
	                    hostlist = new ArrayList<>();
	                    apiHostMap.put(apiname, hostlist);
	                }
	                hostlist.add(config);
	            }
	        }

	        return apiHostMap;
	    }

}
