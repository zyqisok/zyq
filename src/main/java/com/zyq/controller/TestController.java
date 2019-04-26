package com.zyq.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyq.api.JuHeCaiPuApi;
import com.zyq.beans.JuHeCai;
import com.zyq.beans.Keyword;
import com.zyq.consts.KeywordType;
import com.zyq.service.JuheCaiService;
import com.zyq.service.KeyWordService;
import com.zyq.tools.Tool;
import com.zyq.vo.RespJuHeCai;

@Controller
public class TestController {

    @Autowired
    private KeyWordService KeyWordService;
    @Autowired
    private JuheCaiService juheCaiService;
    
    @RequestMapping("/checkKey")
    @ResponseBody
    public String checkKey(String word) {
        if (Tool.isEmpty(word)) {
            return "empty";
        }
        word = Tool.toString(word).toLowerCase();
        Keyword find = KeyWordService.findByWord(word, KeywordType.JUHE_CAI);
        if (find == null) {
            find = new Keyword();
            find.setWord(word);
            find.setTimes(1);
            find.setType(KeywordType.JUHE_CAI);
        } else {
            find.setTimes(find.getTimes() + 1);
        }
        KeyWordService.save(find);
        return find.toString();
    }

    @RequestMapping("/getCai")
    @ResponseBody
    public List<JuHeCai> getCai(String cai){
        if (Tool.isEmpty(cai)) {
            return Collections.emptyList();
        }
        // 检查当前关键词是否已被搜索
        cai = Tool.toString(cai).toLowerCase();
        Keyword find = KeyWordService.findByWord(cai, KeywordType.JUHE_CAI);
        boolean isFind = false;
        if (find == null) {
            find = new Keyword();
            find.setWord(cai);
            find.setTimes(1);
            find.setType(KeywordType.JUHE_CAI);
        } else {
            isFind = true;
            find.setTimes(find.getTimes() + 1);
        }
        KeyWordService.save(find);
        if (isFind) {
            // 查找数据库即可
            List<JuHeCai> caiList = juheCaiService.findByTitleContaining(cai);
            return caiList;
        }
        List<JuHeCai> caiList = new ArrayList<JuHeCai>();
        int index = 0;
        int size = 30;
        int totalNum = 0;
        do {
            RespJuHeCai resp = JuHeCaiPuApi.getCaiList(cai, index, size);
            List<JuHeCai> cais = resp.getData();
            for (JuHeCai juHeCai : cais) {
                if (juheCaiService.findByJuheId(juHeCai.getJuheId()) == null) {
                    juheCaiService.save(juHeCai);
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
