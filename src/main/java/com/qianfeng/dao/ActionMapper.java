package com.qianfeng.dao;

import com.qianfeng.entity.Action;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Action record);

    int insertSelective(Action record);

    public Action selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);

    List<Action> selectAll();
}