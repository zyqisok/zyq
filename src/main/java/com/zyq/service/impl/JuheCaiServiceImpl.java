package com.zyq.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zyq.beans.JuHeCai;
import com.zyq.repository.JuheCaiRepository;
import com.zyq.service.JuheCaiService;
import com.zyq.vo.Pager;

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

    @Override
    public List<JuHeCai> findByPage(Pager pager) {
        Pageable pageable = PageRequest.of(pager.getPage(), pager.getSize());
        Page<JuHeCai> result = juheCaiRepository.findAll(pageable);
        List<JuHeCai> list = result.getContent();
        if (list == null) {
            return Collections.emptyList();
        }
        pager.setTotal(result.getTotalElements());
        return list;
    }

    @Override
    public JuHeCai findById(Long id) {
        return juheCaiRepository.findById(id).get();
    }

}
