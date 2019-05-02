package com.zyq.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zyq.beans.Node;

@Repository
public interface NodeRepository extends BaseRepository<Node> {

    Node findByUidAndId(long uid, long id);

    List<Node> findByUidAndPid(long uid, long pid);

    @Transactional
    @Modifying
    @Query(value = "delete from node where uid =?1 and id = ?2 and type = ?3", nativeQuery = true)
    void deleteById(long uid, long id, int type);

}
