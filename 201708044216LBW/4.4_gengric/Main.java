package com.atguigu.spring.beans.gengric.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/4/4
 * @Description: com.atguigu.spring.beans.gengric.di
 * @version: 1.0
 */
public class Main
{
    public static void main(String []args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans-gengric-di.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
