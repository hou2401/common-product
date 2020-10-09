package com.itrus.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtil {
	
	/**
    *
    * @api BeanUtil.toMap Bean转化Map
    * @apiVersion 2.2.0
    * @apiParam {Object} obj 实体类 
    * @apiName toMap
    * @apiGroup BeanUtil工具类
    * @apiSuccess (Success) {Map} map 键值对
    * @apiSuccessExample Success-Response:
    *     {
    *       "id": 123456,
    *       "name": "韩延辉"
    *     }
	*/
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object obj) {

		Map<String, Object> map = new HashMap<>();
		if( obj !=  null ) {
			if( obj instanceof Map ) {
				return (Map<String, Object>) obj;
			}
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
						if(value == null ) {
							continue;
						}
						if(value instanceof String ) {
							String v = (String) value;
							if(StringUtils.isNotBlank(v)) {
								map.put(key,value);
							}
						}else {
							map.put(key,value);
						}
					}
				}
			}catch(Exception e) {
				log.error(e.toString(),e);
				return map;
			}
		}
		return map;
	}

	/**
    *
    * @api BeanUtil.stringToList String转化List
    * @apiVersion 2.2.0
    * @apiParam {String} str String字符串
    * @apiParam {String} regex 分隔符
    * @apiName stringToList
    * @apiGroup BeanUtil工具类
    * @apiSuccess (Success) {List} list 集合
    * * @apiSuccessExample Success-Response:
    *     ["韩延辉",
    *     "老汉"
    *     ]
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
}
