package com.smart.reflect;

//java反射机制间接的方式操控目标类

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {

        // -1 通过类装载器获取Car类对象
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.smart.reflect.Car");

        // -2 获取类的默认构造器对象并通过它实例化Car
        Constructor cons=clazz.getDeclaredConstructor((Class[])null);
        Car car=(Car)cons.newInstance();

        // -3 通过反射方法设置属性
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");
        Method setColor=clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed=clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car=initByDefaultConst();
        car.introduce();

        //AppClassLoader,ExtClassloader,ClassLoader三个装载器之间的父子层级关系
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parent loader:"+loader.getParent());
        System.out.println("grandparent loader:"+loader.getParent().getParent());
    }
}
