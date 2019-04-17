package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * @author ZhangYuanqiang
 * @date 2019-04-17（项目创建时间）
 */
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
        System.out.println("Startup OK !!!");
    }

}
