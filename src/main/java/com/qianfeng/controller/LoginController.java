package com.qianfeng.controller;

import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;

import com.qianfeng.service.impl.UserServiceImpl;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("login.do")
    public JsonBean login(String phone, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        User user = userService.login(phone,password);
        session.setAttribute("user",user);
        if(user != null){
            return JsonBean.setOK("登录",null);
        }else {
            return JsonBean.setERROR("登录",null);
        }

    }

    @GetMapping("randomCode.do")
    public JsonBean randomCode(String phone){


        if(phone != null){
            return JsonBean.setOK("发送验证码", UserServiceImpl.randomCode());
        }else {
            return JsonBean.setERROR("发送验证码",null);
        }

    }

    @GetMapping("login1.do")
    public JsonBean login1(String phone){
        User user = userService.login1(phone);

        if(user != null){
            return JsonBean.setOK("登录",null);
        }else {
            return JsonBean.setERROR("登录",null);
        }

    }




}
