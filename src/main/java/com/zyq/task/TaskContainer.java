package com.zyq.task;

import java.util.Timer;

/**
 * 自动任务容器
 */
public class TaskContainer {

    public static long SECOND = 1000; // 1秒
    public static long MINUTE = SECOND * 60; // 1分
    public static long HOUR = MINUTE * 60; // 1小时
    public static long DAY = HOUR * 24; // 1天

    /**
     * 定时器开始
     */
    public void startup() {
        Timer timer = new Timer();
        // 启动0秒后，每隔2秒执行1次
        timer.schedule(new ReportTask(), 0, SECOND * 2);
    }

}
