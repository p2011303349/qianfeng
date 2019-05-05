package com.qianfeng.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2019/4/27.
 */
@Data
@ToString
public class Picture {
    private Integer id;
    private Integer uid;
    private String img;
    private Integer type;
}
