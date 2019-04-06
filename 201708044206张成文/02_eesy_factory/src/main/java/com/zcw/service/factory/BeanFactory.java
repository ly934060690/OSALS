package com.zcw.service.factory;

/**
 * 一个创建Bean对象的工厂   创建我们的service和dao对象的
 *
 * 1.需要一个配置文件来配置我们的service和dao
 *    配置的内容，唯一标识=全限定类名（key=value）
 * 2.通过读取配置文件中的配置内容，反射创建对象
 *
 *
 * 配置文件可以是xml和properties（相对简单）
 *
 * Bean 在计算机英语中  有可重用组件的含义
 * Javabean！=实例类
 * Javabean>实体类  用java语言编写的可重用组件
 *
 *
 */
public class BeanFactory {
}
