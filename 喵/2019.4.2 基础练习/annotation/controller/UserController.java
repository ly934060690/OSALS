package com.atguigu.spring.beans.annotation.controller;

import com.atguigu.spring.beans.annotation.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * @Auther: LBW
 * @Date: 2019/4/2
 * @Description: com.atguigu.spring.beans.annotation.controller
 * @version: 1.0
 */

@Controller("userController") //相当于在bean中配置id

public class UserController
{
    private UserService userService;

    public void execute()
    {
        System.out.println("UserController execute...");
        userService.add();
    }


}
