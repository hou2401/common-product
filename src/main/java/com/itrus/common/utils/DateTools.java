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

    /***
     * 日期类型转换，默认支持两种格式：2017-03-23 或 2017-03-23 23:23:23
     * @param text 日期字符串
     * @return 日期对象
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

    /***
     * 日期类型转换
     * @param text 日期字符串
     * @param partten 格式
     * @return 日期对象
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

    /***
     * 日期格式化
     *     如果时分秒都为0，格式化为：2017-03-23
     *     如果时分秒有值， 格式化为：2017-03-23 23:23:23
     * @param date  日期对象
     * @return  日期字符串
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
    /***
     * 日期格式化
     *     格式化为：二○一八年十二月二拾日
     * @param date  日期对象
     * @return  日期字符串
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
    
    
    /***
     * 日期格式化
     * @param date  日期对象
     * @param pattern 格式
     * @return  日期字符串
     */
    public static String format(Date date, String pattern) {
        if(date == null ||  pattern == null)  {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
    
    public static Date addYear(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        return c.getTime();
    }
    
    public static Date addMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }
    
    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }
    
    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hour);
        return c.getTime();
    }
    
    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }
    
    public static Date addSecond(Date date, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, second);
        return c.getTime();
    }
}
