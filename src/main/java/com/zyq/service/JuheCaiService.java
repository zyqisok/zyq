package com.zyq.service;

import java.util.List;

import com.zyq.beans.JuHeCai;
import com.zyq.vo.Pager;

public interface JuheCaiService {
    List<JuHeCai> findByTitleLike(String cai);
    void save(JuHeCai juHeCai);
    JuHeCai findByJuheId(String juheId);
    JuHeCai findById(Long id);
    List<JuHeCai> findByPage(Pager pager);
}
