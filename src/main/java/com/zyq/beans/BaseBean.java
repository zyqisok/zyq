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
    private Long createId; // 创建人ID
    private String createName; // 创建人名称
    private Date updateTime; // 更新时间
    private Long updateId; // 更新人ID
    private String updateName; // 更新人名称
    private String updateMsg; // 更新备注

    public Long getId() {
        return id;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public Long getCreateId() {
        return createId;
    }
    public String getCreateName() {
        return createName;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public Long getUpdateId() {
        return updateId;
    }
    public String getUpdateName() {
        return updateName;
    }
    public String getUpdateMsg() {
        return updateMsg;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public void setCreateId(Long createId) {
        this.createId = createId;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

}
