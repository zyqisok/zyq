package com.zyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.beans.User;
import com.zyq.repository.UserRepository;
import com.zyq.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    public User findUser(String loginName, String password) {
        return userRepository.findByLoginNameAndPassword(loginName, password);
    }


}
