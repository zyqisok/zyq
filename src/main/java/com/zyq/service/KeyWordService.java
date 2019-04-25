package com.zyq.service;

import com.zyq.beans.Keyword;

public interface KeyWordService {

    void save(Keyword keyWord);

    Keyword findByWord(String word, int type);

}
