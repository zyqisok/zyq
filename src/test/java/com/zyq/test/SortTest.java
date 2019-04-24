package com.zyq.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Kreas", 18));
        userList.add(new User("Rose", 1));
        userList.add(new User("Jack", 4));
        userList.add(new User("Jimi", 23));
        // 按学生名称升序（从小到大）排序
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("按名称升序排序结果：");
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

}
