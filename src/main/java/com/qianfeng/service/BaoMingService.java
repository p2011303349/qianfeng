package com.qianfeng.service;

import com.qianfeng.entity.BaoMing;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
public interface BaoMingService {
    List<BaoMing>  selectByaid(Integer aid);

    int insertSelective(BaoMing record);
}
