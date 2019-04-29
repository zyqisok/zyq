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
import com.zyq.consts.NodeType;
import com.zyq.service.NodeService;
import com.zyq.tools.Resp;
import com.zyq.tools.Tool;
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

    /**
     * 添加文件夹
     * @return
     */
    @RequestMapping("/addFloder")
    @ResponseBody
    private Resp<NodeVo> addFloder(long pid, String name) {
        if (pid != 0) {
            Node find = nodeService.findById(0, pid);
            if (find == null) {
                return Resp.error("父文件夹不存在");
            }
        }
        name = Tool.toString(name);
        int len = name.length();
        if (len == 0) {
            return Resp.error("文件夹名称不能为空");
        }
        if (len > 20) {
            return Resp.error("文件夹名称过长");
        }
        Node node = new Node();
        node.setType(NodeType.FOLDER);
        node.setName(name);
        node.setCreateTime(new Date());
        node.setPid(pid);
        nodeService.save(node);
        return Resp.success(getNodeVo(node));
    }

    /**
     * 获取所有子节点
     * @return
     */
    @RequestMapping("/getChildList")
    @ResponseBody
    private Resp<List<NodeVo>> getChildList(long pid) {
        List<Node> nodeList = nodeService.findByPid(0, pid);
        return Resp.success(getNodeVoList(nodeList));
    }
}
