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
public class SelfController extends BaseController {

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
        List<Node> nodeList = nodeService.findFirstList(getUserId());
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
        } else {
            vo.setChanged(false);
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
            Node find = nodeService.findById(getUserId(), pid);
            if (find == null) {
                return Resp.error("父文件夹不存在");
            }
            if (find.getType() != NodeType.FOLDER) {
                return Resp.error("父级必须是文件夹");
            }
        }
        name = Tool.toString(name);
        int len = name.length();
        if (len == 0) {
            return Resp.error("文件夹名称不能为空");
        }
        if (len > 255) {
            return Resp.error("文件夹名称过长");
        }
        Node node = new Node();
        node.setType(NodeType.FOLDER);
        node.setName(name);
        node.setCreateTime(new Date());
        node.setPid(pid);
        node.setUid(getUserId());
        nodeService.save(node);
        return Resp.success(getNodeVo(node));
    }

    /**
     * 添加文件
     */
    @RequestMapping("/addFile")
    @ResponseBody
    private Resp<NodeVo> addFile(long pid, String name, String url) {
        Node find = nodeService.findById(getUserId(), pid);
        if (find == null || find.getType() != NodeType.FOLDER) {
            return Resp.error("请选择一个文件夹");
        }
        name = Tool.toString(name);
        int len = name.length();
        if (len == 0) {
            return Resp.error("文件名称不能为空");
        }
        if (len > 255) {
            return Resp.error("文件名称过长");
        }
        Node node = new Node();
        node.setType(NodeType.FILE);
        node.setName(name);
        node.setCreateTime(new Date());
        node.setPid(pid);
        node.setUrl(Tool.toString(url));
        node.setUid(getUserId());
        nodeService.save(node);
        return Resp.success(getNodeVo(node));
    }

    /**
     * 获取所有子节点
     * @return
     */
    @RequestMapping("/getChildList")
    @ResponseBody
    public Resp<List<NodeVo>> getChildList(long pid) {
        List<Node> nodeList = nodeService.findByPid(getUserId(), pid);
        return Resp.success(getNodeVoList(nodeList));
    }

    /**
     * 修改文件夹
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/updateFloder")
    @ResponseBody
    public Resp<NodeVo> updateFloder(long id, String name) {
        Node find = nodeService.findById(getUserId(), id);
        if (find == null) {
            return Resp.error("文件夹不存在");
        }
        if (find.getType() != NodeType.FOLDER) {
            return Resp.error("必须是文件夹");
        }
        name = Tool.toString(name);
        int len = name.length();
        if (len == 0) {
            return Resp.error("文件名称不能为空");
        }
        if (len > 255) {
            return Resp.error("文件名称过长");
        }
        find.setUpdateTime(new Date());
        find.setName(name);
        nodeService.save(find);
        return Resp.success(getNodeVo(find));
    }

    /**
     * 修改文件夹
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/updateFile")
    @ResponseBody
    public Resp<NodeVo> updateFile(long id, String name, String url) {
        Node find = nodeService.findById(getUserId(), id);
        if (find == null) {
            return Resp.error("文件不存在");
        }
        if (find.getType() != NodeType.FILE) {
            return Resp.error("必须是文件");
        }
        name = Tool.toString(name);
        int len = name.length();
        if (len == 0) {
            return Resp.error("文件名称不能为空");
        }
        if (len > 255) {
            return Resp.error("文件名称过长");
        }
        find.setUpdateTime(new Date());
        find.setName(name);
        find.setUrl(url);
        nodeService.save(find);
        return Resp.success(getNodeVo(find));
    }

    /**
     * 删除文件夹
     * @param id
     * @return
     */
    @RequestMapping("/deleteFloder")
    @ResponseBody
    public Resp<String> deleteFloder(long id) {
        // 验证该文件夹是否为空
        long userId = getUserId();
        List<Node> nodes = nodeService.findByPid(userId, id);
        if (nodes != null && !nodes.isEmpty()) {
            return Resp.error("该文件夹包含子文件，不能删除");
        }
        nodeService.deleteById(userId, id, NodeType.FOLDER);
        return Resp.success();
    }

    /**
     * 删除文件夹
     * @param id
     * @return
     */
    @RequestMapping("/deleteFile")
    @ResponseBody
    public Resp<String> deleteFile(long id) {
        // 验证该文件夹是否为空
        nodeService.deleteById(getUserId(), id, NodeType.FILE);
        return Resp.success();
    }

}
