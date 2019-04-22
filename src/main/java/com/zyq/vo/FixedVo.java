package com.zyq.vo;

public class FixedVo {

    public int key;
    public String value;
    public String remark;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getRemark() {
        return remark;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FixedVo [key=" + key + ", value=" + value + ", remark="
                + remark + "]";
    }
}
