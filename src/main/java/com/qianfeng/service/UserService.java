package com.qianfeng.service;

import com.qianfeng.entity.User;
import com.qianfeng.vo.JsonBean;

import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
public interface UserService {

    public User login(String phone, String password);


    public User login1(String phone);

    public List<User> findPosition();


    public List<User> findByPosition(String position);



    public int insertSelective(User user);



}
