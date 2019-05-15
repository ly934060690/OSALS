package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/applicationContext.xml")                 //启动Spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private UserService userService;

    @Autowired                    //自动装配bean
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @Test                //标注测试方法
    public void hasMatchUser(){                       //检查用户名/密码的正确性
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","1111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test                //标注测试方法
    public void findUserByUserName(){               //以用户名为条件加载User对象
        User user=userService.findUserByUserName("admin");
        assertEquals(user.getUserName(),"admin");
    }
}
