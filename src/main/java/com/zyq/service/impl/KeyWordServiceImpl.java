package com.zyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.beans.Keyword;
import com.zyq.repository.KeyWordRepository;
import com.zyq.service.KeyWordService;

@Service
public class KeyWordServiceImpl implements KeyWordService {

    @Autowired
    private KeyWordRepository keyWordRepository;

    public void save(Keyword keyWord) {
        keyWordRepository.save(keyWord);
    }

    @Override
    public Keyword findByWord(String word, int Type) {
        return keyWordRepository.findByWordAndType(word, Type);
    }

}
