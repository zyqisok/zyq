package com.zyq.tools;

import java.sql.Clob;

import javax.sql.rowset.serial.SerialClob;

/**
 * 基础工具类
 * @author ZhangYuanqiang
 * @date 2019-04-17
 */
public class Tool {

    /**
     * 字符串空处理（并去掉首位空格）
     * @param s 待处理字符串
     * @return 已处理字符串（null返回空字符串）
     */
    public static String toString(String s) {
        return s == null ? "" : s.trim();
    }

    /**
     * 判断字符串是否为空（空字符串也算空）
     * @param s 待检测字符串
     * @return true-字符串为空，false-字符串不为空
     */
    public static boolean isEmpty(String s) {
        return toString(s).length() > 0 ? false : true;
    }
	
    /**
     * 获取int类型：为空，或者数据不能转化，或超过int取值范围时返回0
     * @param o 待转化对象
     * @return int数字
     */
    public static int getInt(Object o) {
        if (o == null) return 0;
        try {
            return Integer.valueOf(o.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Clob 转 String
     * @param c Clob类型
     * @return String类型
     */
    public static String getString(Clob c) {
        if (c == null) return null;
        try {
            return c.getSubString(1, (int) c.length());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * String 转 Clob
     * @param s String类型
     * @return Clob类型
     */
    public static Clob getClob(String s){
        if (s == null) return null;
        try {
            return new SerialClob(s.toCharArray());
        } catch (Exception e) {
            return null;
        }
    }
}
