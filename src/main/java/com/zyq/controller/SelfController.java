package com.zyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyq.beans.Node;
import com.zyq.service.NodeService;

/**
 * 个人模块
 * @author ZhangYuanqiang
 * @date 2019-04-28
 */
@RequestMapping("/self")
@Controller
public class SelfController {

    @Autowired
    private NodeService nodeService;

    @RequestMapping("/list")
    public String list(Model model) {
        // 获取祖先节点列表
        List<Node> nodeList = nodeService.findFirstList(0);
        model.addAttribute("nodeList", nodeList);
        return "self/list";
    }

}
