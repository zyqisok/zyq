package com.zyq.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 搜索关键词
 * 
 * @author zyq
 * @date 2019-04-25
 */
@Entity
@Table(name = "key_word")
public class Keyword extends BaseBean {

    private String word; // 关键词（英文全部存小写）
    private int type; // 类型
    private int times; // 次数
    public String getWord() {
        return word;
    }
    public int getType() {
        return type;
    }
    public int getTimes() {
        return times;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setTimes(int times) {
        this.times = times;
    }
    @Override
    public String toString() {
        return "Keyword [word=" + word + ", type=" + type + ", times=" + times
                + "]";
    }

    

}
