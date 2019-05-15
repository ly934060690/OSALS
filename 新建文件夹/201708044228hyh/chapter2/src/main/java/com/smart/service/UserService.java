package com.smart.service;

//调用DAO层完成业务逻辑操作，事务管理

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//UserService标注为一个服务层的Bean

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    //自动装配Bean

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    //自动装配Bean

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao){
        this.loginLogDao=loginLogDao;
    }

    //检查用户名/密码的正确性

    public boolean hasMatchUser(String userName,String password){
        int mathchCount=userDao.getMatchCount(userName,password);
        return mathchCount>0;
    }

    //以用户名为条件加载User对象

    public User findUserByUserName(String username){
        return userDao.findUserByUserName(username);
    }

    //用户登录成功则调用，事务性数据操作，更新登录时间和ip，Transaction事务注解

    @Transactional("transactionManager")
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());

        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        //更新用户积分。最后登录IP及最后登录时间
        userDao.updateLoginInfo(user);
        //登录日志插入
        loginLogDao.insertLoginLog(loginLog);
    }
}
