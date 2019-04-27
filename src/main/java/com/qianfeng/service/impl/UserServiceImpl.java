package com.qianfeng.service.impl;

import com.qianfeng.dao.Userdao;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/4/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private Userdao userDao;
    @Override
    public JsonBean login(String phone, String password) {

        return null;
    }

    @Override
    public User findByUsername(String phone) {
        return null;
    }
}
