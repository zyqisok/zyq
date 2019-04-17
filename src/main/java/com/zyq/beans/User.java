package com.zyq.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author zyq
 *
 */
@Entity
@Table(name="user")
public class User extends BaseBean {

    String name;
    String loginName;
    int sex;

    public String getName() {
        return name;
    }

    public String getLoginName() {
        return loginName;
    }

    public int getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}
