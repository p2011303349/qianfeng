package com.qianfeng.dao;

import com.qianfeng.entity.Action;
import com.qianfeng.entity.Comments;
import com.qianfeng.entity.Dynamic;
import com.qianfeng.entity.User;


import com.qianfeng.vo.VDynamic;
import com.qianfeng.vo.VUser;
import org.apache.ibatis.annotations.*;

import java.util.List;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.servlet.Registration;
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
            "on u.phone = ud.lphone\n" +
            "INNER JOIN dynamic d\n" +
            "on ud.uphone = d.uphone\n" +
            "WHERE u.phone = phone and ud.flag = 1")
    public List<VUser> focusPerson(String phone);

    public List<Action> findAction1(@Param("phone")String phone);

    public List<Action> findAction2(@Param("phone")String phone);

    public void addDynamic(Dynamic dy);
    @Select("select d.id,d.dname,u.img,d.dtime,d.ddesc,d.flag,d.photo from dynamic d\n" +
            "\t\tinner JOIN user u\n" +
            "\t\ton d.uphone = u.phone\n" +
            "\t\twhere d.flag != 2")
    public List<VDynamic> dynamicList();

    public void focus(String phone);

    public void keepOut(String phone);
    @Insert("insert into comments (did,comments,ctime) values (#{did},#{comments},#{ctime})")
    public void addComments(Comments c);
}
