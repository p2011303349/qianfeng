package com.qianfeng.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Data
@ToString
public class VUser {
    private String name;
    private String dname;
    private  String ddesc;
    private Date dtime;
    private Integer flag;

}
