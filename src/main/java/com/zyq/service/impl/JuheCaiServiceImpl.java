package com.zyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.beans.JuHeCai;
import com.zyq.repository.JuheCaiRepository;
import com.zyq.service.JuheCaiService;

@Service
public class JuheCaiServiceImpl implements JuheCaiService {

    @Autowired
    private JuheCaiRepository juheCaiRepository;

    @Override
    public List<JuHeCai> findByTitleLike(String cai) {
        return juheCaiRepository.findByTitleLike(cai);
    }

    @Override
    public void save(JuHeCai juHeCai) {
        juheCaiRepository.save(juHeCai);
    }

    @Override
    public JuHeCai findByJuheId(String juheId) {
        return juheCaiRepository.findByJuheId(juheId);
    }

}
