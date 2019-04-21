package com.zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyq.beans.User;
import com.zyq.service.UserService;

/**
 * @author zyq
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String index(){
        User user = new User();
        user.setName("zyq");
        userService.save(user);
        return "user/login";
    }

}
