package com.zyq.task;

import java.util.TimerTask;

/**
 * 自动更新报表数据
 * @author ZhangYuanqiang
 * @date 2019-04-30
 */
public class ReportTask extends TimerTask {

    @Override
    public void run() {
        // 为方便阅读，具体逻辑代码略
        System.out.println("报表更新成功");
    }

}
