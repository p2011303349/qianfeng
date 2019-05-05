package com.qianfeng.controller;

import com.qianfeng.entity.Action;
import com.qianfeng.service.ActionService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
@RestController
public class ActionController {
    //查询所有的活动
    @Autowired
    private ActionService actionService;
    @RequestMapping("selectAll.do")
    public JsonBean selectAll(){
        List<Action> actions = actionService.selectAll();
        return JsonBean.setOK("查询成功",actions);
    }
    //根据活动id查询活动的详情
    @RequestMapping("selectById.do")
    public JsonBean selectById(int id){
        Action action = actionService.selectByPrimaryKey(id);
        return JsonBean.setOK("查询成功",action);
    }


}
