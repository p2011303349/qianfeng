package com.qianfeng.service;

import com.qianfeng.entity.Action;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
public interface ActionService {
   List<Action> selectAll();
   public Action selectByPrimaryKey(Integer id);
}
