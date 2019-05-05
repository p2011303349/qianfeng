package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.entity.Partner;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.*;
import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //展示所有的职位，已在后台去重
    @GetMapping("findPosition.do")
    public JsonBean UserPosition(){
        List<User> list = userService.findPosition();
        return JsonBean.setOK("查找成功",list);
    }
    //按照职位查询
    @GetMapping("findByPosition.do")
    public JsonBean findByPosition(String position) {
        List<User> list = userService.findByPosition(position);
        return JsonBean.setOK("查找成功", list);
    }
    //注册
    @PostMapping("user/register.do")
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
//图片的上传，完善user的信息
    @RequestMapping(value = "user/addUser.do", method = RequestMethod.POST)
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file, User user) {
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
                    //String realPath = ResourceUtils.getURL("classpath:").getPath();
                    //System.out.println(realPath);
                    String realPath = "E:\\aaa\\QianFeng\\src\\main\\resources\\static\\img";
                    String photoFileName = new Date().getTime()+extName;
                    String descPath = realPath + photoFileName;
                    user.setImg("/img/"+photoFileName);
                   // System.out.println(user1.getId());
//                    User user1 = (User) session.getAttribute(CommonInfo.LOGIN_USER);
//                    System.out.println(user1.getId());
                    System.out.println(user.getImg());
                    System.out.println(user.getName());
                    System.out.println(user.getPhone());

                    /*System.out.println(descPath);*/
                    file.transferTo(new File(realPath,photoFileName));

                    userService.updateUser(user);
                    return JsonBean.setOK("成功",descPath);//成功
                }else {
                    return JsonBean.setERROR("文件类型不正确",null);//文件类型不正确
                }
            }else {
                return JsonBean.setERROR("上传文件为空",null);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBean.setERROR("上传异常",null);//上传异常
        }
    }
    //在介绍页中的按条件筛选
    @GetMapping("findCondition.do")
    public JsonBean findCondition(User user) {
        List<User> list = userService.findCondition(user);
        return JsonBean.setOK("查找", list);
    }



}
