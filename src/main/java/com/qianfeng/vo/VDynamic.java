package com.qianfeng.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
@Data
@ToString
public class VDynamic {

    private Integer id;
    private String img;
    private String dname;
    private Date dtime;
    private String ddesc;
    private String uphone;
    private Integer flag;
    private String photo;

}
