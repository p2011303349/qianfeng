package com.qianfeng.dao;

import com.qianfeng.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
public interface Userdao {
    int save();
    @Select("select * from user where phone = #{phone}")
    public User selectUserByPhone(String phone);
    @Select("select distinct position from user")
    public List<User> findPosition();
    @Select("select * from user where position = #{position}")
    public List<User> findByPosition(@Param("position") String position);
}
