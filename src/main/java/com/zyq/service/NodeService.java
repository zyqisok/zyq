package com.zyq.service;

import java.util.List;

import com.zyq.beans.Node;

public interface NodeService {

    void save(Node node);

    void deleteById(long uid, long id, int type);

    Node findById(long uid, long id);

    List<Node> findByPid(long uid, long pid);

    List<Node> findFirstList(long uid);

}
