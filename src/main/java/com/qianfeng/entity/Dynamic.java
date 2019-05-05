package com.qianfeng.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/2 0002.
 */
@Data
@ToString
public class Dynamic {
    private Integer id;
    private String dname;
    private Date dtime;
    private String ddesc;
    private String uphone;
    private Integer flag;
    private String photo;
}
