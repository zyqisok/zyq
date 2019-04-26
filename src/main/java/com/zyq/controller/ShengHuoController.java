package com.zyq.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyq.beans.JuHeCai;
import com.zyq.beans.Keyword;
import com.zyq.consts.KeywordType;
import com.zyq.service.JuheCaiService;
import com.zyq.service.KeyWordService;
import com.zyq.tools.Tool;
import com.zyq.vo.Pager;

@Controller
@RequestMapping("shenghuo")
public class ShengHuoController {

    @Autowired
    private JuheCaiService juheCaiService;
    @Autowired
    private KeyWordService keyWordService;

    /**
     * 获取菜谱详情
     */
    @RequestMapping("/getCai")
    public String getCai(Model model, long id) {
        JuHeCai cai = juheCaiService.findById(id);
        model.addAttribute("cai", cai);
        return "shenghuo/cai_detail";
    }

    /**
     * 获取菜谱列表
     * @param key
     * @return
     */
    @RequestMapping("/getCaiList")
    public String getCaiList(Model model, String key) {
        key = Tool.toString(key);
        boolean isUseApi = false;
        // 关键字超过2个字，才考虑调用API
        if (key.length() >= 2) {
            // 检测关键字是否已经被搜索过
            String lowerKey = key.toLowerCase();
            Keyword keyword = keyWordService.findByWord(lowerKey, KeywordType.JUHE_CAI);
            if (keyword == null) {
                // 如果关键字不存在，则调用API
                isUseApi = true;
                // 保存关键字到DB
                keyword = new Keyword();
                keyword.setWord(key);
                keyword.setType(KeywordType.JUHE_CAI);
                keyword.setTimes(1);
                keyword.setCreateTime(new Date());
                keyWordService.save(keyword);
            } else {
                // 更新关键字搜索次数
                keyword.setUpdateTime(new Date());
                keyword.setTimes(keyword.getTimes() + 1);
                keyWordService.save(keyword);
            }
        }
        List<JuHeCai> caiList = new LinkedList<JuHeCai>();
        if (isUseApi) {
            // 接口调用
            caiList = juheCaiService.getApiCaiList(key);
        } else {
            // 数据库查询
            if (Tool.isEmpty(key)) {
                caiList = juheCaiService.findByPage(new Pager());
            } else {
                caiList = juheCaiService.findByTitleContaining(key);
            }
        }
        model.addAttribute("caiList", caiList);
        model.addAttribute("key", key);
        return "index";
    }
}
