package com.qianfeng.service.impl;

import com.qianfeng.dao.Userdao;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private Userdao userDao;
    @Override
    public User login(String phone, String password) {
        User user = userDao.selectUserByPhone(phone);
        if(user == null){
            throw new RuntimeException("用户名错误");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public User login1(String phone) {
        User user = userDao.selectUserByPhone(phone);
        if(user == null){
            throw new RuntimeException("用户名错误");
        }

        return user;
    }

    @Override
    public List<User> findPosition() {
        List<User> list = userDao.findPosition();
        return list;
    }

    @Override
    public List<User> findByPosition(String position) {
        List<User> list = userDao.findByPosition(position);
        return list;
    }



    public static int randomCode(){

        return (int)(Math.random()*8999)+1000;
    }


    @Override
    public int insertSelective(User user) {

        User user1 = userDao.selectByPhone(user.getPhone());

        if (user1 == null){
            return userDao.insertSelective(user);
        }else {
            return 0;
        }

    }


}
