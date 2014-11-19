package com.example.kpp.util;

import org.seasar.util.convert.StringConversionUtil;

public class DateFormatUtil {
    public static String DEFAULT_FORMAT = "yyyy年MM月dd日 HH時mm分ss秒";

    /**
     * 日付を文字列に変換する
     * @param date 日付データ
     * @return 文字列に変換した日付
     */
    public static String getDateFormatConvert(Object date) {
        return getDateFormatConvert(date, DEFAULT_FORMAT);
    }

    /**
     * 日付を指定の形式で文字列に変換する
     * @param date 日付データ
     * @param pattern 日付形式
     * @return 文字列に変換した日付
     */
    public static String getDateFormatConvert(Object date, String pattern) {
        String result = "";
        result = StringConversionUtil.toString(date, pattern);
        return result;
    }
}
