package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 *模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
                //该对象被创建了5次，多例对象
                System.out.println(as);
                as.saveAccount();
                //单例对象，对象只被创建一次，成员也只会被初始化一次
        }
        //as.saveAccount();
    }
}
