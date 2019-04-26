package com.zyq.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zyq.api.JuHeCaiPuApi;
import com.zyq.beans.JuHeCai;
import com.zyq.repository.JuheCaiRepository;
import com.zyq.repository.KeyWordRepository;
import com.zyq.service.JuheCaiService;
import com.zyq.vo.Pager;
import com.zyq.vo.RespJuHeCai;

@Service
public class JuheCaiServiceImpl implements JuheCaiService {

    @Autowired
    private JuheCaiRepository juheCaiRepository;
    @Autowired
    private KeyWordRepository keyWordRepository;

    @Override
    public List<JuHeCai> findByTitleContaining(String cai) {
        return juheCaiRepository.findByTitleContaining(cai);
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

    @Override
    public List<JuHeCai> getApiCaiList(String key) {
        List<JuHeCai> caiList = new ArrayList<JuHeCai>();
        int index = 0;
        int size = 30; // 接口每页最大返回30条数据
        int totalNum = 0;
        do {
            System.out.println(key + "--" + index + "--" + size +"--" + totalNum);
            RespJuHeCai resp = JuHeCaiPuApi.getCaiList(key, index, size);
            List<JuHeCai> cais = resp.getData();
            for (JuHeCai juHeCai : cais) {
                if (findByJuheId(juHeCai.getJuheId()) == null) {
                    save(juHeCai); // API返回的菜谱不存在时，存数据库
                }
            }
            caiList.addAll(cais);
            if (totalNum == 0) {
                totalNum = resp.getTotalNum();
            }
            index += size;
        } while (index + size < totalNum - 1);
        return caiList;
    }

}
