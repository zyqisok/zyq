package com.zyq.test;

public class Test {

    public static void main(String[] args) {
        // String
        long t1 = System.nanoTime();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
        long t2 = System.nanoTime();
        System.out.println("String 耗时：" + (t2-t1) + " 微秒");
        // StringBuffier
        long t3 = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append(i);
        }
        long t4 = System.nanoTime();
        System.out.println("StringBuffer 耗时：" + (t4-t3) + " 微秒");
        // 
        long t5 = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append(i);
        }
        long t6 = System.nanoTime();
        System.out.println("StringBuilder 耗时：" + (t6-t5) + " 微秒");
    }
}
