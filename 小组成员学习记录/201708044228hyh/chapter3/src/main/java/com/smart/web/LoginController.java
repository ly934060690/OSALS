package com.smart.web;

//POJO控制器类，负责处理登录请求，完成登录业务
//并根据登录成功与否转向成功页面或失败页面

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController   //spring mvc提供用于Rest服务
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    //负责处理/index.html的请求
    @RequestMapping(value = {"/", "/index.html"})  //配置多个映射路径
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    //负责处理/loginCheck.html的请求
    @RequestMapping(value = "/loginCheck.html" )
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
        boolean isValidUser=userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","用户名或密码错误。");
        }else{
            User user=userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}
