package com.qianfeng.service.impl;

import com.qianfeng.dao.BaoMingMapper;
import com.qianfeng.entity.BaoMing;
import com.qianfeng.service.BaoMingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
@Service
public class BaoMingServiceImpl implements BaoMingService{
    @Autowired
    private BaoMingMapper baoMingDao;
    @Override
    public List<BaoMing> selectByaid(Integer aid) {
        List<BaoMing> baoMings = baoMingDao.selectByaid(aid);
        return  baoMings;
    }

    @Override
    public int insertSelective(BaoMing record) {
      return baoMingDao.insertSelective(record);

    }
}
