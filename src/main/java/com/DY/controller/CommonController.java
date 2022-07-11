package com.DY.controller;

import com.DY.entity.User;
import com.DY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller

public class CommonController {
    @Autowired
    private UserService userService;

    @RequestMapping("/tologin")
    public String Tologin(){
        return "../../login";
    }
    @RequestMapping(value ="/login",method= RequestMethod.POST)
    public String Login(String loginName, String password, Model model, HttpSession session) {
        System.out.println("用户名：" + loginName + "密码：" + password);
        User user = userService.querryUserByIdAndName(loginName, password);
        if (user != null) {
            if (user.getStatus().equals("2")) {
                //允许用户登录
                session.setAttribute("login_user", user);
                return "/main";
            } else {
                model.addAttribute("msg", "账户为启用或账户被禁用，请联系管理员");
                return "../../login";
            }

        }
        model.addAttribute("msg", "账户或密码错误，请重新登录");
        return "../../login";
    }

    @RequestMapping(value ="top",method = RequestMethod.GET)
    public String toTop(){
        return "/top";
    }
    @RequestMapping(value ="right",method = RequestMethod.GET)
    public String toRight(){
        return "/right";
    }
    @RequestMapping(value ="left",method = RequestMethod.GET)
    public String toLeft(){
        return "/left";
    }


}
