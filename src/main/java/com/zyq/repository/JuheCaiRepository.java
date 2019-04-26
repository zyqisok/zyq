package com.zyq.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyq.beans.JuHeCai;

@Repository
public interface JuheCaiRepository extends BaseRepository<JuHeCai>{
    List<JuHeCai> findByTitleContaining(String cai);
    JuHeCai findByJuheId(String juheId);
}
