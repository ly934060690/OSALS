package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as1 = (IAccountService)ac.getBean("accountServiceImpl");
        //IAccountService as2 = (IAccountService)ac.getBean("accountServiceImpl");
        //System.out.println(as1);
        //IAccountDao adao = ac.getBean("accountDao1",IAccountDao.class);
        //System.out.println(adao);
        as1.saveAccount();
        //将容器关闭，单例bean对象才会释放，多例对象的释放spring不负责
        ac.close();
        //System.out.println(as1==as2);
    }
}
