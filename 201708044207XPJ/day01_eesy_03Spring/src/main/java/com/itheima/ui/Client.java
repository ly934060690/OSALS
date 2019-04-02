package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取Spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个实现类
     *      ClassPathXmlApplicationContext 可以加载类路径下的配置文件
     *      FileSystemApplicationContext 可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext 读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题
     *      ApplicationContext：单例对象适用   多用
     *          它在创建核心容器是，创建对象采取的策略是立即加载的方式——读取完配置文件，立刻创建配置文件中配置的对象
     *      BeanFactory：       多例对象适用
     *          它在构建核心容器是，创建对象采取的策略是采用延迟加载的方式——什么时候根据id获取对象，什么时候才真正的创建对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\java\\eclipse-workspace\\day01_eesy_03Spring\\src\\main\\resources\\bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //利用字节码强转
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);

        as.saveAccount();
    }
}
