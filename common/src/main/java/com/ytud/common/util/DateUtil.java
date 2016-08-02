package com.ytud.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * yangch 2016/7/19
 */
public class DateUtil {

    /**
     * 获取格式化日期
     * @param format 格式
     * @return
     */
    public static String getDateFormat(String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        return dateFormater.format(new Date());
    }
    /**
     * 时间戳转换为格式化日期
     * @param time 时间戳
     * @param format 日期格式
     * @return
     */
    public static String getDateByTime(long time, String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        return dateFormater.format(time);
    }
    /**
     * 获取当前时间(秒数格式)
     *
     * @return
     */
    public static int getNowSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前时间(毫秒数)
     *
     * @return
     */
    public static long getNowTime() {
        return System.currentTimeMillis();
    }
}
