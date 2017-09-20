package com.hls.springboot.security.controller;

import com.hls.springboot.security.bean.Users;
import com.hls.springboot.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 登录的控制器
 */
@Controller
public class LoginController2 {
    //日志输出信息
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("username","暂无用户！");
        logger.info("access");
        List<Users> list = userService.query();
        model.addAttribute("list",list);
        return "login2"; //返回的是页面login2
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public String login(Model model,String username,String password){

        return username+"--"+password;
    }
}
