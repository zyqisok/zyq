package com.zyq.beans;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间

    public Long getId() {
        return id;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
