package com.qianfeng.controller;

import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("findPosition.do")
    public JsonBean UserPosition(){
        List<User> list = userService.findPosition();
        return JsonBean.setOK("查找",list);
    }

    @GetMapping("findByPosition.do")
    public JsonBean findByPosition(String position) {
        List<User> list = userService.findByPosition(position);
        return JsonBean.setOK("查找", list);
    }

    @GetMapping("user/register.do")
    public JsonBean register(String phone, String password){
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        int i = userService.insertSelective(user);
        if (i != 0){
            return JsonBean.setOK("注册成功！",null);
        }else {
            return JsonBean.setERROR("注册失败！可能是用户名存在",null);
        }


    }

}
