package com.zyq.repository;

import org.springframework.stereotype.Repository;

import com.zyq.beans.User;

@Repository
public interface UserRepository extends BaseRepository<User> {

    User findByLoginName(String loginName);
    User findByLoginNameAndPassword(String loginName, String password);
}
