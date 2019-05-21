package com.atguigu.spring.beans.annotation;

import com.atguigu.spring.beans.annotation.controller.UserController;
import com.atguigu.spring.beans.annotation.repository.UserRepository;
import com.atguigu.spring.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/4/2
 * @Description: com.atguigu.spring.beans.annotation
 * @version: 1.0
 */
public class main
{
    public static void main(String []args)
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("Beans-annotation.xml");


        TestObject to = (TestObject) app.getBean("testObject");
        System.out.println("*****: " + to);



        UserController uc = (UserController) app.getBean("userController");
        System.out.println("*****: " + uc);

        UserService us = (UserService) app.getBean("userService");
        System.out.println("*****: " + us);

        UserRepository urp = (UserRepository) app.getBean("userRepository");
        System.out.println("*****: " + urp);

    }
}
