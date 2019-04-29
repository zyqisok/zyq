package com.zyq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyq.beans.Node;
import com.zyq.consts.Msg;
import com.zyq.consts.NodeType;
import com.zyq.service.NodeService;
import com.zyq.tools.Resp;
import com.zyq.vo.NodeVo;

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
        return "self/list";
    }

    @RequestMapping("/initNodeTree")
    @ResponseBody
    public Resp<List<NodeVo>> initNodeTree(){
        // 获取祖先节点列表
        List<Node> nodeList = nodeService.findFirstList(0);
        return Resp.success(getNodeVoList(nodeList));
    }

    @RequestMapping("/add")
    @ResponseBody
    public Resp<String> add(String name, Long pid){
        Node node = new Node();
        node.setName(name);
        node.setPid(pid);
        node.setType(NodeType.FOLDER);
        node.setRemark(name);
        node.setCreateTime(new Date());
        node.setUrl("https://www.baidu.com");
        nodeService.save(node);
        return Resp.success();
    }

    private NodeVo getNodeVo(Node node) {
        NodeVo vo = new NodeVo();
        vo.setId(node.getId());
        vo.setpId(node.getPid());
        vo.setUrl(node.getUrl());
        vo.setName(node.getName());
        if (node.getType() == NodeType.FOLDER) {
            vo.setIsParent(true);
        }
        return vo;
    }

    private List<NodeVo> getNodeVoList(List<Node> nodeList) {
        List<NodeVo> voList = new ArrayList<NodeVo>();
        for (Node node : nodeList) {
            voList.add(getNodeVo(node));
        }
        return voList;
    }
}
