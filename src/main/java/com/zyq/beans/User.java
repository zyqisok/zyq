package com.zyq.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zyq.annotation.ExcelDesc;

/**
 * 
 * @author zyq
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseBean {

    @ExcelDesc("姓名")
    String name;
    String loginName;
    String password;
    @ExcelDesc("头像")
    String head;
    @ExcelDesc("年龄")
    int age;
    int sex;
    @ExcelDesc("备注")
    String remark;

    public String getName() {
        return name;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getHead() {
        return head;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", loginName=" + loginName
                + ", password=" + password + ", head=" + head + ", age=" + age
                + ", sex=" + sex + ", remark=" + remark + "]";
    }

}
