package com.aaa.rent.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * className:UserController
 * discription:
 * author:luRuiHua
 * createTime:2018-11-30 15:59
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    /**
     * 跳转老师页面
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher() {
        return "back/teacher";
    }
    /**
     * 跳转学生页面
     * @return
     */
    @RequestMapping("/student")
    public String student() {
        return "back/student";
    }
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "back/welcome";
    }
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }
    /**
     * 跳转欢迎页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String userName, String passWord, Model model) {
        System.out.println("账号是："+userName);

        //shiro的关键代码，执行认证功能
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        //3.执行登陆方法
        try {
            //登陆成功
            subject.login(usernamePasswordToken);
            model.addAttribute("msg","登陆成功");
            //跳到欢迎页面
            return "back/welcome";
        } catch (UnknownAccountException e) {//用户名不存在的异常
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {//用户名和密码错误
            model.addAttribute("msg","用户名和密码错误");
            return "login";
        }
    }

}
