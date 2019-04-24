package com.zyq.test;

public class User {

    private String name; // 姓名
    private int index; // 学号

    public User() {
    }

    public User(String name, int index) {
        super();
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", index=" + index + "]";
    }

}
