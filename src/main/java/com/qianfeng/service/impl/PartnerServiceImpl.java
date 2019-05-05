package com.qianfeng.service.impl;

import com.qianfeng.dao.PartnerMapper;
import com.qianfeng.entity.Partner;
import com.qianfeng.entity.User;
import com.qianfeng.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/4.
 */
@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    private PartnerMapper partnerDao;
    @Override
    public int insertSelective(Partner record) {
        Partner p = partnerDao.findByPid(record.getPid());
        if (p != null){
           return partnerDao.updateByPrimaryKeySelective(record);
        }else {
            return  partnerDao.insertSelective(record);
        }
    }

    @Override
    public Partner findByPid(int id) {
       return partnerDao.findByPid(id);
    }
}
