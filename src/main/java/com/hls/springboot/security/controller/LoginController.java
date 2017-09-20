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


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * 登录的控制器
 */
@Controller
public class LoginController {
    //日志输出信息
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("username", "暂无用户！");
        logger.info("access");
        return "login"; //返回的是页面login
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password, HttpServletRequest request) {
        //通过无参构造来创建登录user
        Users loginUser = new Users(username, password);
        //查询
        Users resultUser = userService.loginQuery(loginUser);
        //获取session
        HttpSession session = request.getSession();
        /**
         * 登录的判断
         */
        if (resultUser == null) {
            logger.info(">>>>>>登录失败，帐号为：" + username + "-密码为：" + password );
            model.addAttribute("message", "<script>alert('登录失败，帐号信息错误！');</script>");
            return "login";
        } else {
            //获取application对象
            ServletContext application = session.getServletContext();
            //将用户信息保存到登录列表
            ArrayList<String> loginList = application.getAttribute("loginList") == null ? new ArrayList<String>() : (ArrayList<String>) application.getAttribute("loginList");
            if (loginList.contains(resultUser.getName())){ //已经登录
                logger.info(">>>>>>登录失败，已经登录！" );
                model.addAttribute("message", "<script>alert('登录失败，已经登录！');</script>");
                return "login";
            }else{
                logger.info("查询到用户：" + username);
                session.setAttribute("currentUser",resultUser);
                loginList.add(resultUser.getName());//将用户保存到登录列表
                application.setAttribute("loginList",loginList);//将列表放到application
                return "index";
            }
        }
    }

    /**
     * 注销
     */
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        Users  user = (Users)session.getAttribute("currentUser");
        String userName = user.getName();
        ServletContext application = session.getServletContext();
        ArrayList<String> loginList = application.getAttribute("loginList") == null ? new ArrayList<String>() : (ArrayList<String>) application.getAttribute("loginList");
        loginList.remove(userName);
        application.setAttribute("loginList",loginList);//将列表放到application
        logger.info("用户列表信息："+loginList);
        return "login";
    }
}
