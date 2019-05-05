package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;

import com.qianfeng.service.impl.UserServiceImpl;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    //登录
    @GetMapping("login.do")
    public JsonBean login(String phone, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        User user = userService.login(phone,password);
        session.setAttribute(CommonInfo.LOGIN_USER,user);
//        System.out.println((User)session.getAttribute(CommonInfo.LOGIN_USER));
//        System.out.println(session.getId());
        if(user != null){
            return JsonBean.setOK("登录",null);
        }else {
            return JsonBean.setERROR("登录",null);
        }

    }
    //验证码的获取
    @GetMapping("randomCode.do")
    public JsonBean randomCode(String phone){
        if(phone != null){
            return JsonBean.setOK("发送验证码", UserServiceImpl.randomCode());
        }else {
            return JsonBean.setERROR("发送验证码",null);
        }
    }
    //手机号登录
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
