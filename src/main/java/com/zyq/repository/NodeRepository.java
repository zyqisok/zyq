package com.zyq.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyq.beans.Node;

@Repository
public interface NodeRepository extends BaseRepository<Node> {

    void deleteByUidAndId(long uid, long id);

    Node findByUidAndId(long uid, long id);

    List<Node> findByUidAndPid(long uid, long pid);
}
