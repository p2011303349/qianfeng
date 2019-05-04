package com.qianfeng.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/2 0002.
 */
@Data
@ToString
public class Comments {
    private Integer id;
    private String comments;
    private Date ctime;
    private Integer did;

}
