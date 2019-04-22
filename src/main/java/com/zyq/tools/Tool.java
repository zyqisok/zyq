package com.zyq.tools;

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

	
}
