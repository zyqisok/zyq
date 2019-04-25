package com.zyq.service;

import java.util.List;

import com.zyq.beans.JuHeCai;

public interface JuheCaiService {
    List<JuHeCai> findByTitleLike(String cai);
    void save(JuHeCai juHeCai);
    JuHeCai findByJuheId(String juheId);
}
