package com.qianfeng.dao;

import com.qianfeng.entity.Action;
import com.qianfeng.entity.User;


import com.qianfeng.vo.VUser;
import org.apache.ibatis.annotations.*;

import java.util.List;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


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
    /*@Update("update user set name = #{name},age = #{age} ,idcard = #{idcard},email = #{email} where id = #{id}")*/
    public void editInfo(User user);
    @Select("select password from user where phone = #{phone}")
    public String  findPassword(String  phone);
    @Update("update user set password = #{newpassword} where phone = #{phone}")
    public void changePassword(@Param("phone") String phone, @Param("newpassword") String newpassword);
    @Select("SELECT u.name,d.dname,d.ddesc,d.dtime,ud.flag FROM \n" +
            "user u\n" +
            "INNER JOIN user_dynamic ud\n" +
            "on u.id = ud.uid\n" +
            "INNER JOIN dynamic d\n" +
            "on ud.uid = d.uid\n" +
            "WHERE u.phone = phone")
    public List<VUser> focusPerson(String phone);

    public List<Action> findAction(@Param("phone")String phone);
}
