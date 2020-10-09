package com.itrus.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ssr on 2017/3/23.
 */
public class DateTools {
    private static final String[] NUMBERS = { 
            "○", "一", "二", "三", "四", "五","六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", 
            "二十", "二十一", "二十二", "二十三", "二十四", "二十五", "二十六", "二十七", "二十八", "二十九", "三十", "三十一"
     };

    public static final String DAY_FORMAT = "yyyy-MM-dd";
    public static final String DAY_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
    *
    * @api DateTools.parse String转化Date
    * @apiVersion 2.2.0
    * @apiParam {String} text 日期字符串 
    * @apiName parse
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {date} date yyyy-MM-dd或yyyy-MM-dd HH:mm:ss
    * @apiSuccessExample Success-Response:
    *     {"data":2020-11-11 or 2020-11-11 12:12:12}
	*/
    public static Date parse(String text) {
        if(text == null || text.length() == 0) {
            return null;
        }

        if(text.length() == DAY_FORMAT.length()) {
            return parse(text, DAY_FORMAT);
        }

        if(text.length() == DAY_TIME_FORMAT.length()) {
            return parse(text, DAY_TIME_FORMAT);
        }

        return null;
    }

    
    /**
    *
    * @api DateTools.parse String转化Date
    * @apiVersion 2.2.0
    * @apiParam {String} text 日期字符串
    * @apiParam {String} partten 日期格式 
    * @apiName parse
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 相应格式日期
    * @apiSuccessExample Success-Response:
    *     {"data":2020-11-11 or 2020-11-11 12:12:12...}
	*/
    public static Date parse(String text, String partten) {
        if(text == null || text.length() == 0) {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(partten);
        try {
            return df.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
    *
    * @api DateTools.format Date转化String
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiName format
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {String} string 日期字符串
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":"2020-11-11 or 2020-11-11 12:12:12"
    *     }
	*/
    public static String format(Date date) {
        if(date == null)  {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if(calendar.get(Calendar.HOUR_OF_DAY) == 0 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.SECOND) == 0) {
            return format(date, DAY_FORMAT);
        } else {
            return format(date, DAY_TIME_FORMAT);
        }
    }

    /**
    *
    * @api DateTools.formatChinese Date转化String
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiName formatChinese
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {String} string 日期字符串
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":"二○一八年十二月二拾日"
    *     }
	*/
    public static String formatChinese(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        
        String yearChinese = "";
        String monthChinese = NUMBERS[month];
        String dayChinese = NUMBERS[day];
        for (char i : String.valueOf(year).toCharArray()) {
            yearChinese += NUMBERS[Integer.parseInt(String.valueOf(i))];
        }
        
        return yearChinese + "年" + monthChinese + "月" + dayChinese + "日";
    }
    
    /**
    *
    * @api DateTools.format Date转化String
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期
    * @apiParam {String} pattern 格式
    * @apiName format
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {String} string 相应格式日期字符串
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":"2020-12-12 or 2020-12-12 12:12:12..."
    *     }
	*/
    public static String format(Date date, String pattern) {
        if(date == null ||  pattern == null)  {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
    
    /**
    *
    * @api DateTools.addYear 添加或减去年
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} year 年数
    * @apiName addYear
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addYear(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        return c.getTime();
    }
    
    /**
    *
    * @api DateTools.addMonth 添加或减去月
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} month 月数
    * @apiName addMonth
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }
    
    /**
    *
    * @api DateTools.addDay 添加或减去天
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} day 天数
    * @apiName addDay
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }
    
    /**
    *
    * @api DateTools.addHour 添加或减去小时
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} hour 小时数
    * @apiName addHour
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hour);
        return c.getTime();
    }
    
    /**
    *
    * @api DateTools.addMinute 添加或减去分钟
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} minute 分钟数
    * @apiName addMinute
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }
    
    /**
    *
    * @api DateTools.addSecond 添加或减去秒
    * @apiVersion 2.2.0
    * @apiParam {Date} date 日期 
    * @apiParam {int} second 秒数
    * @apiName addSecond
    * @apiGroup DateTools工具类
    * @apiSuccess (Success) {Date} date 日期格式
    * @apiSuccessExample Success-Response:
    *     {
    *     "data":2020-12-12 12:12:12
    *     }
	*/
    public static Date addSecond(Date date, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, second);
        return c.getTime();
    }
}
