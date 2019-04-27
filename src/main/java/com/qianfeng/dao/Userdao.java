package com.qianfeng.dao;

import com.qianfeng.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2019/4/27.
 */
@Mapper
public interface Userdao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    public int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
