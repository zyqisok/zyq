package com.zyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.beans.Node;
import com.zyq.repository.NodeRepository;
import com.zyq.service.NodeService;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Override
    public void save(Node node) {
        nodeRepository.save(node);
    }

    @Override
    public void deleteById(long uid, long id) {
        nodeRepository.deleteByUidAndId(uid, id);
    }

    @Override
    public Node findById(long uid, long id) {
        return nodeRepository.findByUidAndId(uid, id);
    }

    @Override
    public List<Node> findByPid(long uid, long pid) {
        return nodeRepository.findByUidAndPid(uid, pid);
    }

    @Override
    public List<Node> findFirstList(long uid) {
        return nodeRepository.findByUidAndPid(uid, 0L);
    }

}
