package com.qianfeng.controller;

import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;

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
}
