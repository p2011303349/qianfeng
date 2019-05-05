package com.qianfeng.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2019/4/27.
 */
@Data
@ToString
public class Partner {
    private Integer id;
    private Integer pid;
    private Integer ages;
    private Integer highs;
    private Integer marriages;
    private String incomes;
    private String educations;
    private String address;
    private String character;
}
