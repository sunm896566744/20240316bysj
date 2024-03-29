package com.byh.biyesheji.controller;
import com.byh.biyesheji.pojo.User;
import com.byh.biyesheji.service.UserService;
import com.byh.biyesheji.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;



/**
 * 后台登陆
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(Model model, String name, String password) throws ParseException {//throws ParseException
        Subject subject = SecurityUtils.getSubject();// 从SecurityUtils中获取subject实例
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {// 在subject中验证
            subject.login(token);// 身份验证 登入
            User us = userService.getByName(name);
            String lastLoginTime = "";
            if(us!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //上次时间
                Date time = us.getLasttime();
                lastLoginTime = sdf.format(time);
                //新时间
//                String format = sdf.format(new Date());//jdk自带的方法转化当前时间为相应字符串格式
                //string转date  不处理时间格式会不理想
//                ParsePosition pos = new ParsePosition(0);
//                Date strtodate = sdf.parse(format);
                us.setLasttime(new Date());
                userService.update(us);

            }
            if (us.getStatus()==1){
                Session session=subject.getSession();
                session.setAttribute("subject", subject);
                session.setAttribute("lastLoginTime",lastLoginTime);
                return "redirect:index";
            }else {
                model.addAttribute("error", "账号已被停用！");
                return "/login";
            }

        } catch (AuthenticationException e) {
            model.addAttribute("error", "验证失败！");
            return "/login";
        }
    }


}