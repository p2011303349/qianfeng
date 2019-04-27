package com.qianfeng.service;

import com.qianfeng.entity.User;
import com.qianfeng.vo.JsonBean;

/**
 * Created by Administrator on 2019/4/27.
 */
public interface UserService {

    public JsonBean login(String phone, String password);

    public User findByUsername(String phone);

    public int insertSelective(User user);


}
