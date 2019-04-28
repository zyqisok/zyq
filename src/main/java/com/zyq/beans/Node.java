package com.zyq.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zyq.consts.NodeType;

/**
 * 节点
 * @author ZhangYuanqiang
 * @date 2019-04-28
 */
@Entity
@Table(name = "node")
public class Node extends BaseBean {

    /**
     * 用户ID
     */
    private long uid;

    /**
     * 名称
     */
    private String name;

    /**
     * 节点类型
     * @see NodeType
     */
    private int type;

    /**
     * 父节点
     */
    private long pid;

    /**
     * 描述
     */
    private String remark;

    /**
     * 链接
     */
    private String url;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public long getPid() {
        return pid;
    }

    public String getRemark() {
        return remark;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
