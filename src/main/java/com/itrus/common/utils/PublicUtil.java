package com.itrus.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * 
 * @author wen_guoxing
 *
 * 2019年8月9日
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublicUtil {

	/**
    *
    * @api PublicUtil.isEmpty 判断对象是否Empty
    * @apiDescription 判断对象是否Empty(null或元素为0),String Collection及其子类 Map及其子类
    * @apiVersion 2.2.0
    * @apiParam {Object} obj 检查对象
    * @apiName isEmpty
    * @apiGroup PublicUtil工具类
    * @apiSuccess (Success) {boolean} boo 成功失败
    * @apiSuccessExample Success-Response:
    *     {
    *       "boo":true
    *     }
	*/
	public static boolean isEmpty(Object pObj) {
		if (pObj == null) {
			return true;
		}
		if (pObj == "") {
			return true;
		}
		if (pObj instanceof String) {
			return ((String) pObj).length() == 0;
		} else if (pObj instanceof Collection) {
			return ((Collection<?>) pObj).isEmpty();
		} else if (pObj instanceof Map) {
			return ((Map<?, ?>) pObj).size() == 0;
		}
		return false;
	}

	/**
    *
    * @api PublicUtil.isNotEmpty 判断对象是否为NotEmpty
    * @apiDescription 判断对象是否NotEmpty(null或元素为0),String Collection及其子类 Map及其子类
    * @apiVersion 2.2.0
    * @apiParam {Object} obj 检查对象
    * @apiName isNotEmpty
    * @apiGroup PublicUtil工具类
    * @apiSuccess (Success) {boolean} boo 成功失败
    * @apiSuccessExample Success-Response:
    *     {
    *       "boo":true
    *     }
	*/
	public static boolean isNotEmpty(Object pObj) {
		return !isEmpty(pObj);
	}

	/**
    *
    * @api PublicUtil.percentToDouble 百分比字符串转double
    * @apiDescription 判断对象是否NotEmpty(null或元素为0),String Collection及其子类 Map及其子类
    * @apiVersion 2.2.0
    * @apiParam {String} percent 百分比字符串
    * @apiName percentToDouble
    * @apiGroup PublicUtil工具类
    * @apiSuccess (Success) {double} dou double
    * @apiSuccessExample Success-Response:
    *     {
    *       "dou":12.12
    *     }
	*/
	public static double percentToDouble(String percent) throws ParseException {
		NumberFormat nf = NumberFormat.getPercentInstance();
		Number m = nf.parse(percent);//将百分数转换成Number类型
		double dd = m.doubleValue();//通过调用nubmer类默认方法直接转换成double
		return dd;
	}

	/**
    *
    * @api PublicUtil.spiltGis 空间位置信息切割数组
    * @apiDescription 例如："POINT(108.9498710632 34.2588125935)"
    * @apiVersion 2.2.0
    * @apiParam {String} gis 空间位置信息
    * @apiName spiltGis
    * @apiGroup PublicUtil工具类
    * @apiSuccess (Success) {String[]} str 字符串数组
    * @apiSuccessExample Success-Response:
    *     {
    *       "str":[
    *       108.9498710632,
    *       34.2588125935
    *       ]
    *     }
	*/
	public static String[] spiltGis(String gis) {
		String[] arr = gis.substring(gis.indexOf("(")+1, gis.indexOf(")")).split(" ");
		return arr;
	}
}
