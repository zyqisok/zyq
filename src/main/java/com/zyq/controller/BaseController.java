package com.zyq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.zyq.beans.SessionKey;
import com.zyq.beans.User;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    protected void sessionSave(String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    protected Object getSessionValue(String key) {
        return request.getSession().getAttribute(key);
    }

    protected void sessionRemove(String key) {
        request.getSession().removeAttribute(key);
    }

    protected void setSessionUser(Model model) {
        // 判断用户是否已经登录
        Object o = getSessionValue(SessionKey.USER_OBJECT);
        User user = null;
        if (o != null) {
            user = (User) o;
        } else {
            user = new User();
            user.setName("游客（点我注册）");
        }
        model.addAttribute("user", user);
    }

    protected User getUser() {
        // 判断用户是否已经登录
        Object o = getSessionValue(SessionKey.USER_OBJECT);
        User user = null;
        if (o != null) {
            user = (User) o;
        } else {
            user = new User();
            user.setName("游客（点我注册）");
        }
        return user;
    }

    protected long getUserId(){
        return getUser().getId();
    }
}
