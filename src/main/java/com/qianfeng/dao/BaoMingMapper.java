package com.qianfeng.dao;

import com.qianfeng.entity.BaoMing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaoMingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaoMing record);

    int insertSelective(BaoMing record);

   List<BaoMing> selectByaid(Integer aid);

    int updateByPrimaryKeySelective(BaoMing record);

    int updateByPrimaryKey(BaoMing record);


}