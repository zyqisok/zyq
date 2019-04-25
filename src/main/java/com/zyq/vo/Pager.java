package com.zyq.vo;

public class Pager {

    long total = 0;
    int size = 20;
    int page = 1;
    int totalPage = 0;
    public long getTotal() {
        return total;
    }
    public int getSize() {
        return size;
    }
    public int getPage() {
        return page;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotal(long total) {
        this.totalPage = (int) Math.ceil(total/(double)size);
        this.total = total;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}
