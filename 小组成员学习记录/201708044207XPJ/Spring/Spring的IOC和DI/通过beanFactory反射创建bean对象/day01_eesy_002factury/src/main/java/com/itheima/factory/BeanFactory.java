package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 是一个创建Bean对象的工厂
 * Bean，在计算机英语中，有可重复使用组件的意思
 * JavaBean:用java语言编写的可重用组件
 *      JavaBean > 实体类
 *      他就是创建我们的Service和Dao对象的
 *
 *      第一：需要一个配置文件来配置我们的Service和Dao
 *              配置内容：唯一标志=全限定类名(key=value)
 *      第二：通过配置文件中配置的内容，反射创建对象
 *
 *      配置文件xml和properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map用于存放要创建的对象-容器
    private static Map<String,Object> beans;

    //使用讲台代码块为Properties对象赋值
    static {
        try {
            props = new Properties();
            //获取propertise文件的流对象，ClassLoader类加载器，ResourceAsStream流资源
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //从.properties属性文件对应的文件输入流中,加载属性列表到Properties类对象
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的bean
            Enumeration keys =props.keys();
            while(keys.hasMoreElements()){
                //取出每个keys
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象，全限定类名
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入到容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw  new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    public static Object getBean(String beanName){
        //获取与beanName对应的对象
        return beans.get(beanName);
    }
    /**
     *根据Bean的名称过去bean对象
     * @return

    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            //每次都会调用默认构造函数创建对象
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
     */
}
