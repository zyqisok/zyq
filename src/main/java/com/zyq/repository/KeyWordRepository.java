package com.zyq.repository;

import org.springframework.stereotype.Repository;

import com.zyq.beans.Keyword;

@Repository
public interface KeyWordRepository extends BaseRepository<Keyword> {
    Keyword findByWordAndType(String word, int type);
}
