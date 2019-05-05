package com.qianfeng.service.impl;

import com.qianfeng.dao.ActionMapper;
import com.qianfeng.entity.Action;
import com.qianfeng.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4.
 */
@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionMapper actionDao;
    @Override
    public List<Action> selectAll() {

       return actionDao.selectAll();

    }

    @Override
    public Action selectByPrimaryKey(Integer id) {

       return actionDao.selectByPrimaryKey(id);
    }
}
