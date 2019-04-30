package com.zyq.vo;

public class NodeVo {
    private Long id;
    private Long pId;
    private String name;
    private String url;
    private boolean isParent = false;
    private boolean changed = true; // true-界面需要查询，false-不需要ajax查询

    public boolean getChanged() {
        return changed;
    }
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    public void setParent(boolean isParent) {
        this.isParent = isParent;
    }
    public Long getId() {
        return id;
    }
    public Long getpId() {
        return pId;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setpId(Long pId) {
        this.pId = pId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean getIsParent() {
        return isParent;
    }
    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }
    
}
