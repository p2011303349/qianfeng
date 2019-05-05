package com.qianfeng.service;

import com.qianfeng.entity.Partner;
import com.qianfeng.entity.User;

/**
 * Created by Administrator on 2019/5/4.
 */
public interface PartnerService {
    int insertSelective(Partner record);

    public Partner findByPid(int id);

}
