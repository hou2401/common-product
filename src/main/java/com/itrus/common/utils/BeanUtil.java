package com.itrus.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.itrus.common.params.CertParams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtil {
	/**
	 * @param obj
	 * @return
	 */
    public static Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                if(getter!=null) {
                    Object value=getter.invoke(obj);
                    map.put(key,value);
                }
            }
        }catch(Exception e) {
        	log.error(e.toString(),e);
        }
        return map;
    }
    
    /**
	 * <p>Title: stringToList</p>  
	 * <p>Description: String to List </p>  
	 * @author wen_guoxing  
	 * @param <T>
	 * @date 2018年11月13日 
	 * @param str 入参
	 * @param regex 分隔符
	 * @return List<Long> 
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> stringToList(String str , String regex){

		if( str != null && !"".equals(str.trim()) && null != regex && !"".equals(regex.trim() ) ){

			String[] split = str.split(regex);

			List<T> list  = new ArrayList<>();

			for (String id : split) {
				list.add((T)id);
			}
			return list;
		}

		return null;
	}
	
	/**
	 * 将list转换为 map
	 * @param strings
	 * @return
	 */
	public static Map<String,String> toMap(List<String> strings, String regex ){
		Map<String,String> params = null;
		if( strings != null ){
			params = new HashMap<>();
			for (String str : strings) {
				List<String> param2 = stringToList(str, regex );
				if (null != param2 && !param2.isEmpty()) {
					params.put(param2.get(0), param2.get(1));
				}
			}
		}
		return params;
	}
	
	public static void main(String[] args) {
		CertParams cert = new CertParams();
		Map<String, Object> map = BeanUtil.toMap(cert);
		
		System.out.println(JSON.toJSONString(map));
		
	}
}
