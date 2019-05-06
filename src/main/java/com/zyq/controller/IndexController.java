package com.zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyq.service.JuheCaiService;
import com.zyq.vo.Pager;

@Controller
public class IndexController {

    @Autowired
    private JuheCaiService juheCaiService;

    /**
     * 首页
     * @param model
     * @param pager
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, Pager pager){
         // model.addAttribute("caiList", juheCaiService.findByPage(pager));
        model.addAttribute("pager", pager);
        return "index";
    }

}
