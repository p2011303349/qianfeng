package com.qianfeng.controller;

import com.qianfeng.entity.Action;
import com.qianfeng.entity.Comments;
import com.qianfeng.entity.Dynamic;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("findPosition.do")
    public JsonBean UserPosition(){
        List<User> list = userService.findPosition();
        return JsonBean.setOK("查找成功",list);
    }

    @GetMapping("findByPosition.do")
    public JsonBean findByPosition(String position) {
        List<User> list = userService.findByPosition(position);
        return JsonBean.setOK("查找成功", list);
    }

    @GetMapping("user/register.do")
    public JsonBean register(String phone, String password){
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        int i = userService.insertSelective(user);
        if (i != 0){
            return JsonBean.setOK("注册成功！",null);
        }else {
            return JsonBean.setERROR("注册失败！",null);
        }
    }


    @GetMapping("editInfo.do")
    public JsonBean editInfo(User user) {
        userService.editInfo(user);
        return JsonBean.setOK("编辑成功", null);
    }

    @GetMapping("changePassword.do")
    public JsonBean changePassword(String phone,String password,String newpassword) {
        userService.findPassword(phone,password);

        userService.changePassword(phone,newpassword);
        return JsonBean.setOK("编辑成功", null);
    }

    @GetMapping("focusPerson.do")
    public JsonBean focusPerson(String phone) {
        List<VUser> list = userService.focusPerson(phone);


        return JsonBean.setOK("查找成功", list);
    }

    @GetMapping("action1.do")
    public JsonBean findAction1(String phone) {
        List<Action> list = userService.findAction1(phone);


        return JsonBean.setOK("查找成功", list);
    }

    @GetMapping("action2.do")
    public JsonBean findAction2(String phone) {
        List<Action> list = userService.findAction2(phone);


        return JsonBean.setOK("查找成功", list);
    }

    @RequestMapping(value = "photoupload.do", method = RequestMethod.POST)

    public JsonBean uploadHead(@RequestParam("file") MultipartFile file, HttpSession session) {
        /*Map<String, Object> map = new HashMap<>();*/

        try {
            if (file != null) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //截取扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".jpeg");
                list.add(".gif");
                if(list.contains(extName.toLowerCase())){

                    //01获取服务器项目部署的路径，并在根目录下创建 myphoto 目录
                    String realPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static";
                    //02也可以直接定义文件路径
                    /*String realPath = "D:\\space\\SSMBase\\src\\main\\webapp\\img";*/

                    String photoFileName = new Date().getTime()+extName;
                    String descPath = "..\\static\\" + photoFileName;

                    /*System.out.println(descPath);*/
                    file.transferTo(new File(realPath,photoFileName));
                   /* map.put("code", 0); // 0 表示成功
                    map.put("msg", descPath);*/
                    System.out.println(realPath);
                    return JsonBean.setOK("上传成功", descPath);
                    /*return map;//成功*/
                }else {

                    return JsonBean.setERROR("上传失败", null);//文件类型不正确
                }
            }else {

                return JsonBean.setERROR("上传失败", null);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();

            return JsonBean.setERROR("上传失败", null);//上传异常
        }
    }

    @GetMapping("addDynamic.do")
    public JsonBean addDynamic(String phone,String photo,String ddesc) {
        Dynamic dy = new Dynamic();
        dy.setUphone(phone);
        dy.setPhoto(photo);
        dy.setDdesc(ddesc);
        userService.addDynamic(dy);
        return JsonBean.setOK("新增成功", null);
    }

    @GetMapping("dynamicList.do")
    public JsonBean dynamicList() {
        List<Dynamic> list = userService.dynamicList();


        return JsonBean.setOK("查找成功", list);
    }

    @GetMapping("focus.do")
    public JsonBean focus(String phone) {
        userService.focus(phone);


        return JsonBean.setOK("关注成功", null);
    }

    @GetMapping("keepOut.do")
    public JsonBean keepOut(String phone) {
        userService.keepOut(phone);


        return JsonBean.setOK("屏蔽成功", null);
    }

    @GetMapping("addComments.do")
    public JsonBean addComments(Integer id,String comments) {
        Comments c = new Comments();
        c.setCtime(new Date());
        c.setComments(comments);
        c.setDid(id);
        userService.addComments(c);
        return JsonBean.setOK("新增成功", null);
    }


}
