package com.itrus.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.InputStream;

import org.apache.poi.util.IOUtils;

public class ResUtil {

    public static JSONArray getRes() throws Exception {
        InputStream inputStream = ResUtil.class.getResourceAsStream("/res.json");
        byte[] bytesJson = IOUtils.toByteArray(inputStream);
        JSONArray jsonArray = JSON.parseArray(new String(bytesJson, "UTF-8"));
        return jsonArray;
    }
}
