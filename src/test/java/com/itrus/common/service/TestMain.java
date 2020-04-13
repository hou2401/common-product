package com.itrus.common.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.itrus.common.utils.BeanUtil;

public class TestMain {
	public static void main(String[] args) {
		Map test = new LinkedHashMap();
		test.put("test", 1);
		test.put("abc", "erer");
		Map<String, Object> map = BeanUtil.toMap(test);
		
		System.out.println( JSON.toJSONString(map) );

	}
}
