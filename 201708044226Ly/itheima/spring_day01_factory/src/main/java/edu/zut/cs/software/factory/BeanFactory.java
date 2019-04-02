package edu.zut.cs.software.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Properties;

/**
 * 创建Been对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义
 *JavaBean：用java语言编写的可重用组件
 *      javabean > 实体类
 * 它就是创建我们的service和dao对象的
 *
 *      1：需要一个配置文件来配置我们的service和dao
 *          配置的内容：唯一标志 = 全限定类名 （key = value）
 *      2：通过读取配置文件中配置的内容，反射创建对象
 *
 * 我们的配置文件：xml和properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            properties.load(inputStream);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }

    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
        System.out.println("beanPath:" + beanPath);
        try {
            bean = Class.forName(beanPath).newInstance();
            System.out.println("bean:" + bean);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
