package com.qianfeng.controller;

import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public JsonBean findByPosition(String position){
        List<User> list = userService.findByPosition(position);
        return JsonBean.setOK("查找",list);
    }

}
