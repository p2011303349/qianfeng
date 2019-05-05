package com.qianfeng.service.impl;

import com.qianfeng.dao.Userdao;
import com.qianfeng.entity.Action;
import com.qianfeng.entity.Comments;
import com.qianfeng.entity.Dynamic;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.VDynamic;
import com.qianfeng.vo.VUser;
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

        User user1 = userDao.selectUserByPhone(user.getPhone());

        if (user1 == null){
            return userDao.insertSelective(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }

    }

    @Override
    public void editInfo(User user) {
        userDao.editInfo(user);
    }

    @Override
    public void findPassword(String phone, String password) {
        if(!userDao.findPassword(phone).equals(password)){

            throw new RuntimeException("原密码不对");
        }


    }

    @Override
    public void changePassword(String phone, String newpassword) {
        userDao.changePassword(phone,newpassword);
    }

    @Override
    public List<VUser> focusPerson(String phone) {

        return userDao.focusPerson(phone);
    }

    @Override
    public List<Action> findAction1(String phone) {
        return userDao.findAction1(phone);
    }

    @Override
    public List<Action> findAction2(String phone) {
        return userDao.findAction2(phone);
    }

    @Override
    public void addDynamic(Dynamic dy) {
        userDao.addDynamic(dy);
    }

    @Override
    public List<VDynamic> dynamicList() {
        return userDao.dynamicList();
    }

    @Override
    public void focus(String phone) {
        userDao.focus(phone);
    }

    @Override
    public void keepOut(String phone) {
        userDao.keepOut(phone);
    }

    @Override
    public void addComments(Comments c) {
        userDao.addComments(c);
    }


}
