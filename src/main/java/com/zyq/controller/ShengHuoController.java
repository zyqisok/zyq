package com.zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyq.beans.JuHeCai;
import com.zyq.service.JuheCaiService;

@Controller
@RequestMapping("shenghuo")
public class ShengHuoController {

    @Autowired
    private JuheCaiService juheCaiService;

    @RequestMapping("/getCai")
    public String getCai(Model model, long id){
        JuHeCai cai = juheCaiService.findById(id);
        model.addAttribute("cai", cai);
        return "shenghuo/cai_detail";
    }

}
