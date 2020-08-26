package com.itrus.common.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.response.uag.RegisterResult;

public class TestMain {
	public static void main(String[] args) throws IOException {
		
		
		String input = FileUtils.readFileToString(new File("src/test/resources/json.json"), "UTF-8");     //需要maven依赖
        JSONObject jsonObject = JSONObject.parseObject(input);     //需要maven依赖
        RegisterResult javaObject = jsonObject.toJavaObject(RegisterResult.class);
        
        Long uuid = javaObject.getUuid();
        System.out.println(javaObject.toString());
        
	}
}
