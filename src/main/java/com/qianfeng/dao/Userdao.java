package com.qianfeng.dao;

import com.qianfeng.entity.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by Administrator on 2019/4/27.
 */
@Mapper
public interface Userdao {

    int save();
    @Select("select * from user where phone = #{phone}")
    public User selectUserByPhone(String phone);
    @Select("select distinct position from user")
    public List<User> findPosition();
    @Select("select * from user where position = #{position}")
    public List<User> findByPosition(@Param("position") String position);


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    public int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
