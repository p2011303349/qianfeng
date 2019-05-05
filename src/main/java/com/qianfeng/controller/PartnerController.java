package com.qianfeng.controller;

import com.qianfeng.entity.Partner;
import com.qianfeng.service.PartnerService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/5/4.
 */
@RestController
public class PartnerController {
    @Autowired
    private PartnerService partnerService;
    //发布自己的目标配偶标准
    @RequestMapping("partner.do")
    public JsonBean addPartener(Partner partner){
        partnerService.insertSelective(partner);
        return JsonBean.setOK("添加成功",null);
    }
    //根据pid查询当事人的择偶信息
    @RequestMapping("findByPid.do")
    public JsonBean findPartener(int pid){
        Partner partner = partnerService.findByPid(pid);
        return  JsonBean.setOK("",partner);
    }


}
