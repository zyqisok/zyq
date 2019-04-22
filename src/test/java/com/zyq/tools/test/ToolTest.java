package com.zyq.tools.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.zyq.tools.Tool;

/**
 * 基础工具类测试代码
 * @author zyq
 * @date 2019-04-22
 */
public class ToolTest {

	@Test
	public void toStringTest() {
		String s1 = Tool.toString(null);
		assertTrue(s1.equals(""));
		String s2 = Tool.toString("aaa");
		assertTrue(s2.equals("aaa"));
		String s3 = Tool.toString("  bbb   ");
		assertTrue(s3.equals("bbb"));
	}
}
