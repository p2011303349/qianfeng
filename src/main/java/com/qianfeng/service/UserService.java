package com.qianfeng.service;

import com.qianfeng.entity.Action;
import com.qianfeng.entity.Comments;
import com.qianfeng.entity.Dynamic;
import com.qianfeng.entity.User;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.VUser;

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


    public void editInfo(User user);

    public void findPassword(String phone, String password);

    public void changePassword(String phone, String newpassword);

    public List<VUser> focusPerson(String phone);

    public List<Action> findAction1(String phone);
    public List<Action> findAction2(String phone);

    public void addDynamic(Dynamic dy);

    public List<Dynamic> dynamicList();

    public void focus(String phone);

    public void keepOut(String phone);

    public void addComments(Comments c);
}
