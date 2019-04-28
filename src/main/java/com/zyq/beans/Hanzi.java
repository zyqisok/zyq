package com.zyq.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 聚合菜谱
 * @author zyq
 * @date 2019-04-25
 */
@Entity
@Table(name = "hanzi")
public class Hanzi extends BaseBean {

    private String zi;

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    @Override
    public String toString() {
        return "Hanzi [zi=" + zi + "]";
    }

}
