package com.zyq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyq.beans.SessionKey;
import com.zyq.beans.User;
import com.zyq.service.UserService;
import com.zyq.tools.Resp;
import com.zyq.tools.Tool;

/**
 * @author zyq
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String index(){
        return "user/login";
    }

    /**
     * 用户注册
     * @param loginName 用户名
     * @param loginPassword 密码
     * @param surePassword 确认密码
     * @return 注册结果
     */
    @RequestMapping("/register")
    @ResponseBody
    public Resp<String> register(String loginName, String loginPassword, String surePassword) {
        // 验证用户名
        if (Tool.isEmpty(loginName)) {
            return Resp.error("用户名不能为空");
        }
        // 验证密码
        if (Tool.toString(loginPassword).length() != 32 || Tool.toString(surePassword).length() != 32) {
            return Resp.error("密码格式错误");
        }
        // 去空格
        loginName = Tool.toString(loginName);
        // 验证长度
        if (loginName.length() > 20) {
            return Resp.error("用户名过长");
        }
        // 验证用户名是否已经存在（重复）
        User findUser = userService.findByLoginName(loginName);
        if (findUser != null) {
            return Resp.error("用户已经存在");
        }
        // 验证密码和确认密码是否一致
        if (!loginPassword.equals(surePassword)) {
            return Resp.error("密码和确认密码不一致");
        }
        // 新增用户
        User user = new User();
        user.setCreateTime(new Date());
        user.setLoginName(loginName);
        user.setName(loginName);
        user.setPassword(loginPassword);
        userService.save(user);
        return Resp.success();
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Resp<String> login(String loginName, String loginPassword) {
        User find = userService.findUser(loginName, loginPassword);
        if (find == null) {
            return Resp.error("用户名或密码错误");
        }
        sessionSave(SessionKey.USER_OBJECT, find);
        return Resp.success();
    }

}
