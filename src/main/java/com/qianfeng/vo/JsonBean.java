package com.qianfeng.vo;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/4/23 09:57
 */
@Data
public class JsonBean {
    private int code;
    private String msg;
    private Object data;

    public static JsonBean setOK(String m,Object data){
        JsonBean r=new JsonBean();
        r.setCode(10000);
        r.setData(data);
        r.setMsg(m+"成功");
        return r;
    }
    public static JsonBean setERROR(String m,Object data){
        JsonBean r=new JsonBean();
        r.setCode(10010);
        r.setData(data);
        r.setMsg(m+"失败");
        return r;
    }


}