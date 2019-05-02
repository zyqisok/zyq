package com.zyq.service;

import com.zyq.beans.User;

public interface UserService {

    void save(User user);

    User findByLoginName(String loginName);

    User findUser(String loginName, String password);
}
