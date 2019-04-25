package com.zyq.vo;

import java.util.ArrayList;
import java.util.List;

import com.zyq.beans.JuHeCai;

public class RespJuHeCai {
    List<JuHeCai> data = new ArrayList<JuHeCai>();
    int totalNum = 0; // 总条数
    int pn = 0; // 起始序号
    int rn = 0; // 页面

    public List<JuHeCai> getData() {
        return data;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public int getPn() {
        return pn;
    }

    public int getRn() {
        return rn;
    }

    public void setData(List<JuHeCai> data) {
        this.data = data;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    @Override
    public String toString() {
        return "RespJuHeCai [data=" + data + ", totalNum=" + totalNum + ", pn="
                + pn + ", rn=" + rn + "]";
    }

}
