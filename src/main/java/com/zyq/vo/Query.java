package com.zyq.vo;

import java.util.Collections;
import java.util.List;

public class Query<T> {

    Pager pager;
    List<T> list;

    public Query() {
    }

    public Query(Pager pager, List<T> list) {
        this.pager = pager;
        this.list = list;
    }

    public Pager getPager() {
        if (pager == null) {
            return pager;
        }
        return new Pager();
    }

    public List<T> getList() {
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
