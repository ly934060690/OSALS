package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Description: @Autowire实现Bean依赖的自动装配
 * @Date:Created in 17:56 2019/4/29
 * @Modified By:
 */
@Service
public class LoginService {
    //分别注入LoginDao和UserDao

    //@Autowired
    private LoginDao loginDao;

    //当有多个匹配的Bean是用@Qualifier限定注入Bean的名称

   // @Autowired
    //@Qualifier("userDao")
    private UserDao userDao;


    public LoginDao getLoginDao() {
        return loginDao;
    }

    //@Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    /**
    *@Description: @Autowired 可对类成员变量和方法入参进行标注
    *@Date: 18:21 2019/4/29
    */
   // @Autowired
   // @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void Init(@Qualifier("userDao") UserDao userDao,LoginDao loginDao){
        System.out.println("multi param inject");
        this.userDao=userDao;
        this.loginDao=loginDao;
    }
}
