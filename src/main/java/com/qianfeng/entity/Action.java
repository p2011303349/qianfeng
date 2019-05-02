package com.qianfeng.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administrator on 2019/4/28 0028.
 */
@Data
@ToString
public class Action {
    private Integer id;
    private Date atime;
    private String place;
    private String notice;
    private Integer cost;
    private Integer flag;
    private String host;
    private String phone;
    private String adesc;



}
