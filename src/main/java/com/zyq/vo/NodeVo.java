package com.zyq.vo;

public class NodeVo {
    private Long id;
    private Long pId;
    private String name;
    private String url;
    private boolean isParent = false;
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
