package com.qianfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/5/2 0002.
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
    public String login(){
        return "/pictureUpload";
    }

}
