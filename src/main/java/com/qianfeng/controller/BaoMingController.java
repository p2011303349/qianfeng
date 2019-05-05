package com.qianfeng.controller;

import com.qianfeng.entity.BaoMing;
import com.qianfeng.service.BaoMingService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
@RestController
public class BaoMingController {
    @Autowired
    private BaoMingService baoMingService;
    //报名活动
    @RequestMapping("addBaoMing.do")
    public JsonBean addBaoMing(BaoMing baoMing){
        baoMingService.insertSelective(baoMing);
        return JsonBean.setOK("报名成功",null);
    }
    //根据活动id查询活动参加的人，主要是获取头像
    @RequestMapping("selectByAid.do")
    public JsonBean selectByAid(int aid){
        List<BaoMing> baoMings = baoMingService.selectByaid(aid);
        return  JsonBean.setOK("",baoMings);
    }


}
